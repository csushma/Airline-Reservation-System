package airlinereservation.managedBean;

import java.util.List;

import airlinereservation.bean.FlightList;
import airlinereservation.bean.FlightList1;
import airlinereservation.bean.FlightList2;
import airlinereservation.service.FlightService;


public class FlightSearchMB {

	private String dep_airport_code;
	private String arr_airport_code;
	private int noStops;
	List<FlightList> flightList;
	List<FlightList1> flightList1;
	List<FlightList2> flightList2;
	private String message;	
	
	/**
	 * @return the noStops
	 */
	public int getNoStops() {
		return noStops;
	}


	/**
	 * @param noStops the noStops to set
	 */
	public void setNoStops(int noStops) {
		this.noStops = noStops;
	}


	/**
	 * @return the flightList1
	 */
	public List<FlightList1> getFlightList1() {
		return flightList1;
	}


	/**
	 * @param flightList1 the flightList1 to set
	 */
	public void setFlightList1(List<FlightList1> flightList1) {
		this.flightList1 = flightList1;
	}


	/**
	 * @return the dep_airport_code
	 */
	public String getDep_airport_code() {
		return dep_airport_code;
	}


	/**
	 * @param dep_airport_code the dep_airport_code to set
	 */
	public void setDep_airport_code(String dep_airport_code) {
		this.dep_airport_code = dep_airport_code;
	}


	/**
	 * @return the arr_airport_code
	 */
	public String getArr_airport_code() {
		return arr_airport_code;
	}


	/**
	 * @param arr_airport_code the arr_airport_code to set
	 */
	public void setArr_airport_code(String arr_airport_code) {
		this.arr_airport_code = arr_airport_code;
	}


	/**
	 * @return the flightList
	 */
	public List<FlightList> getFlightList() {
		return flightList;
	}


	/**
	 * @param flightList the flightList to set
	 */
	public void setFlightList(List<FlightList> flightList) {
		this.flightList = flightList;
	}


	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}


	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}


	
	/**
	 * @return the flightList2
	 */
	public List<FlightList2> getFlightList2() {
		return flightList2;
	}


	/**
	 * @param flightList2 the flightList2 to set
	 */
	public void setFlightList2(List<FlightList2> flightList2) {
		this.flightList2 = flightList2;
	}


	/**
	 * @param dep_airport_code
	 * @param arr_airport_code
	 * @param flightList
	 * @param message
	 */
	public FlightSearchMB() {
		super();
	}


	public String flightSearch()
	{
		try
		{
		this.flightList = null;
		this.flightList1 = null;
		this.flightList2 = null;
		FlightService flightService = new FlightService();
		if(this.dep_airport_code.isEmpty() || this.arr_airport_code.isEmpty())
		{
			throw new Exception("Please enter both arrival and departure airport codes");
		}
		if(this.noStops==0)
		{
			flightList= flightService.flightSearch(this.dep_airport_code,this.arr_airport_code);
		}
		if(this.noStops==1)
		{
			//flightList = flightService.flightSearch(this.dep_airport_code,this.arr_airport_code);
			flightList1= flightService.flightSearch1(this.dep_airport_code,this.arr_airport_code,this.noStops);
		}
		if(this.noStops==2)
		{
		//	flightList = flightService.flightSearch(this.dep_airport_code,this.arr_airport_code);
		//	flightList1 = flightService.flightSearch1(this.dep_airport_code,this.arr_airport_code,this.noStops);
			flightList2 = flightService.flightSearch2(this.dep_airport_code,this.arr_airport_code,this.noStops);
		}
		this.setMessage(null);
		return "success";
		}catch(Exception e)
		{
			this.setMessage(e.getMessage());
			return "failure";
		}
		
	}
	
}
