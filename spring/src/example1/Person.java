package example1;

import org.springframework.stereotype.Component;

@Component("thePerson")
public class Person {

	public void printMe() {
		System.out.println("This is a person class");
	}
}
