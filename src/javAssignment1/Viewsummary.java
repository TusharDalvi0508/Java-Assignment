package javAssignment1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Viewsummary {
	private String courseid;
	private float timespent =0;
	private double completiontime = 0;
	private CoursesDatabase coursesdatabase = new CoursesDatabase();
	private StudentDatabase studentdatabase = new StudentDatabase();

	Map<String, Viewsummary> viewsummary = new HashMap<>();
	
	public Viewsummary() {
		
	}

	public Viewsummary(String courseid, float timespent, double completiontime) {
		this.timespent = timespent;
		this.completiontime = completiontime;
		this.courseid = courseid;
		
	}
	
	
	public String getCourseid() {
		return courseid;
	}

	public float getTimespent() {
		return timespent;
	}

	public void setTimespent(float timespent) {
		this.timespent = timespent;
	}

	public double getCompletiontime() {
		return completiontime;
	}

	public void setCompletiontime(double completiontime) {
		this.completiontime = completiontime;
	}

	public void Clockintime(String studentId, String courseId, float timeSpent, double completion) {
		viewsummary.put(studentId, new Viewsummary(courseId, timeSpent, completion));
		coursesdatabase = new CoursesDatabase();
	
		System.out.println("You have successfully clocked in " + timeSpent + " " + "to " + coursesdatabase.displayCourse(courseId));
	}

	public void viewsummarymethod(String SName,String clockCourseid) {

		int duration = coursesdatabase.getDuration(clockCourseid);
	
		String studentId = studentdatabase.getstudentId1(SName);
		float timespent = viewsummary.get(studentId).getTimespent();
		
		double completiontime = (timespent/duration)*100;
		System.out.println(studentId);
		viewsummary.get(studentId).setCompletiontime(completiontime);
		viewsummary.get(studentId).getTimespent();
		viewsummary.get(studentId).getCourseid();
		
		coursesdatabase.displayCourse(clockCourseid);
		viewsummary.get(studentId).setCompletiontime(completiontime);
		
		double newCompletionTime = viewsummary.get(studentId).getCompletiontime();
		
		System.out.println("Student Name :" + SName);
		System.out.println("Student Id :" + studentId);
		System.out.printf("%-10s%-20s%-20s%-20s%-20s","Course Id ","Course Name" ,"Duration"," Time spent","Completion%");
		System.out.println();
		
		System.out.printf("%-10s%-20s%-20s%-20s%-20s", viewsummary.get(studentId).getCourseid(),
				coursesdatabase.displayCourse(clockCourseid),
				coursesdatabase.getDuration(clockCourseid),
				viewsummary.get(studentId).getTimespent(),
				newCompletionTime);
		System.out.println();		
		
	}
	
}
