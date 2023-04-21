package bankAccountApp;

public class Checking extends Account{
	
	//list properties specific to a checking account
	private int debitCardNumber;
	private int debitCardPin;
	// constructors to initialize checking account properties
	
	public Checking(String name,String SSN,double initDeposit) {
		super(name,SSN,	initDeposit);
		accountNumber = 2 + accountNumber;
		setDebitCardNumber();
		
	}
	@Override
	public  void setRate() {
		rate = 	getBaseRate()-.25;
		
	}

	
	//list any method specific to a checking account
	public void showInfo() {
		super.showInfo();
		System.out.println("Your checking account features"+
							"\nDebit card number: "+debitCardNumber+
							"\nDebit card pin: "+debitCardPin);
		setDebitCardNumber();
	}
	
	private void setDebitCardNumber() {
		debitCardNumber = (int) (Math.random()*Math.pow(10, 12));
		debitCardPin = (int) (Math.random()*Math.pow(10, 4));
	}
}
