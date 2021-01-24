import com.zhanglin.People;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void test1(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        People people = applicationContext.getBean("people", People.class);
        System.out.println(people.toString());
    }
}
