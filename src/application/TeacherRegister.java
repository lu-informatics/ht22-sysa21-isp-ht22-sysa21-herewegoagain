package application;

import java.util.ArrayList;

public class TeacherRegister {

	private ArrayList<Teacher> teacherReg = new ArrayList<Teacher>();

	public ArrayList<Teacher> getTeacherReg() {
		return teacherReg;
	}

	public void setTeacherReg(ArrayList<Teacher> teacherReg) {
		this.teacherReg = teacherReg;
	}

	public Teacher findTeacher(String employeeID) {
		for (Teacher teacher : teacherReg) {
			if (teacher.getEmployeeID().equals(employeeID)) {
				return teacher;
			}
		}
		return null;
	}

	public void addTeacher(Teacher teacher) {
		if (this.findTeacher(teacher.getEmployeeID()) == null) {
			teacherReg.add(teacher);
		}
	}

	public Teacher removeTeacher(String employeeId) {
		Teacher teacher = findTeacher(employeeId);
		if (teacher != null) {
			teacherReg.remove(teacher);
			return teacher;
		}
		return null;
	}

}
