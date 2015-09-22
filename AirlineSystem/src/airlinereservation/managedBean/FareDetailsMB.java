package airlinereservation.managedBean;

import java.util.List;
import airlinereservation.bean.FareList;
import airlinereservation.service.FareService;



public class FareDetailsMB {
	private String flight_number;
	List<FareList> fareList;
	public String message;
	
	public FareDetailsMB() {
		super();
		this.flight_number = null;
		this.fareList = null;
		this.message = null;
	}
	/**
	 * @return the flight_number
	 */
	public String getFlight_number() {
		return flight_number;
	}
	/**
	 * @param flight_number the flight_number to set
	 */
	public void setFlight_number(String flight_number) {
		this.flight_number = flight_number;
	}
	/**
	 * @return the fareList
	 */
	public List<FareList> getFareList() {
		return fareList;
	}
	/**
	 * @param fareList the fareList to set
	 */
	public void setFareList(List<FareList> fareList) {
		this.fareList = fareList;
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
	
	public String fareSearch()
	{
		try
		{
		this.fareList = null;
		FareService fareService = new FareService();
		if(this.flight_number.isEmpty())
		{
			throw new Exception("Please enter flight number");
		}
		this.fareList = fareService.fareSearch(this.flight_number);
		this.setMessage(null);
		return "success";
		}catch(Exception e)
		{
			this.setMessage(e.getMessage());
			return "failure";
		}
		
	}
}
