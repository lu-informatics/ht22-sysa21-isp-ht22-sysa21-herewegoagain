package application;

public class Departments {
	
	 private String departmentName; //Unique 
	 private String departmentAddress;
	 private double budget; //must not be a negative value
	
	 
	 //Constructor creates
	 public Departments(String departmentName, String departmentAddress, double budget) {
		this.departmentName = departmentName;
		this.departmentAddress = departmentAddress;
		this.budget = budget;
	}

	//Getters and Setters
	public String getdepartmentName() {
		return departmentName;
	}
	public void setName(String name) {
		this.departmentName = name;
	}
	public String getAddress() {
		return departmentAddress;
	}
	public void setAddress(String address) {
		this.departmentAddress = address;
	}
	public double getBudget() {
		return budget;
	}
	public void setBudget(double budget) {
		this.budget = budget;
	}
	 
	//Delete 
	
	

}
