package example4;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class SingletonBean {
	public int x=(int)(Math.random()*100);
	
	
	@PostConstruct
	public void init() {
		System.out.println("Singleton Inside init method "+x );
	}
	@PreDestroy
	public void destroy(){
		System.out.println("Singleton is going down...");
	}
}
