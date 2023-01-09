package application;

import java.util.ArrayList;

public class Course {

	// must not be a negative value
	private String courseCode; // Unique
	private String courseName;
	private int courseCredit;
	private String courseCycle;
	private Teacher responsibleTeacher;
	private ArrayList<Teacher> teachingTeachers = new ArrayList<>();

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

	public Teacher getResponsibleTeacher() {
		return responsibleTeacher;
	}

	public void setResponsibleTeacher(Teacher teacher) {
		this.responsibleTeacher = teacher;
	}

	public Teacher RemoveResponsibleTeacher(Teacher teacher) {
			if (teacher != null) {
				getResponsibleTeacher().remove(teacher);

				return teacher;
			}
			return teacher;
			}

	public ArrayList<Teacher> getTeachingTeachers() {
		return teachingTeachers;
	}

	public void setTeachingTeachers(ArrayList<Teacher> teachingTeachers) {
		this.teachingTeachers = teachingTeachers;
	}

	public void addTeachingTeacher(Teacher teacher) {
		this.teachingTeachers.add(teacher);
	}

	@Override
	public String toString() {
		return teachingTeachers.toString();
	}
}
