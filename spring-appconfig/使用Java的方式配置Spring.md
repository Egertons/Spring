## 使用Java的方式配置Spring

这个技术点在于完全不使用Spring的xml文件来进行配置，全权交给Java来完成。

JavaConfig 原本是Spring的一个子项目，在Spring4之后成为核心功能，从而推荐使用（更灵活）！



用一个Java类来代替xml文件（绝对的优雅）~

+ 自动支持全Spring注解开发！

+ 相关代码如下：

  + ```java
    package com.zhanglin.config;
    
    import com.zhanglin.demo.User;
    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.Configuration;
    
    @Configuration
    /*
    	被这个注解标注的类也会被Spring托管，注册到容器中！其本身也是一个组件~
    */
    public class MyConfig {
    
        @Bean
        public User getUser(){
            return new User();//即为当前要注入到Bean的对象。
            //如果User是一个接口的话，这里可以返回User的具体实现类。
        }
        
    }
    ```

+ 如果完全使用了配置类的方式去做，就只能通过  AnnotationConfig  上下文来获取容器，通过配置类的class对象加载！

  + ```java
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig.class);
    ```

+ getBean时，以往BeanId的名字即为@Bean注解的方法名。

  + ```java
    User user = applicationContext.getBean("getUser", User.class);
    ```

+ JavaConfig的相关注解

  + @ComponentScan("扫描包名")
    + 和XML文档一样可以指定扫描指定包的类。
  + @Bean
    + 注册一个bean，就相当于之前写的一个bean标签。
    + 这个方法的名字即为Bean的Id；
    + 这个方法的返回值即为标签中的class属性。
  + @Import(配置类的class)

------



> **这种纯Java的配置方式，在SpringBoot中随处可见！**





