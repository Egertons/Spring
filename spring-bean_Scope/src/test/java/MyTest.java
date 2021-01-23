import com.zhanglin.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        Student student1 = applicationContext.getBean("stu", Student.class);
        Student student2 = applicationContext.getBean("stu",Student.class);
        /*
        * 测试原型模式
        * System.out.println(student1 == student2);
        * 结果为false
        * */
    }
}
