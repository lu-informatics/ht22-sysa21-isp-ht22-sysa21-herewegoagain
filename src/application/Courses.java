package application;

public class Courses {
	
	//must not be a negative value
	private int credits; 
	private String courseName;
	private String courseCode; //Unique
	private String level;
	private Teachers teachers; 
	
	
	
	
	//Construtor
	public Courses(int credits, String courseName, String courseCode, String level) {
		this.credits = credits;
		this.courseName = courseName;
		this.courseCode = courseCode;
		this.level = level;
	}
	
	//Gettes and setters
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public String getCycle() {
		return level;
	}
	public void setCycle(String cycle) {
		this.level = cycle;
	} 

	
	
	
}
