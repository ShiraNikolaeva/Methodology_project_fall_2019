package NikalayevaPfeiffer;

public enum Time {

	PART_TIME("8 AM - 3 PM"),
	FULL_TIME("8 AM - 5 PM");
	
	private String time;
	
	private Time(String times) {
		this.time=times;
	}
	
	private String returnTime() {
		return this.time;
	}
}
