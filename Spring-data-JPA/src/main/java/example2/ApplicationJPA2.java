package example2;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import example2.dao.HallDao;
import example2.model.Hall;

@SpringBootApplication
@ComponentScan({ "example2" })
public class ApplicationJPA2 {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(ApplicationJPA2.class, args);
		HallDao hallDao = applicationContext.getBean(HallDao.class);
		Hall hall = new Hall();
		hall.setName("My hall");
		hallDao.saveHall(hall);
		
		List<Hall> all = hallDao.getAll();
		System.out.println("Records: \n" + all);
		applicationContext.close();
		
	}
}
