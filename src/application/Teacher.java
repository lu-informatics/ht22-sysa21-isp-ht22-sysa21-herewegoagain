package application;

import java.util.ArrayList;
import java.util.HashMap;

public class Teacher {
	
	private int employeeId;
	private String teacherName;
	private String title;
	private String teacherAddress;
	private int hSalary; //may not be negative
	private Department department;
	
	private ArrayList<Course> course;
	
	
	
	//Constructor
	public Teacher(int employeeId, String teacherName, String title, String teacherAddress, int hSalary) {
		this.employeeId = employeeId;
		this.teacherName = teacherName;
		this.title = title;
		this.teacherAddress = teacherAddress;
		this.hSalary = hSalary;
	}
	//Getters and setters
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTeacherAddress() {
		return teacherAddress;
	}
	public void setTeacherAddress(String teacherAddress) {
		this.teacherAddress = teacherAddress;
	}
	public int gethSalary() {
		return hSalary;
	}
	public void sethSalary(int hSalary) {
		this.hSalary = hSalary;
	
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public ArrayList<Course> getCourses() {
		return course;
	}
	public void setCourses(ArrayList<Course> courses) {
		this.course = courses;

	}
	
	public Course findCourse(String CourseCode) {
		for (Course a : this.getCourses()) {
			if (CourseCode == a.getCourseCode())
				return a;
		}
		return null;

	}
}
