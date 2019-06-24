package example2.dao;

import java.util.List;

import javax.transaction.Transactional;

import example2.model.Hall;

public interface HallDao {

	void saveHall(Hall hall);

	Hall getHallById(int hallId);

	List<Hall> getAll();

}