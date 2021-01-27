## AOP

#### 1、什么是AOP

AOP意为：**面向切面编程**，是通过预编译方式和运行期间动态代理的机制实现程序功能的统一维护的一种技术。

实质上是OPP（面向对象开发）的一种延续。

> 使用前需要导maven依赖包

```xml
<dependencies>
    <dependency>
        <groupId>org.aspectj</groupId>
        <artifactId>aspectjweaver</artifactId>
        <version>1.9.4</version>
    </dependency>
</dependencies>
```

 

> 导入AOP自己的依赖包

```xml
xmlns:aop ="http://www.springframework.org/schema/aop"
		http://www.springframework.org/schema/aop
       http://www.springframework.org/schema/aop/spring-aop.xsd
```





#### 方式一：使用Spring的API接口

> 注意！！！
>
> 在Spring动态代理的AOP中，最后返回代理对象的时候，千万不要写成接口的具体实现类。
>
> 因为动态代理的本质应该是代理**接口**！
>
> 这里写成接口实现类会造成代理冲突！
>
> 报错记录：
>
> ```java
> Exception in thread "main" org.springframework.beans.factory.BeanNotOfRequiredTypeException: Bean named 'zhang' is expected to be of type 'com.egertons.service.UserServiceImpl' but was actually of type 'com.sun.proxy.$Proxy10'
> ```



相关代码：

+ 前序日志类：

  ```java
  package com.egertons.log;
  
  import org.springframework.aop.AfterReturningAdvice;
  import org.springframework.stereotype.Component;
  
  import java.lang.reflect.Method;
  
  @Component
  public class AfterLog implements AfterReturningAdvice {
      @Override
      public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
          System.out.println("执行了"+method.getName()+"方法，返回结果为："+o);
      }
  }
  ```

+ 后序日志类：

  ```java
  package com.egertons.log;
  
  import org.springframework.aop.MethodBeforeAdvice;
  import org.springframework.stereotype.Component;
  import java.lang.reflect.Method;
  
  @Component
  public class Log implements MethodBeforeAdvice {
      @Override
      //method：要执行的目标对象的方法
      //objects：参数
      //target：目标对象
      public void before(Method method, Object[] objects, Object target) throws Throwable {
          System.out.println(target.getClass().getName()+"的"+method.getName()+"方法被调用了");
      }
  }
  ```

+ xml配置

  ```xml
  <!-- 方式一：使用Spring的API接口 -->
  <!-- aop配置 -->
  <aop:config>
      <!-- 切入点 -->
      <aop:pointcut id="pointcut" expression="execution(* com.egertons.service.UserServiceImpl.*(..))"/>
      <!-- 执行环绕增加！ -->
      <aop:advisor advice-ref="log" pointcut-ref="pointcut"/>
      <aop:advisor advice-ref="afterLog" pointcut-ref="pointcut"/>
  </aop:config>
  ```

---



#### 方式二、使用自定义类来实现AOP

相关代码：

+ 自定义类（切面）

  ```java
  import org.springframework.stereotype.Component;
  
  @Component
  public class DiyPrintCut {
      public void before(){
          System.out.println("=====before======");
      }
      public void after(){
          System.out.println("======after=======");
      }
  }
  ```

+ xml配置

  ```xml
  <aop:config>
      <aop:aspect ref="diyPrintCut">
          <aop:pointcut id="point" expression="execution(* com.egertons.service.UserServiceImpl.*(..))"/>
          <aop:before method="before" pointcut-ref="point"/>
          <aop:after method="after" pointcut-ref="point"/>
      </aop:aspect>
  </aop:config>
  ```

---

#### 方式三 ：使用注解实现AOP

相关代码：

+ xml支持

  ```xml
  <aop:aspectj-autoproxy/>
  ```

+ 自定义类

  ```java
  import org.aspectj.lang.annotation.Aspect;
  import org.aspectj.lang.annotation.Before;
  import org.springframework.stereotype.Component;
  
  @Component
  @Aspect
  public class AnnoPointCut {
  
      @Before("execution(* com.egertons.service.UserServiceImpl.*(..))")
      public void before(){
          System.out.println("=====方法执行前=====(注解开发)");
      }
  }
  ```

  