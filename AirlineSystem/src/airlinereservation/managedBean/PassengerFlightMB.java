package airlinereservation.managedBean;

import java.util.List;

import airlinereservation.bean.Passenger_Flight;
import airlinereservation.service.PassengerFlightService;

public class PassengerFlightMB {
	private String customer_name;
	List<Passenger_Flight> flightList;
	public String message;
	
	public PassengerFlightMB() {
		this.customer_name = null;
		this.flightList = null;
		this.message = null;
	}
	/**
	 * @return the customer_name
	 */
	public String getCustomer_name() {
		return customer_name;
	}
	/**
	 * @param customer_name the customer_name to set
	 */
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	/**
	 * @return the flightList
	 */
	public List<Passenger_Flight> getFlightList() {
		return flightList;
	}
	/**
	 * @param flightList the flightList to set
	 */
	public void setFlightList(List<Passenger_Flight> flightList) {
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
	
	public String flightSearch()
	{
		try
		{
		this.flightList = null;
		PassengerFlightService flightService = new PassengerFlightService();
		if(this.customer_name.isEmpty())
		{
			throw new Exception("Please enter customer name");
		}
		this.flightList = flightService.flightSearch(this.customer_name);
		this.setMessage(null);
		return "success";
		}catch(Exception e)
		{
			this.setMessage(e.getMessage());
			return "failure";
		}
		
	}

}
