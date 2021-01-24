#Bean的自动装配
##自动装配(Autowired):
    自动装配是Spring满足bean依赖的一种方式！
    Spring会在上下文中自动寻找，并自动给bean装配属性。
在Spring中有三种装配的方式：
1. 在xml中显示的配置
2. 在java中显示配置
3. 隐式的自动装配bean（重点）
---
##ByName自动装配：
    在配置Bean的时候，设置自动装配，Spring会自动在XML文档中寻找指定名字的bean值进行注入。
+ 弊端：
    - 必须保证beanid与需要进行装配的属性名一致才可以自动装配。反之报错！  
    
 
Eg：
```xml
    <bean id="people" class="com.zhanglin.People" autowire="byName"/>
```  
---
##ByType自动装配：
在配置Bean的时候，设置自动装配，Spring会自动在XML文档中寻找和自己对象属性类型相同的bean进行注入。
+ 弊端:
    - 因为是依据类型来进行装配，所以要确保需装配与被装配的bean的类型”有且唯一“对应
    才可以进行自动装配(条件较为严苛)。

PS:
    在ByType中的bean配置因为不需要检查beanid
    所以原则上连id都不用写了...


#通过注解进行开发：
##使用之前注意事项：
    1.导入约束：context约束
    2.配置注解的支持（重要）
        xmlns:context="http://www.springframework.org/schema/context"
        在以下约束中新填入关于context的约束就行
        xsi:schemaLocation="
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd"
        <context:annotation-config/>
---
##@Autowired
+ 直接在Java文件中，需要进行装配的属性上进行标注即可。
    - 也可以写到相关属性对应的set方法上去（不标准写法）

+ 这个注解的匹配机制是结合了ByName和ByType两种方式的特点。所以只要两者符合其一即可匹配成功。

+ 利用注解实现注入的时候，连set方法都不需要了！！
    > 因为是利用”反射“实现的。
+ 如果显式的定义了Autowired的required属性可以为false(该属性默认为true)
    说明这个属性允许为null，否则不允许为空值。
    Eg：
        @Autowired(required = false)

还可以在属性的构造函数里写@Nullable注解，效果同上！
(该注解为Spring所支持)
    Eg：
        public People(@Nullable Cat cat) {
                this.cat = cat;
        }

我们可以在xml文件中对于一个类进行多个配置（仅id不同）
    在这种情况下，对于实体类中的属性装配，可以结合@Qualifier(value = "XXX")
    来针对性的匹配对应的bean配置。（value中写需要装配的bean的id）

Java原生有一个和@Autowired同等功效的注解---@Resource(javax.annotation)
不需要导Spring依赖就能用，同样的在xml里只要ByName和ByType符合一个就能用。
该注解也有相对应的name等属性，也可是实现指定bean的装配。
（但我好像没测试通过~）应该是JDK版本的问题。