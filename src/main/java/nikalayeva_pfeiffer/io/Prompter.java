package nikalayeva_pfeiffer.io;



public interface Prompter {
	
	String prompt(String msg);
	
	int promptForInt(String prompt);
	
	void display (String st);

}
