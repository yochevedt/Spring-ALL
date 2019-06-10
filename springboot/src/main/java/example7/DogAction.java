package example7;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DogAction {
	ActionType actionType = ActionType.BARK;
	int numberOfTimes;
	boolean happy;

}
