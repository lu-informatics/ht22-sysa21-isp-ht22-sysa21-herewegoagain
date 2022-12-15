package application;

import java.util.ArrayList;

public class DepartmentRegister {

	private ArrayList<Department> departmentReg = new ArrayList<Department>();

	public ArrayList<Department> getDepartmentReg() {
		return departmentReg;
	}

	public void setDepartmentReg(ArrayList<Department> departmentReg) {
		this.departmentReg = departmentReg;
	}

	public Department findDepartment(String departmentName) {
		for (Department department : departmentReg) {
			if (department.getDepartmentName().equals(departmentName)) {
				return department;
			}
		}
		return null;
	}

	public void addDepartment(Department department) {
		if (this.findDepartment(department.getDepartmentName()) == null) {
			departmentReg.add(department);
		}
	}

	public Department removeDepartment(String departmentName) {
		Department department = findDepartment(departmentName);
		if (department != null) {
			departmentReg.remove(department);
			return department;
		}
		return null;
	}

}
