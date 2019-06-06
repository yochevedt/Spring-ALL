package example4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "example4" })
public class DemoApplication4 {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication4.class, args);
	}
	
	

}
