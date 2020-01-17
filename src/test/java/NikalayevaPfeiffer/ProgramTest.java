package NikalayevaPfeiffer;



import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class ProgramTest {

	public Prompter prompter;
	public Program program;

	@Before
	public void setUp() {
		prompter = Mockito.mock(Prompter.class);
		program = new Program(prompter);
	}

	@Test
	public void testOptionOneMainMenu() {
		Mockito.when(prompter.promptForInt("Enter choice from main menu")).thenReturn(1);
		int choice = program.menu();
		int verifyChoice = 1;
		assertEquals(verifyChoice, choice);

	}

	@Test
	public void testOptionTwoMainMenu() {
		Mockito.when(prompter.promptForInt("Enter choice from main menu")).thenReturn(2);
		int choice = program.menu();
		int verifyChoice = 2;
		assertEquals(verifyChoice, choice);

	}

	@Test
	public void testOptionThreeMainMenu() {
		Mockito.when(prompter.promptForInt("Enter choice from main menu")).thenReturn(3);
		int choice = program.menu();
		int verifyChoice = 3;
		assertEquals(verifyChoice, choice);

	}

	@Test
	public void testOptionOneParentMenu() {
		Mockito.when(prompter.promptForInt("Choice from parent menu")).thenReturn(1);
		int choice = program.parentSubMenu();
		int verifyChoice = 1;
		assertEquals(verifyChoice, choice);

	}

	@Test
	public void testOptionTwoParentMenu() {
		Mockito.when(prompter.promptForInt("Choice from parent menu")).thenReturn(2);
		int choice = program.parentSubMenu();
		int verifyChoice = 2;
		assertEquals(verifyChoice, choice);

	}

	@Test
	public void testOptionThreeParentMenu() {
		Mockito.when(prompter.promptForInt("Choice from parent menu")).thenReturn(3);
		int choice = program.parentSubMenu();
		int verifyChoice = 3;
		assertEquals(verifyChoice, choice);
	}

	@Test
	public void testOptionOneEditParentMenu() {
		Mockito.when(prompter.promptForInt("Choice from edit parent menu")).thenReturn(1);
		int choice = program.editInformationSubMenuWithDetails();
		int verifyChoice = 1;
		assertEquals(verifyChoice, choice);
	}

	@Test
	public void testOptionTwoEditParentMenu() {
		Mockito.when(prompter.promptForInt("Choice from edit parent menu")).thenReturn(2);
		int choice = program.editInformationSubMenuWithDetails();
		int verifyChoice = 2;
		assertEquals(verifyChoice, choice);
	}

	@Test
	public void testOptionThreeEditParentMenu() {
		Mockito.when(prompter.promptForInt("Choice from edit parent menu")).thenReturn(3);
		int choice = program.editInformationSubMenuWithDetails();
		int verifyChoice = 3;
		assertEquals(verifyChoice, choice);
	}

	@Test
	public void testOptionFourParentMenu() {
		Mockito.when(prompter.promptForInt("Choice from edit parent menu")).thenReturn(4);
		int choice = program.editInformationSubMenuWithDetails();
		int verifyChoice = 4;
		assertEquals(verifyChoice, choice);
	}

	@Test
	public void testOptionOneChildMenu() {
		Mockito.when(prompter.promptForInt("Choose from the child menu")).thenReturn(1);
		int choice = program.childSubMenu();
		int verifyChoice = 1;
		assertEquals(verifyChoice, choice);
	}

	@Test
	public void testOptionTwoChildMenu() {
		Mockito.when(prompter.promptForInt("Choose from the child menu")).thenReturn(2);
		int choice = program.childSubMenu();
		int verifyChoice = 2;
		assertEquals(verifyChoice, choice);
	}

	@Test
	public void testOptionThreeChildMenu() {
		Mockito.when(prompter.promptForInt("Choose from the child menu")).thenReturn(3);
		int choice = program.childSubMenu();
		int verifyChoice = 3;
		assertEquals(verifyChoice, choice);
	}

	@Test
	public void testOptionOneEditChildMenu() {
		Mockito.when(prompter.promptForInt("Choose from the edit child menu")).thenReturn(1);
		int choice = program.editChildInformationSubMenu();
		int verifyChoice = 1;
		assertEquals(verifyChoice, choice);
	}

	@Test
	public void testOptionTwoEditChildMenu() {
		Mockito.when(prompter.promptForInt("Choose from the edit child menu")).thenReturn(2);
		int choice = program.editChildInformationSubMenu();
		int verifyChoice = 2;
		assertEquals(verifyChoice, choice);
	}

	@Test
	public void testOptionThreeEditChildMenu() {
		Mockito.when(prompter.promptForInt("Choose from the edit child menu")).thenReturn(3);
		int choice = program.editChildInformationSubMenu();
		int verifyChoice = 3;
		assertEquals(verifyChoice, choice);
	}

	@Test
	public void testOptionFourEditChildMenu() {
		Mockito.when(prompter.promptForInt("Choose from the edit child menu")).thenReturn(4);
		int choice = program.editChildInformationSubMenu();
		int verifyChoice = 4;
		assertEquals(verifyChoice, choice);
	}

	@Test
	public void testOptionFiveEditChildMenu() {
		Mockito.when(prompter.promptForInt("Choose from the edit child menu")).thenReturn(5);
		int choice = program.editChildInformationSubMenu();
		int verifyChoice = 5;
		assertEquals(verifyChoice, choice);
	}

	@Test
	public void testOptionSixEditChildMenu() {
		Mockito.when(prompter.promptForInt("Choose from the edit child menu")).thenReturn(6);
		int choice = program.editChildInformationSubMenu();
		int verifyChoice = 6;
		assertEquals(verifyChoice, choice);
	}

	@Test
	public void testOptionSevenEditChildMenu() {
		Mockito.when(prompter.promptForInt("Choose from the edit child menu")).thenReturn(7);
		int choice = program.editChildInformationSubMenu();
		int verifyChoice = 7;
		assertEquals(verifyChoice, choice);
	}

	@Test
	public void testOptionEightEditChildMenu() {
		Mockito.when(prompter.promptForInt("Choose from the edit child menu")).thenReturn(8);
		int choice = program.editChildInformationSubMenu();
		int verifyChoice = 8;
		assertEquals(verifyChoice, choice);
	}

	@Test
	public void testOptionOneListMenu() {
		Mockito.when(prompter.promptForInt("Choose from the listing information menu")).thenReturn(1);
		int choice = program.listInformationSubMenu();
		int verifyChoice = 1;
		assertEquals(verifyChoice, choice);
	}

	@Test
	public void testOptionTwoListMenu() {
		Mockito.when(prompter.promptForInt("Choose from the listing information menu")).thenReturn(2);
		int choice = program.listInformationSubMenu();
		int verifyChoice = 2;
		assertEquals(verifyChoice, choice);
	}

	@Test 
	public void testOptionThreeListMenu() {
		Mockito.when(prompter.promptForInt("Choose from the listing information menu")).thenReturn(3);
		int choice = program.listInformationSubMenu();
		int verifyChoice = 3;
		assertEquals(verifyChoice, choice);
	}
}
