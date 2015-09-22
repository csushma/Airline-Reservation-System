package airlinereservation.bean;

import java.sql.Time;

public class FlightList {
	private String flight_number;
	private String airline;
	private String weekdays;
	private String dep_airport_code;
	private Time sch_dep_time;
	private String arr_airport_code;
	private Time sch_arr_time;
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
	 * @return the weekdays
	 */
	public String getWeekdays() {
		return weekdays;
	}
	/**
	 * @param weekdays the weekdays to set
	 */
	public void setWeekdays(String weekdays) {
		this.weekdays = weekdays;
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
	 * @return the sch_dep_time
	 */
	public Time getSch_dep_time() {
		return sch_dep_time;
	}
	/**
	 * @param sch_dep_time the sch_dep_time to set
	 */
	public void setSch_dep_time(Time sch_dep_time) {
		this.sch_dep_time = sch_dep_time;
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
	 * @return the sch_arr_time
	 */
	public Time getSch_arr_time() {
		return sch_arr_time;
	}
	/**
	 * @param sch_arr_time the sch_arr_time to set
	 */
	public void setSch_arr_time(Time sch_arr_time) {
		this.sch_arr_time = sch_arr_time;
	}
	/**
	 * @param flight_number
	 * @param airline
	 * @param weekdays
	 * @param dep_airport_code
	 * @param sch_dep_time
	 * @param arr_airport_code
	 * @param sch_arr_time
	 */
	public FlightList(String flight_number, String airline, String weekdays,
			String dep_airport_code, Time sch_dep_time,
			String arr_airport_code, Time sch_arr_time) {
		super();
		this.flight_number = flight_number;
		this.airline = airline;
		this.weekdays = weekdays;
		this.dep_airport_code = dep_airport_code;
		this.sch_dep_time = sch_dep_time;
		this.arr_airport_code = arr_airport_code;
		this.sch_arr_time = sch_arr_time;
	}

	
	
	
	
}
