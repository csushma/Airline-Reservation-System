package airlinereservation.service;

import java.util.List;




import airlinereservation.bean.FareList;
import airlinereservation.dao.FareSearchDAO;

public class FareService {

	public List<FareList> fareSearch(String flight_number) throws Exception {
		// TODO Auto-generated method stub
		List<FareList> fareList= null;
		try
		{
			fareList = new FareSearchDAO().fareSearch(flight_number);
		}catch(Exception e)
		{
			throw e;
		}
		return fareList;
	}
}


