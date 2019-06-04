package example6;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data 
@Component
@Scope("prototype")
public class Head {
	int numberOfEyes = (int) (Math.random()*10);
	

}
