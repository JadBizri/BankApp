public class BankApp {

	// instance field
	private double checking_balance; // to hold checking balance amount
	private double lastTransaction; // to hold the amount of the last transaction

	/*
	 * no-arg constructor that initializes the balance and last transaction amount
	 * to 0
	 */
	public BankApp() {
		checking_balance = 0.0;
		lastTransaction = 0.0;
	}

	/**
	 * Accessor (getter) method
	 * 
	 * @return The balance amount that the user has
	 */
	public double getBalance() {
		return checking_balance;
	}

	/**
	 * Method for getting the deposit and adding it to balance
	 * 
	 * @param deposit Amount of deposit made by user
	 * @return deposit amount
	 */
	public double startDeposit(double deposit) {
		checking_balance += deposit;
		lastTransaction = deposit;
		return deposit;
	}

	/**
	 * Method for taking out withdrawal amount from balance
	 * 
	 * @param withdrawal Amount to be withdrawn
	 * @return withdrawal amount
	 */
	public double startWithdrawal(double withdrawal) {
		checking_balance -= withdrawal;
		lastTransaction = -withdrawal;
		return withdrawal;
	}

	/**
	 * Method for getting the latest transaction
	 * 
	 * @return the latest transaction amount
	 */
	public double getLastTransaction() {
		return lastTransaction;
	}
}