import com.zhanglin.server.UserServer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        UserServer userServer = applicationContext.getBean("userServer", UserServer.class);
        userServer.run();
    }
}
