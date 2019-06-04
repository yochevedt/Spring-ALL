package example1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "example1" })
public class DemoApplication1 {

	public static void main(String[] args) {
		System.out.println("Demo app is running");
		SpringApplication.run(DemoApplication1.class, args);
	}

}
