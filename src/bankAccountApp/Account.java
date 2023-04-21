package bankAccountApp;

public abstract class Account implements IBaseRate {

	//list properties specific to a savings and checkings account
	 
	private String name;
	private String SSN;
	private double balance;
	
	private static int index = 10000;
	protected String accountNumber;
	protected double rate;

	// constructors to the base properties and initialize the account
	public Account(String name,String SSN,double initDeposit) {
		this.name = name;
		this.SSN = SSN;
		balance = initDeposit;
		
		//set account number
		index++;
		this.accountNumber = setAccountNumber();
		setRate();	
		}
	
	public abstract void setRate();
	
	private String setAccountNumber() {
		String lastTwoOfSSN = SSN.substring(SSN.length()-2,SSN.length());
		int uniqueID = index;
		int randomNumber = (int) (Math.random()*Math.pow(10, 3));
		return lastTwoOfSSN + uniqueID + randomNumber;
	}
	
	public void compound() {
		double accruedInterest = balance * (rate/100);
		balance = balance + accruedInterest;
		System.out.println("accrued interest: $"+accruedInterest);
		printBalance();
	}
	//list common methods - transactions
	public void deposit(double amount) {
		balance = balance + amount;
		System.out.println("Depositing: $"+amount);
		printBalance();
	}
	
	public void withdraw(double amount) {
		balance = balance - amount;
		System.out.println("Withdrawing: $"+amount);
		printBalance();
	}
	
	public void transfer(String toWhere,double amount) {
		balance = balance - amount;
		System.out.println("tranfering: $"+amount+" to "+toWhere);
		printBalance();
	}
	
	public void printBalance() { 
		System.out.println("Your balance is now: $"+balance);
	}
	
	public void showInfo() {
		System.out.println("Name: "+name
				+"\nAccount number: "+accountNumber+
				"\nBalance: "+balance+
				"\nRate: "+rate+"%");
	}
}