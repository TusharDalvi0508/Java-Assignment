package javAssignment1;

public class Course {
	private String courseid;
	private String cName;
	private String difficultyLevel;
	private int duration;
	
	Course(String cName, String difficultyLevel, int duration) {
		this.cName = cName;
		this.difficultyLevel = difficultyLevel;
		this.duration = duration;
}

	public String getCourseid() {
		return courseid;
	}

	public String getcName() {
		return cName;
	}
	public String getDifficultyLevel() {
		return difficultyLevel;
	}

	public int getDuration() {
		return duration;
	}

	

}
