package application;

public class Departments {
	
	 private String departmentName;
	 private String departmentAddress;
	 private int budget; //must not be a negative value
	
	 
	 //Constructor
	 public Departments(String departmentName, String departmentAddress, int budget) {
		 
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
	public int getBudget() {
		return budget;
	}
	public void setBudget(int budget) {
		this.budget = budget;
	}
	 
	

}
