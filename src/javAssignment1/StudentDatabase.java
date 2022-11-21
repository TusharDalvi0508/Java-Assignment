package javAssignment1;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class StudentDatabase {

	static Map<String, Student> student = new HashMap<>();

	public static Map<String, Student> getStudent() {
		return student;
	}

	public StudentDatabase() {

		student.put("John", new Student("S101", "abcd"));
		student.put("Daniel", new Student("S102", "mnop"));

	}
	
	public String getstudentId1(String sName) {
		return student.get(sName).getstudentId();
	}
	
	public String getsName(String studentId) {
		return student.get(studentId).getsName();
	}


	public boolean authenticateUser(String userName, String userPin) {
			if ((student.containsKey(userName))){
				if ((student.get(userName).getloginPassword().equals(userPin))){
					return true;
				}
			}
		return false;
	}



	public static void main(String[] args) {
		StudentDatabase db = new StudentDatabase();
		System.out.println(db.authenticateUser("John","abc"));
		
	}
}
