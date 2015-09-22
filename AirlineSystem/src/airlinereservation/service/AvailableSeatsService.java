package airlinereservation.service;

import java.util.Date;

import airlinereservation.dao.AvailableSeatsDAO;

public class AvailableSeatsService {

	public int seatSearch(String flight_number, Date date) throws Exception {
		// TODO Auto-generated method stub
		int available_seats;
		try
		{
			available_seats = new AvailableSeatsDAO().seatSearch(flight_number,date);
		}catch(Exception e)
		{
			throw e;
		}
		return available_seats;
	}

}
