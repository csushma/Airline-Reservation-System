package airlinereservation.bean;

public class PassList {
	String seat_number;
	String customer_name;
	String customer_phone;

	/**
	 * @return the seat_number
	 */
	public String getSeat_number() {
		return seat_number;
	}
	/**
	 * @param seat_number the seat_number to set
	 */
	public void setSeat_number(String seat_number) {
		this.seat_number = seat_number;
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
	 * @return the customer_phone
	 */
	public String getCustomer_phone() {
		return customer_phone;
	}
	/**
	 * @param customer_phone the customer_phone to set
	 */
	public void setCustomer_phone(String customer_phone) {
		this.customer_phone = customer_phone;
	}
	public PassList(String seat_number, String customer_name, String customer_phone) {
		super();
		this.seat_number = seat_number;
		this.customer_name = customer_name;
		this.customer_phone = customer_phone;
	}
	
	

}
