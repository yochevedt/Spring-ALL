package example2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({ "example2" })
public class Application2 {
	
	@Bean
	public Person thePerson() {
		return new Person();
	}

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Application2.class);
		Person person = ctx.getBean("thePerson", Person.class);
		person.printMe();
		ctx.close();
	}
}
