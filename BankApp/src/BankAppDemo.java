import java.util.Scanner;

public class BankAppDemo {

	// instantiating the scanner object
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		// instantiating BankApp object
		BankApp action = new BankApp();

		// calling the displayWelcome method to display welcome message
		displayWelcome();

		// calling the displayMenu method to display menu and return user's choice
		int choice = displayMenu(action);

		while (choice != 4) {
			// switch on the choice variable
			switch (choice) {
			case 1: //user chooses to deposit
				startDeposit(action);
				break;
			case 2: //user chooses to withdraw
				startWithdrawal(action);
				break;
			case 3: //user chooses to view previous transaction
				displayLastTransaction(action);
				break;
			default:
				break;
			}
			choice = displayMenu(action);
		}

		// while loop breaks only when user decides to exit by selecting option 4
		// so exit program
		exitProgram();
	}

	/*
	 * Method that displays the welcome message
	 */
	public static void displayWelcome() {
		System.out.println("\n******** Welcome to BankApp! ********");
	}

	/*
	 * Method that displays the menu and return user's choice
	 * 
	 * @return int choice, to hold the user's menu choice
	 */
	public static int displayMenu(BankApp action) {
		int choice;
		System.out.println(
				"\n-------------------------------------------------------------------------------------------");
		System.out.printf(
				"\nYour Balance: $%,.2f\n\n\t1. Deposit\n\t2. Withdraw\n\t3. View Last Transaction\n\t4. Exit\n\n",
				action.getBalance());
		System.out.print("What would you like to do? ");
		choice = sc.nextInt();
		while (choice < 1 || choice > 4) {
			System.out.println("\nERROR: Please choose one option mentioned below (1-4).");
			System.out.printf(
					"\nYour Balance: $%,.2f\n\n\t1. Deposit\n\t2. Withdraw\n\t3. View Last Transaction\n\t4. Exit\n\n",
					action.getBalance());
			System.out.print("What would you like to do? ");
			choice = sc.nextInt();
		}
		return choice;
	}

	/*
	 * Method that initiates the deposit process whenever the user asks for it
	 * 
	 * @param BankApp action
	 */
	public static void startDeposit(BankApp action) {
		System.out.print("\nHow much would you like to deposit? $");
		double deposit = sc.nextDouble();
		while (deposit <= 0) {
			System.out.println("\nERROR: You cannot deposit $0 or less.\n");
			System.out.print("How much would you like to deposit? $");
			deposit = sc.nextDouble();
		}
		action.startDeposit(deposit);
		System.out.println(
				"\n-------------------------------------------------------------------------------------------");
	}

	/*
	 * Method that initiates the withdrawal process whenever the user asks for it
	 * 
	 * @param BankApp action
	 */
	public static void startWithdrawal(BankApp action) {
		if (action.getBalance() <= 0) {
			System.out.println("\nERROR: You cannot withdraw with a balance of $0 or less.");
			return;
		}
		double withdrawal = 0;
		System.out.printf("\nPlease select an amount you would like to withdraw (Your Balance: $%,.2f)\n",
				action.getBalance());
		System.out.println(
				"\n\t1. $20\t\t4. $80\n\t2. $40\t\t5. $100\n\t3. $60\t\t6. $200\n\n\t7. Enter Different Amount\n\t8. Go Back\n");
		System.out.print("Select an option: ");
		int choice = sc.nextInt();
		while (choice < 1 || choice > 8) {
			System.out.println("ERROR: Please choose one of the options mentioned below (1-8).");
			System.out.printf("\nPlease select an amount you would like to withdraw (Your Balance: $%,.2f) $",
					action.getBalance());
			System.out.println(
					"\n\t1. $20\t\t4. $80\n\t2. $40\t\t5. $100\n\t3. $60\t\t6. $200\n\n\t7. Enter Different Amount\n\t8. Go Back\n");
			System.out.print("Select an option: ");
			choice = sc.nextInt();
		}
		switch (choice) {
		case 1:
			if (action.getBalance() < 20) {
				System.out.println("\nERROR: You cannot withdraw more than what you currently have.");
				withdrawal = 0;
				break;
			} else
				withdrawal = 20;
			break;

		case 2:
			if (action.getBalance() < 40) {
				System.out.println("\nERROR: You cannot withdraw more than what you currently have.");
				withdrawal = 0;
				break;
			} else
				withdrawal = 40;
			break;
		case 3:
			if (action.getBalance() < 60) {
				System.out.println("\nERROR: You cannot withdraw more than what you currently have.");
				withdrawal = 0;
				break;
			} else
				withdrawal = 60;
			break;
		case 4:
			if (action.getBalance() < 80) {
				System.out.println("\nERROR: You cannot withdraw more than what you currently have.");
				withdrawal = 0;
				break;
			} else
				withdrawal = 80;
			break;
		case 5:
			if (action.getBalance() < 100) {
				System.out.println("\nERROR: You cannot withdraw more than what you currently have.");
				withdrawal = 0;
				break;
			} else
				withdrawal = 100;
			break;
		case 6:
			if (action.getBalance() < 200) {
				System.out.println("\nERROR: You cannot withdraw more than what you currently have.");
				withdrawal = 0;
				break;
			} else
				withdrawal = 200;
			break;
		case 7: // other amount
			System.out.printf(
					"\nHow much would you like to withdraw? You can only withdraw in increments of 20. (Your Balance: $%,.2f) $",
					action.getBalance());
			withdrawal = sc.nextDouble();
			while (withdrawal % 20 != 0) {
				System.out.println("\nERROR: You can only withdraw in increments of $20.");
				System.out.printf("\nHow much would you like to withdraw? (Your Balance: $%,.2f) $",
						action.getBalance());
				withdrawal = sc.nextDouble();
			}
			while (withdrawal > action.getBalance()) {
				System.out.println("\nERROR: You cannot withdraw more than what you currently have.");
				System.out.printf("\nHow much would you like to withdraw? (Your Balance: $%,.2f) $",
						action.getBalance());
				withdrawal = sc.nextDouble();
			}
			while (withdrawal <= 0) {
				System.out.println("\nERROR: You cannot withdraw $0 or less.");
				System.out.printf("\nHow much would you like to withdraw? (Your Balance: $%,.2f) $",
						action.getBalance());
				withdrawal = sc.nextDouble();
			}
			break;
		case 8: // go back
			return;
		default:
			break;
		}
		action.startWithdrawal(withdrawal);
		System.out.println(
				"\n-------------------------------------------------------------------------------------------");
	}

	/*
	 * Method that displays the last transaction made
	 * 
	 * @param BankApp action
	 */
	public static void displayLastTransaction(BankApp action) {
		if (action.getLastTransaction() < 0) {
			double negativeTransaction = action.getLastTransaction();
			negativeTransaction *= -1;
			System.out.printf("\nLatest Transaction: - $%,.2f\n", negativeTransaction);
		} else if (action.getLastTransaction() > 0)
			System.out.printf("\nLatest Transaction: + $%,.2f\n", action.getLastTransaction());
		else // only when there was no previous transaction
			System.out.printf("\nNo Previous Transaction.\n");
		System.out.println(
				"\n-------------------------------------------------------------------------------------------");
	}

	/*
	 * Method that exits program
	 */
	public static void exitProgram() {
		System.out
				.print("\n-------------------------------------------------------------------------------------------");
		System.out.print("\nThank you for banking with us!");
		System.out.println(
				"\n-------------------------------------------------------------------------------------------");
		System.exit(0);
	}
}
