package application;

import java.util.ArrayList;

public class Department {
	
	 private String departmentName; //Unique 
	 private String departmentAddress;
	 private double budget; //must not be a negative value
	 
	 private ArrayList<Teacher> teacherList = new ArrayList<>();
	
	 
	 //Constructor creates
	 public Department(String departmentName, String departmentAddress, double budget) {
		this.departmentName = departmentName;
		this.departmentAddress = departmentAddress;
		this.budget = budget;
	}

	//Getters and Setters

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentAddress() {
		return departmentAddress;
	}

	public void setDepartmentAddress(String departmentAddress) {
		this.departmentAddress = departmentAddress;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	public ArrayList<Teacher> getTeacherList() {
		return teacherList;
	}

	public void setTeacherList(ArrayList<Teacher> teacherList) {
		this.teacherList = teacherList;
	}
	
	//Find Teacher in Department 
	
	public Teacher findTeacher(String employeeID) {
		for (Teacher a : this.getTeacherList()) {
			if (employeeID == a.getEmployeeID())
				return a;
		}
		return null;

	}
		

}
