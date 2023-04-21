package StudentDatabase;

import java.util.Scanner;

public class Student {

	private String firstName;
	private String lastName;
	private int gradeYear;
	private String StudentId;
	private String courses = "";
	private int tuitionBalance = 0;
	private static int costOfCourse = 600;
	private static int id = 1000;

	public Student() {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter student fist name: ");
		this.firstName = in.nextLine();

		System.out.println("Enter student last name: ");
		this.lastName = in.nextLine();

		System.out.println("1-feshmen\n2-sophmore\n3junior\n4-senior\nenter student class level ");
		this.gradeYear = in.nextInt();

		setStudentID();

		System.out.println();

	}

	private void setStudentID() {
		id++;
		this.StudentId = gradeYear + "" + id;
	}

	public void enroll() {
		do {
			System.out.println("Enter cours to enroll (Q to quit): ");
			Scanner in = new Scanner(System.in);
			String course = in.nextLine();
			if (!course.equals("Q")) {
				courses = courses + "\n	" + course;
				tuitionBalance += costOfCourse;
			} else {
				break;
			}
		} while (1 != 0);
	}

	public void viewBalance() {
		System.out.println("Your balance is: " + tuitionBalance);
	}

	public void payTuition() {
		System.out.println("Enter your payment");
		Scanner in = new Scanner(System.in);
		int payment = in.nextInt();
		tuitionBalance -= payment;
		System.out.println("Thank you for your payment of $" + payment);
		viewBalance();
	}

	public String toString() {
		return "Name: " + firstName + " " + lastName + 
				"\nGrade level: "+gradeYear+
				"\nStudent ID: "+StudentId+
				"\nCourses enrolled: " + courses +
				"\nBalance: $"+ tuitionBalance;
	}

}
