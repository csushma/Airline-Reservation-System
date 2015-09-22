package airlinereservation.bean;

public class FareList {

	private String fareCode;
	/**
	 * @return the fareCode
	 */
	public String getFareCode() {
		return fareCode;
	}
	/**
	 * @param fareCode the fareCode to set
	 */
	public void setFareCode(String fareCode) {
		this.fareCode = fareCode;
	}

	private float amount;
	private String restrictions;

	/**
	 * @return the amount
	 */
	public float getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(float amount) {
		this.amount = amount;
	}
	/**
	 * @return the restrictions
	 */
	public String getRestrictions() {
		return restrictions;
	}
	/**
	 * @param restrictions the restrictions to set
	 */
	public void setRestrictions(String restrictions) {
		this.restrictions = restrictions;
	}
	
	public FareList(String fareCode, float amount, String restrictions) {
		this.fareCode = fareCode;
		this.amount = amount;
		this.restrictions = restrictions;
	}

}
