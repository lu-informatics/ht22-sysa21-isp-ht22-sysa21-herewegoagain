package application;

import java.util.ArrayList;

public class Course {

	// must not be a negative value
	private String courseCode; // Unique
	private String courseName;
	private int courseCredit;
	private String courseCycle;
	private ArrayList<CourseResponsible> courseResponsible;

	// Constructor
	public Course(String courseCode, String courseName, int courseCredit, String courseCycle) {
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.courseCredit = courseCredit;
		this.courseCycle = courseCycle;
	}

	// Getters and setters
	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getCourseCredit() {
		return courseCredit;
	}

	public void setCourseCredit(int courseCredit) {
		this.courseCredit = courseCredit;
	}

	public String getCourseCycle() {
		return courseCycle;
	}

	public void setCourseCycle(String courseCycle) {
		this.courseCycle = courseCycle;
	}

	public ArrayList<CourseResponsible> getcourseResponsible() {
		return courseResponsible;
	}

	public void setResponsible(ArrayList<CourseResponsible> responsible) {
		this.courseResponsible = responsible;
	}

	public void addCourseResponsible(CourseResponsible cR) {
		courseResponsible.add(cR);
	}

	public CourseResponsible findResponsible(String teacherID) {
		for (CourseResponsible cR : courseResponsible) {
			if (cR.getEmployeeID().equals(teacherID)) {
				return cR;
			}
		}
		return null;
	}

	public CourseResponsible removeResponsibility(String teacherID) {
		CourseResponsible cR = this.findResponsible(teacherID);
		if (cR != null) {
			courseResponsible.remove(cR);
			return cR;
		}

		return null;

	}

}
