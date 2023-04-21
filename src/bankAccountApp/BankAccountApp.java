package bankAccountApp;

import java.util.LinkedList;
import java.util.List;

public class BankAccountApp {

	public static void main(String[] args) {
		List<Account> accounts = new LinkedList<Account>();
		
		/*Checking chkacc1 = new Checking("tom wilson","123456789",1500);
		
		Savings savacc1 = new Savings("Henry Jones","987654321",30000);
		//read a CSV file then create a new account based on the data
		chkacc1.showInfo();
		System.out.println("********************");
		savacc1.showInfo();
		*/
		
		//read a CSV file the create new accoints based on data
		String file = "C:\\UdemyFiles\\NewBankAccounts.csv";

		List<String[]> newAccountHolders = utilities.CSV.read(file);
		
		for (String[] accountHolder : newAccountHolders) {
			String name = accountHolder[0];
			String SSN = accountHolder[1];
			String accountType = accountHolder[2];
			double initDeposit = Double.parseDouble(accountHolder[3]);
			if(accountType.endsWith("Savings")) {
				//System.out.println("Open a savings account");
				accounts.add(new Savings(name,SSN,initDeposit));
			}else if(accountType.endsWith("Checking")){
				//System.out.println("open a checkins account");
				accounts.add(new Checking(name,SSN,initDeposit));
			}else {
				//System.out.println("error reading account type");
			}
		}
		
		
		
		for (Account acc : accounts) {
			System.out.println("\n***********************");
			acc.showInfo();
		}
	}

}
