package example6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "example6" })
public class DemoApplication6 {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication6.class, args);
	}
	
	

}
