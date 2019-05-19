package example5;

import org.springframework.stereotype.Component;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.ToString;

@Component
@Data 
@Builder
@ToString
public class LombokBeanB {

	private @NonNull int  value;
	private @NonNull boolean flag;
	private @NonNull String  word;
	
}
