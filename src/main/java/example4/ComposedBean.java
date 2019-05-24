package example4;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class ComposedBean {
	//@Autowired
	//@Qualifier("proto6")
	private PrototypeBean proto;
	//@Autowired
	private SingletonBean single;
	
	public ComposedBean() {
		
	}
	public ComposedBean(PrototypeBean proto, SingletonBean single){
		this.proto=proto;
		this.single=single;
	}
	
	public int getProtoX(){
		return proto.x;
	}
	
	public int getSingleX(){
		return single.x;
	}
	
	public void show(){
		System.out.println("@@@");
	}
	
	@PreDestroy
	public void destroy(){
		System.out.println("ComposedBean is going down...");
	}
	@PostConstruct
	public void init() {
		System.out.println("ComposedBean Inside init method " );
	}
}
