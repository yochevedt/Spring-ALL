package example5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "example5" })
public class DemoApplication5 {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication5.class, args);
	}
	
	

}
