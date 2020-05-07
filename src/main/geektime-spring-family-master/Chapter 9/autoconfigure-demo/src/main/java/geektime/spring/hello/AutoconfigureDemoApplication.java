package geektime.spring.hello;

//import geektime.spring.hello.greeting.GreetingApplicationRunner;
import com.sun.org.glassfish.gmbal.Description;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
public class AutoconfigureDemoApplication {
        //若注释掉GreetingApplicationRunner的依赖，则不会发生自定义的配置
	public static void main(String[] args) {
		SpringApplication.run(AutoconfigureDemoApplication.class, args);
	}

//	@Bean
//	public GreetingApplicationRunner existenceBeanTest(){
//		return new GreetingApplicationRunner("Test");
//	}

}
