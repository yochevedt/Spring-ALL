package example4;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({ "example4" })
public class Application4 {
	
	

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Application4.class);
		ComposedBean b6=ctx.getBean(ComposedBean.class);
		
		ctx.close();
	}
}
