package example2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import example2.model.Bus;
import example2.model.Seat;

@Repository
public class SeatDaoImp implements SeatDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public void saveSeat(Seat seat) {
		entityManager.persist(seat);
		
	}

	@Override
	public Seat getSeatById(long seatId) {
		Seat seat = entityManager.find(Seat.class, seatId);
		return seat;
	}

	@Override
	public List<Seat> getAll() {
		String HSQL = "SELECT seat FROM Seat seat";
		Query query = entityManager.createQuery(HSQL);
		List<Seat> seats = (List<Seat>) query.getResultList();
		//System.out.println(bussess);
		return seats;
	}

}
