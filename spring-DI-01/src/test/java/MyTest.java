import com.zhang.pojo.Student;
import com.zhang.pojo.User;
import com.zhang.pojo.jojo;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = applicationContext.getBean("stu", Student.class);
    }
    @Test
    public void test2(){
        /*
        * JUnit这样的测试工具好像可以测试任意一个类~~
        * 测试P命名空间
        * */
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = applicationContext.getBean("user", User.class);
        System.out.println(user.toString());
    }

    @Test
    public void test3(){
        //测试C命名空间
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        jojo jojo = applicationContext.getBean("jojo",jojo.class);
        System.out.println(jojo.toString());
    }
}
