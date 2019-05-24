package example4;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Primary
public class PrototypeBean {
	
	public int x=(int)(Math.random()*100);

	
	@PreDestroy
	public void destroy(){
		System.out.println("PrototypeBean is going down...");
	}
	
	@PostConstruct
	public void init() {
		System.out.println("PrototypeBean Inside init method "+x );
	}
}