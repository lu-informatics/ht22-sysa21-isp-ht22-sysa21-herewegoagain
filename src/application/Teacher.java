package application;

import java.util.ArrayList;


public class Teacher {
	
	private int employeeId;
	private String teacherName;
	private String teacherLastName;
	private String teacherTitle;
	private String teacherAddress;
	private int hSalary; //may not be negative
	private Department department;
	
	private ArrayList<Course> teaching = new ArrayList<>();
	private ArrayList<Course> responsible = new ArrayList<>();	
	
	
	
	//Constructor
	public Teacher(int employeeId, String teacherName, String teacherLastname, String teacherTitle, String teacherAddress, int hSalary) {
		this.employeeId = employeeId;
		this.teacherName = teacherName;
		this.teacherTitle = teacherTitle;
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
		return teacherTitle;
	}
	public void setTitle(String title) {
		this.teacherTitle = title;
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
	public String getTeacherLastName() {
		return teacherLastName;
	}
	public void setTeacherLastName(String teacherLastName) {
		this.teacherLastName = teacherLastName;
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

	}

