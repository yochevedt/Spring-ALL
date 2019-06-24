package example2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import example2.model.Hall;

@Repository
public class HallDaoImp implements HallDao {
	@PersistenceContext
	private EntityManager entityManager;

	/*
	 * (non-Javadoc)
	 * 
	 * @see example2.dao.HallDao#saveHall(example2.model.Hall)
	 */
	@Override
	@Transactional
	public void saveHall(Hall hall) {

		entityManager.persist(hall);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see example2.dao.HallDao#getHallById(int)
	 */
	@Override
	public Hall getHallById(int hallId) {
		Hall hall = (Hall) entityManager.find(Hall.class, hallId);
		return hall;
	}
	@Override
	public List<Hall> getAll() {
		  String HSQL = "SELECT hall FROM Hall hall";
		  Query query = entityManager.createQuery(HSQL);
		  List<Hall> employees = (List<Hall>)query.getResultList(); 
		  return employees;

	}

}
