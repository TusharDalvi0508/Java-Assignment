package javAssignment1;

import java.util.Scanner;
import java.util.*;

public class Mainapp {
	private String userName;
	private String userPin;
	private boolean userauthenticated = false;
	private CoursesDatabase coursesdatabase ;
	private StudentDatabase studentdatabase ; 
	private Viewsummary summary;
	private String theCourseid;
	private  String studentId ;
	float timespent;
	private String clockCourseid;

	public Mainapp() {
		coursesdatabase = new CoursesDatabase();
		studentdatabase  = new StudentDatabase(); 
		summary = new Viewsummary();

	}

	public void run() {
		while(true) {
			while(! userauthenticated) {
				authenticateUser();
			}
			performAction();
			userauthenticated = false;
			System.out.println("Thank You");
	
	}
	}
	
	private boolean authenticateUser() {
		Scanner s1 = new Scanner(System.in);
		System.out.println("Enter User Name: ");
		userName = s1.nextLine();
		System.out.println("Enter User Password: ");
		userPin = s1.nextLine();
		
		userauthenticated = studentdatabase.authenticateUser(userName, userPin);
		
		if (userauthenticated) {
			System.out.println("Successfully Logged in");
		} else {
			System.out.println("Invalid username or password");
		}
		return userauthenticated;

	}

	public static int Displayoptions() {
		System.out.println("1. Display all courses");
		System.out.println("2. View enrolled courses");
		System.out.println("3. Enroll in a new course");
		System.out.println("4. Clock-in time");
		System.out.println("5. View Summary");
		System.out.println("6. Exit");
		Scanner myOption = new Scanner(System.in);
		System.out.println("Enter your option: ");
		return myOption.nextInt();
	}

	private void performAction() {
		boolean userExited = false;

		// chooseYourOption();

		while (!userExited) {
			int mainMenuSelection = Displayoptions();
			System.out.println(mainMenuSelection);
			switch (mainMenuSelection) {
			case 1:
				coursesdatabase.displayallCourses();
				break;

			case 2:
				coursesdatabase.ViewenrolledCourses(userName, theCourseid);
				break;

			case 3:
				enrollInCourse();
				break;

		   case 4:
			   clockIn();

				break;

			case 5:
				summary.viewsummarymethod(userName,theCourseid);
			
				break;

			case 6:
				System.out.println("Exiting the system");
				userExited = true;
				break;

			default:
				System.out.println("You did not enter a valid selection. Try again. ");
				break;
			}
		}
	}

	private void enrollInCourse() {
		Scanner s2 = new Scanner(System.in);
		System.out.println("Enter course Id: ");
		theCourseid = s2.nextLine();
		coursesdatabase.enrollinCourse(userName, theCourseid);

	}
	
	private void clockIn() {
		Scanner c1 = new Scanner(System.in);
		System.out.println("Enter course Id :");
	    clockCourseid = c1.nextLine();
		System.out.println("Enter time spent");
		timespent = c1.nextFloat();
		 
		 studentId = studentdatabase.getstudentId1(userName);
		 summary.Clockintime(studentId,clockCourseid, timespent, 0);
		 
	}

	

	public static void main(String[] args) {
		Mainapp application = new Mainapp();
		application.run();

	}

}
