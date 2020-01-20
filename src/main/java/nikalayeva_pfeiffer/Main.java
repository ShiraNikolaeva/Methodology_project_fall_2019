package nikalayeva_pfeiffer;

import nikalayeva_pfeiffer.io.PrompterImpl;

public class Main {

	public static void main(String[] args) {
		PrompterImpl prompter = new PrompterImpl();
		Program program = new Program(prompter);

		program.run();
	}
}
