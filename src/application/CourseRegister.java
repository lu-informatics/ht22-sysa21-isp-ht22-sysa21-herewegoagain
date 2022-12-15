package application;

import java.util.ArrayList;

public class CourseRegister {
	private ArrayList<Course> courseReg = new ArrayList<Course>();

	public ArrayList<Course> getCourseReg() {
		return courseReg;
	}

	public void setCourseReg(ArrayList<Course> courseReg) {
		this.courseReg = courseReg;
	}

	public Course findCourse(String courseCode) {
		for (Course course : courseReg) {
			if (course.getCourseCode().equals(courseCode)) {
				return course;
			}
		}
		return null;
	}

	public void addCourse(Course course) {
		if (this.findCourse(course.getCourseCode()) == null) {
			courseReg.add(course);
		}
	}

	public Course removeCourse(String courseCode) {
		Course course = findCourse(courseCode);
		if (course != null) {
			courseReg.remove(course);
			return course;
		}
		return null;
	}

}
