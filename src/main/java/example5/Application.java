package example5;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"example5"})
public class Application {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(Application.class);
		
		
		LombokBeanA lombokA=ctx.getBean(LombokBeanA.class);
		lombokA.setValue(5);
		lombokA.setFlag(false);
		System.out.println(lombokA);
		lombokA.setWord(null);
		LombokBeanB lombokB=ctx.getBean(LombokBeanB.class);
		//lombokB.setWord(null);
		
		lombokB = LombokBeanB.builder().flag(false).value(0).word("Builder").build();
		System.out.println(lombokB);
		ctx.close();
	}
	
}
