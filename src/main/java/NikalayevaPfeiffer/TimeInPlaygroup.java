package NikalayevaPfeiffer;

public enum TimeInPlaygroup {

	PART_TIME("8 AM - 3 PM"),
	FULL_TIME("8 AM - 5 PM");
	
	private String description;
	
	private TimeInPlaygroup(String times) {
		this.description=times;
	}
	
	private String getTimeDescription() {
		return this.description;
	}
}
