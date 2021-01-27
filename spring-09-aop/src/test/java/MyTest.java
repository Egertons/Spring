import com.egertons.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        //Spring动态代理的是接口！！（千万不要写成具体的实现类）
        UserService userService = (UserService) applicationContext.getBean("zhang");
        userService.add();
    }
}