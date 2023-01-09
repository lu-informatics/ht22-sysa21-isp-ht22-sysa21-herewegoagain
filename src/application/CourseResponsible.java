package application;

public class CourseResponsible {

	private String employeeID;
	private String name;
	private Course courseCode;

	public CourseResponsible(String employeeID, String name, Course courseCode) {
		this.employeeID = employeeID;
		this.name = name;
		this.courseCode = courseCode;
	}

	public String getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Course getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(Course courseCode) {
		this.courseCode = courseCode;
	}

	
	
	
}
