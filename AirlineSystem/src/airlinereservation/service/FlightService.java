package airlinereservation.service;

import java.util.List;

import airlinereservation.bean.FlightList;
import airlinereservation.bean.FlightList1;
import airlinereservation.bean.FlightList2;
import airlinereservation.dao.FlightSearchDAO;


public class FlightService {

	public List<FlightList> flightSearch(String dep_airport_code,
			String arr_airport_code) throws Exception {
		// TODO Auto-generated method stub
		List<FlightList> flightList= null;
		try
		{
			flightList = new FlightSearchDAO().flightSearch(dep_airport_code,arr_airport_code);
		}catch(Exception e)
		{
			throw e;
		}
		return flightList;
	}
	
	public List<FlightList1> flightSearch1(String depAirport,String arrAirport,int noStops) throws Exception
	{
		List <FlightList1> flightListWeek1=null;
		try
		{
			flightListWeek1=new FlightSearchDAO().flightSearch1(depAirport,arrAirport,noStops);
		}
		catch(Exception e)
		{
			throw e;
		}
		
		return flightListWeek1;
	}
	
	public List<FlightList2> flightSearch2(String depAirport,String arrAirport,int noStops) throws Exception
	{
		List <FlightList2> flightList2=null;
		try
		{
			flightList2=new FlightSearchDAO().flightSearch2(depAirport,arrAirport,noStops);
		}
		catch(Exception e)
		{
			throw e;
		}
		
		return flightList2;
	}
}



