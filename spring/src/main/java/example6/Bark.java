package example6;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data 
@Component
@Scope("prototype")
public class Bark implements BeanNameAware {
	int numberOfTimes = (int) (Math.random()*10);
	private String beanName;

	public void setBeanName(String name) {
		this.beanName = name;
		
	}

}
