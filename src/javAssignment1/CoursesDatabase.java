package javAssignment1;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class CoursesDatabase {
	private Map<String, Course> courses = new HashMap<>();
	
	StudentDatabase sdb = new StudentDatabase();
	

	public CoursesDatabase() {
		courses.put("C1", new Course("Java basics", "Low", 3));
		courses.put("C2", new Course("Advanced Java Tutorial", "Medium", 4));
		courses.put("C3", new Course("SQl developers course", "Medium",4));
		courses.put("C4", new Course("DevOps Tutorial", "High", 5));
	}

	public int getDuration(String courseid) {
		return courses.get(courseid).getDuration();
	}
	

	public String displayCourse(String courseid) {
		return courses.get(courseid).getcName();
	}
	
	
	
	public void enrollinCourse(String theSname, String theCourseid) {
		Viewsummary vs = new Viewsummary();
		String StudentId = sdb.getstudentId1(theSname);
		String courseName = courses.get(theCourseid).getcName();
		vs.viewsummary.put(StudentId, new Viewsummary(theCourseid,0,0)); 
		System.out.println("you have successfully enrolled in " +(courseName));

	}
	public void ViewenrolledCourses(String studentName,String theCourseid) {

			try {
				
				String StudentId = sdb.getstudentId1(studentName);
				String courseName = courses.get(theCourseid).getcName();
				
				System.out.println("Student Name :" + studentName);
				System.out.println("Student id :" +StudentId);
			
				System.out.println("Course Id"+ "\t"+ "Course Name"+ "\t\t"+  "Enrollment Date");
			   System.out.printf(theCourseid  + "\t\t"+ courseName + "\t "+  "20/11/22");
			  
			   System.out.println();
			}
			catch(NullPointerException e) {
				System.out.println("You haven't enrolled in any courses");
			}

		}

	
	public void displayallCourses() {

	     System.out.println("-------------------------------------------------------------------------------");
	        System.out.printf("%s%-18s%-30s%-20s%-2s%s","", "Course Id", "Name", "Difficulty Level", "Duration","");
	        System.out.println();
	        System.out.println("-------------------------------------------------------------------------------");
	        for(Entry<String, Course> course : courses.entrySet()) {
	            System.out.printf("%3s%-15s%-30s%-20s%-2s%s", "   ", course.getKey(), course.getValue().getcName(), 
	                    course.getValue().getDifficultyLevel(),    course.getValue().getDuration(), "hrs") ;
	            System.out.println();	
		}
		
	}
		

}