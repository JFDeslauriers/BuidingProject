package emailapp;

import java.util.Scanner;

public class Email {
	
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String email;
	private int mailboxCapacity=500;
	private int defaultPasswordLength =10;
	private String alternateEmail;
	private String companySuffix="mycompany.com";
	
	public Email() {}
	
	public Email(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		System.out.println("Email created:"+this.firstName+" "+this.lastName);
		this.department = setDepsrtment();
		System.out.println("Department: "+this.department);
		this.password = randomPassword(defaultPasswordLength);
		System.out.println("Your password is: "+this.password);
		email = firstName.toLowerCase()+" "+lastName.toLowerCase()+"@"+department+"."+companySuffix;
		System.out.println("Your email is: "+email);
		
	}
	
	private String setDepsrtment() {
		System.out.print("new worker "+firstName+" "+lastName+"Enter the department\n1 for sales\n2 for development\n3 for accounting\n0 for none");
		Scanner in = new Scanner(System.in);
		int depChoice = in.nextInt();
		if(depChoice==1) {return "sales";}
		else if (depChoice==2) {return "development";}
		else if 	(depChoice==3) {return "accounting";}
		else {return "";}
	}
	
	private String randomPassword(int length) {
		String passwordSet = "abcdefghijklamnopkrstuxyz1234567890!@#$%&";
		char[] password = new char[length];
		for (int i=0;i<length;i++) {
			int rand=(int)(Math.random()*passwordSet.length());
			password[i]=passwordSet.charAt(rand);
		}
		return new String(password);
	}

	public void SetMailboxCapasity(int capacity) {
		this.mailboxCapacity = capacity;
	}
	
	public void SetAlternativeEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}
	
	public void changePassword(String password) {
		this.password = password;
	}
	
	public int getMailboxCapacity(){
		return mailboxCapacity;
	}
	
	public String getAlternateEmail() {
		return alternateEmail;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String showInfo(){
		return "Display name: "+firstName+" "+lastName+
				"\n Company email: "+email+
				"\n Mailbox Capacity: "+mailboxCapacity+" mb ";
	}
}
