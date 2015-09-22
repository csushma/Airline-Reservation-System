package airlinereservation.service;

import java.util.List;

import airlinereservation.bean.Passenger_Flight;
import airlinereservation.dao.PassengerFlightDAO;

public class PassengerFlightService {

	public List<Passenger_Flight> flightSearch(String customer_name) throws Exception {
		// TODO Auto-generated method stub
		List<Passenger_Flight> flightList= null;
		try
		{
			flightList = new PassengerFlightDAO().flightSearch(customer_name);
		}catch(Exception e)
		{
			throw e;
		}
		return flightList;
	}
}


