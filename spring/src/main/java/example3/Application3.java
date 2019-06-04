package example3;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan({ "example3" })
public class Application3 {
	
	@Bean
	@Primary
	public Person thePerson1() {
		System.out.println("Person1 creating bean");
		return new Person(1);
	}
	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Person thePerson2() {
		System.out.println("Person2 creating bean");
		return new Person(2);
	}


	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Application3.class);
		Person person1 = ctx.getBean("thePerson1", Person.class);
		person1.printMe();
		Person person2 = ctx.getBean("thePerson2", Person.class);
		person2.printMe();
		Person person3 = ctx.getBean( Person.class);
		person3.printMe();
		person2 = ctx.getBean("thePerson2", Person.class);
		person2.printMe();
		ctx.close();
	}
}
