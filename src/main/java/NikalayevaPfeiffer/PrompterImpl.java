package NikalayevaPfeiffer;

import java.util.Scanner;

public class PrompterImpl implements Prompter{
	
	private final Scanner scanner=new Scanner(System.in);

	@Override
	public String prompt(String msg) {
		System.out.print(msg);
		return scanner.nextLine();
	}

	@Override
	public int promptForInt(String prompt) {
		System.out.print(prompt);
		int choice=scanner.nextInt();
		scanner.nextLine();
		return choice;
	}
	
	@Override
	public void display(String st) {
		System.out.println(st);
	}
	

}
