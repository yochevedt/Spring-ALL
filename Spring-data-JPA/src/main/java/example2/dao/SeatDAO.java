package example2.dao;

import java.util.List;

import example2.model.Seat;

public interface SeatDAO {

	void saveSeat(Seat seat);

	Seat getSeatById(long seatId);

	List<Seat> getAll();

}