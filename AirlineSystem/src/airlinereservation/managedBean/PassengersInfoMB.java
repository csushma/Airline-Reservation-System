package airlinereservation.managedBean;
import java.util.Date;
import java.util.List;

import airlinereservation.bean.PassList;
import airlinereservation.service.PassengerInfoService;


public class PassengersInfoMB {
	private String flight_number;
	Date date;
	List<PassList> passList;
	public String message;
	
	
	public PassengersInfoMB() {
		super();
		this.flight_number = null;
		this.date = null;
		this.passList = null;
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
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * @return the passList
	 */
	public List<PassList> getPassList() {
		return passList;
	}
	/**
	 * @param passList the passList to set
	 */
	public void setPassList(List<PassList> passList) {
		this.passList = passList;
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
	
	public String passSearch()
	{
		try
		{
		this.passList = null;
		PassengerInfoService passService = new PassengerInfoService();
		if(this.flight_number.isEmpty())
		{
			throw new Exception("Please enter flight number");
		}
		else if(this.date == null){
			throw new Exception("Please enter Date");
		}
		this.passList = passService.passSearch(this.flight_number,this.date);
		this.setMessage(null);
		return "success";
		}catch(Exception e)
		{
			this.setMessage(e.getMessage());
			return "failure";
		}
		
	}
}
