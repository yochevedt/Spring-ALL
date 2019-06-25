package example2;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import example2.dao.BusDao;
import example2.dao.SeatDAO;
import example2.model.Bus;
import example2.model.Seat;

@SpringBootApplication
@ComponentScan({ "example2" })
public class ApplicationJPA3 {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(ApplicationJPA3.class, args);
		BusDao busDao = applicationContext.getBean(BusDao.class);
		SeatDAO seatDao = applicationContext.getBean(SeatDAO.class);
		Bus bus = new Bus();
		bus.setName("My bus");
		busDao.saveBus(bus);
		
		List<String> rowLetters = Arrays.asList("A","B","C");
		int numberOfSeatForEachRow = 4;
		for (String rawLetter : rowLetters) {
			for (int seatNumber = 1; seatNumber <= numberOfSeatForEachRow; seatNumber++) {
				Seat seat = new Seat();
				seat.setBus(bus);
				seat.setNumber(seatNumber);
				seat.setRawLetter(rawLetter);
				seatDao.saveSeat(seat);
			}
		}
		
		
		List<Bus> all = busDao.getAll();
		System.out.println("Records: \n" + all);
		
		bus = busDao.getBusById(bus.getId());
		
		bus.getSeats().get(0).setRawLetter("Z");
		busDao.saveBus(bus);
		
		bus.setName(bus.getName() + " change it");
		busDao.saveBus(bus);
		
		seatDao.saveSeat(bus.getSeats().get(0));
		
		applicationContext.close();
		
	}
}
