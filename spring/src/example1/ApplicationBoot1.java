package example1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({ "example1" })
public class Application1 {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Application1.class);
		Person person = ctx.getBean("thePerson", Person.class);
		person.printMe();
		ctx.close();
	}
}
