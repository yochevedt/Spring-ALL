package example7.model;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component()
@Scope("prototype")
public class Dog implements ApplicationContextAware, BeanNameAware  {

	private String name = "DogName" + ((int) (Math.random()*1000));
	@Autowired
	private Head head;
	
	//Aware interface state
	private ApplicationContext applicationContext;
	private String beanName;
	
	
	public void setBeanName(String name) {
		this.beanName = name;
		
	}
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
	
	public Bark bark1() {
		return new Bark();
	}

	public Bark bark2() {
		return applicationContext.getBean("bark",Bark.class);
	}
	@Lookup
	public Bark bark3() {
		return new Bark();
	}

	

}
