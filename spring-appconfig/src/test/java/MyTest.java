import com.zhanglin.config.MyConfig;
import com.zhanglin.demo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig.class);
        User user = applicationContext.getBean("getUser", User.class);
        System.out.println(user.getName());
    }
}
