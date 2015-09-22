package airlinereservation.bean;

import java.sql.Time;

public class FlightList1 {
	
	private String flightNumber;
	private String airline;
	private String dep_Airport;
	private Time dep_Time;
	private String level1_Airport;
	private Time arr1_Time;
	private String flight_Number1;
	private Time dep1_Time;
	private String arr_Airport;
	private Time arr_Time;
	private String weekDays;
	/**
	 * @return the flightNumber
	 */
	public String getFlightNumber() {
		return flightNumber;
	}
	/**
	 * @param flightNumber the flightNumber to set
	 */
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	/**
	 * @return the airline
	 */
	public String getAirline() {
		return airline;
	}
	/**
	 * @param airline the airline to set
	 */
	public void setAirline(String airline) {
		this.airline = airline;
	}
	/**
	 * @return the dep_Airport
	 */
	public String getDep_Airport() {
		return dep_Airport;
	}
	/**
	 * @param dep_Airport the dep_Airport to set
	 */
	public void setDep_Airport(String dep_Airport) {
		this.dep_Airport = dep_Airport;
	}
	/**
	 * @return the dep_Time
	 */
	public Time getDep_Time() {
		return dep_Time;
	}
	/**
	 * @param dep_Time the dep_Time to set
	 */
	public void setDep_Time(Time dep_Time) {
		this.dep_Time = dep_Time;
	}
	/**
	 * @return the level1_Airport
	 */
	public String getLevel1_Airport() {
		return level1_Airport;
	}
	/**
	 * @param level1_Airport the level1_Airport to set
	 */
	public void setLevel1_Airport(String level1_Airport) {
		this.level1_Airport = level1_Airport;
	}
	/**
	 * @return the arr1_Time
	 */
	public Time getArr1_Time() {
		return arr1_Time;
	}
	/**
	 * @param arr1_Time the arr1_Time to set
	 */
	public void setArr1_Time(Time arr1_Time) {
		this.arr1_Time = arr1_Time;
	}
	/**
	 * @return the flight_Number1
	 */
	public String getFlight_Number1() {
		return flight_Number1;
	}
	/**
	 * @param flight_Number1 the flight_Number1 to set
	 */
	public void setFlight_Number1(String flight_Number1) {
		this.flight_Number1 = flight_Number1;
	}
	/**
	 * @return the dep1_Time
	 */
	public Time getDep1_Time() {
		return dep1_Time;
	}
	/**
	 * @param dep1_Time the dep1_Time to set
	 */
	public void setDep1_Time(Time dep1_Time) {
		this.dep1_Time = dep1_Time;
	}
	/**
	 * @return the arr_Airport
	 */
	public String getArr_Airport() {
		return arr_Airport;
	}
	/**
	 * @param arr_Airport the arr_Airport to set
	 */
	public void setArr_Airport(String arr_Airport) {
		this.arr_Airport = arr_Airport;
	}
	/**
	 * @return the arr_Time
	 */
	public Time getArr_Time() {
		return arr_Time;
	}
	/**
	 * @param arr_Time the arr_Time to set
	 */
	public void setArr_Time(Time arr_Time) {
		this.arr_Time = arr_Time;
	}
	/**
	 * @return the weekDays
	 */
	public String getWeekDays() {
		return weekDays;
	}
	/**
	 * @param weekDays the weekDays to set
	 */
	public void setWeekDays(String weekDays) {
		this.weekDays = weekDays;
	}
	/**
	 * @param flightNumber
	 * @param airline
	 * @param dep_Airport
	 * @param dep_Time
	 * @param level1_Airport
	 * @param arr1_Time
	 * @param flight_Number1
	 * @param dep1_Time
	 * @param arr_Airport
	 * @param arr_Time
	 * @param weekDays
	 */
	public FlightList1(String flightNumber, String airline, String dep_Airport,
			Time dep_Time, String level1_Airport, Time arr1_Time,
			String flight_Number1, Time dep1_Time, String arr_Airport,
			Time arr_Time, String weekDays) {
		super();
		this.flightNumber = flightNumber;
		this.airline = airline;
		this.dep_Airport = dep_Airport;
		this.dep_Time = dep_Time;
		this.level1_Airport = level1_Airport;
		this.arr1_Time = arr1_Time;
		this.flight_Number1 = flight_Number1;
		this.dep1_Time = dep1_Time;
		this.arr_Airport = arr_Airport;
		this.arr_Time = arr_Time;
		this.weekDays = weekDays;
	}
	
	

}
