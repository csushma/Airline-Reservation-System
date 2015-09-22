package airlinereservation.service;

import java.util.Date;
import java.util.List;
import airlinereservation.bean.PassList;
import airlinereservation.dao.PassengerInfoDAO;

public class PassengerInfoService {

	public List<PassList> passSearch(String flight_number, Date date) throws Exception {
		// TODO Auto-generated method stub
		List<PassList> passList= null;
		try
		{
			passList = new PassengerInfoDAO().passSearch(flight_number,date);
		}catch(Exception e)
		{
			throw e;
		}
		return passList;
	}

}
