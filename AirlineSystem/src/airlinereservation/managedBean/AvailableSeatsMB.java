package airlinereservation.managedBean;

import java.util.Date;

import airlinereservation.service.AvailableSeatsService;


public class AvailableSeatsMB {
	private String flight_number;
	Date date;
	int available_seats;
	public String message;
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
	 * @return the available_seats
	 */
	public int getAvailable_seats() {
		return available_seats;
	}
	/**
	 * @param available_seats the available_seats to set
	 */
	public void setAvailable_seats(int available_seats) {
		this.available_seats = available_seats;
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
	public AvailableSeatsMB() {
		super();
		this.flight_number = null;
		this.date = null;
		this.available_seats = 0;
		this.message = null;
	}
	
	public String seatSearch()
	{
		try
		{
		this.available_seats = 0;
		AvailableSeatsService seatService = new AvailableSeatsService();
		if(this.flight_number.isEmpty())
		{
			throw new Exception("Please enter flight number");
		}
		else if(this.date == null){
			throw new Exception("Please enter Date");
		}
		
		this.available_seats = seatService.seatSearch(this.flight_number,this.date);
		this.setMessage(null);
		return "success";
		}catch(Exception e)
		{
			this.setMessage(e.getMessage());
			return "failure";
		}
		
	}
	
}
