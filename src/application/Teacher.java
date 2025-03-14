package application;

import java.util.ArrayList;

public class Teacher extends TeacherRegister{

	private String employeeID;
	private String teacherName;
	private String teacherLastName;
	private String teacherAddress;
	private double hourlySalary; // may not be negative
	private String teacherTitle;

	private Department department;

	private ArrayList<Course> teaching = new ArrayList<>();
	private ArrayList<Course> responsible = new ArrayList<>();

	// Constructor
	public Teacher(String employeeID, String teacherName, String teacherLastName, String teacherTitle,
			String teacherAddress, double hourlySalary) {
		this.employeeID = employeeID;
		this.teacherName = teacherName;
		this.teacherLastName = teacherLastName;
		this.teacherTitle = teacherTitle;
		this.teacherAddress = teacherAddress;
		this.hourlySalary = hourlySalary;
	}
	// Getters and setters

	public Department getDepartment() {
		return department;
	}

	public String getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getTeacherLastName() {
		return teacherLastName;
	}

	public void setTeacherLastName(String teacherLastName) {
		this.teacherLastName = teacherLastName;
	}

	public String getTeacherAddress() {
		return teacherAddress;
	}

	public void setTeacherAddress(String teacherAddress) {
		this.teacherAddress = teacherAddress;
	}

	public double getHourlySalary() {
		return hourlySalary;
	}

	public void setHourlySalary(double hourlySalary) {
		this.hourlySalary = hourlySalary;
	}

	public String getTeacherTitle() {
		return teacherTitle;
	}

	public void setTeacherTitle(String teacherTitle) {
		this.teacherTitle = teacherTitle;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public ArrayList<Course> getTeaching() {
		return teaching;
	}

	public void setTeaching(ArrayList<Course> teaching) {
		this.teaching = teaching;
	}

	public ArrayList<Course> getResponsible() {
		return responsible;
	}

	public void setResponsible(ArrayList<Course> responsible) {
		this.responsible = responsible;
	}

	public  void addCourseResponsible(Course course) {
		this.responsible.add(course);
		
	}
	public Course findCourseResponsible(String courseCode) {
		for (Course course : this.getResponsible()) {
			if (courseCode == course.getCourseCode())
				return course;
		}
		return null;
		

	}
	public Course removeCourseResponsible(Course course) {
		for (Course c : this.getResponsible()) {
			if (c != null) {
			getResponsible().remove(c);	
			return c;
			}
	}
		return null;
	}
	
	public  void addCourseTeaching(Course course) {
		this.teaching.add(course);
	}
	
	public Course findCourseTeaching(String courseCode) {
		for (Course course : this.getTeaching()) {
			if (courseCode == course.getCourseCode())
				return course;
		}
		return null;
}


}
