package bankAccountApp;

public class Savings extends Account{
	
	//list properties specific to a savings account
	private int safetyDepositBoxID;
	private int safetyDepositBoxKey;
	// constructors to initialize Savings account properties
	public Savings(String name,String SSN,double initDeposit) {
		super(name,SSN,	initDeposit);
		accountNumber = 1 + accountNumber;
		setSafetyDepositBoxID();
		
	}
	@Override
public  void setRate() {
		rate = 	getBaseRate()*.15;
	}
	
	private void setSafetyDepositBoxID() {
		safetyDepositBoxID  = (int) (Math.random()*Math.pow(10, 3));
		safetyDepositBoxKey = (int) (Math.random()*Math.pow(10, 4));
	}
	
	//list any method specific to a Savings account
	public void showInfo() {
		System.out.println("Account type: savings");
		super.showInfo();
		System.out.println("our saving account features"+
							"\n  Safety deposit box ID "+ safetyDepositBoxID+
							"\n  Safety deposit box key "+safetyDepositBoxKey);
	} 
}
