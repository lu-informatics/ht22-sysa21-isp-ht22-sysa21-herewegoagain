package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SampleController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button btnCourseCreate;

	@FXML
	private Button btnCourseDelete;

	@FXML
	private Button btnCourseUpdate;

	@FXML
	private Button btnDepartmentCreate;

	@FXML
	private Button btnDepartmentDelete;

	@FXML
	private Button btnDepartmentUpdate;

	@FXML
	private Button btnResponsibilityGive;

	@FXML
	private Button btnResponsibilityRemove;

	@FXML
	private Button btnTeacherCreate;

	@FXML
	private Button btnTeacherDelete;

	@FXML
	private Button btnTeacherUpdate;

	@FXML
	private Button btnTeachingAddTeacher;

	@FXML
	private Button btnTeachingUpdate;

	@FXML
	private ComboBox<String> comboBoxCourseCycle;

	@FXML
	private ComboBox<?> comboBoxResponsibilityCourse;

	@FXML
	private ComboBox<?> comboBoxResponsibilityTeacher;

	@FXML
	private ComboBox<?> comboBoxTeacherTitle;

	@FXML
	private ComboBox<?> comboBoxTeachingCourse;

	@FXML
	private ComboBox<?> comboBoxTeachingTeacher;

	@FXML
	private TableView<?> tableViewCourse;

	@FXML
	private TableView<?> tableViewDepartment;

	@FXML
	private TableView<?> tableViewResponsibility;

	@FXML
	private TableView<?> tableViewTeacher;

	@FXML
	private TableView<?> tableViewTeaching;

	@FXML
	private TextArea txtAreaCourse;

	@FXML
	private TextArea txtAreaDepartment;

	@FXML
	private TextArea txtAreaResponsibility;

	@FXML
	private TextArea txtAreaTeacher;

	@FXML
	private TextArea txtAreaTeaching;

	@FXML
	private TextField txtCourseCredit;

	@FXML
	private TextField txtCourseCode;

	@FXML
	private TextField txtCourseName;

	@FXML
	private TextField txtDepartmentAddress;

	@FXML
	private TextField txtDepartmentBudget;

	@FXML
	private TextField txtDepartmentName;

	@FXML
	private TextField txtTeacherAddress;

	@FXML
	private TextField txtTeacherEmployeeID;

	@FXML
	private TextField txtTeacherHourlySalary;

	@FXML
	private TextField txtTeacherName;

	@FXML
	private TextField txtTeacherLastname;

	@FXML
	private TextField txtTeachingHours;

	// Populating Course ComboBox

// Course Lists
	// Key , Value
	HashMap<String, Course> courseList = new HashMap<>();

	// Synchronizing the HashMap
	Map<String, Course> courseMap = Collections.synchronizedMap(courseList);

//Department Lists
	// Key , Value
	HashMap<String, Department> departmentList = new HashMap<>();

	// Synchronizing the HashMap
	Map<String, Department> depMap = Collections.synchronizedMap(departmentList);

	// Departments depList = Departments;

	// Create Course
	public void btnCourseCreate(ActionEvent event) {

		String courseCode = txtCourseCode.getText();
		String courseName = txtCourseName.getText();
		String stringCourseCredit = txtCourseCredit.getText();
		String courseCycle = comboBoxCourseCycle.getValue();

		try {
			if (txtCourseCode.getText().isEmpty() || txtCourseName.getText().isEmpty()
					|| txtCourseCredit.getText().isEmpty()) {
				// Print an error message if any of the values are empty
				txtAreaCourse.setText("Error: course code, name, credits and cycle \nmust not be empty ");
			} else {

				int courseCredit = Integer.parseInt(stringCourseCredit);

				if (!courseList.containsKey(courseCode) || !courseMap.containsKey(courseCode)) {

					if (courseCredit < 0) {

						txtAreaCourse.setText("Course credit cannot be a negative value");
					} else {

						if (courseCycle != null) {

							Course course = new Course(courseCode, courseName, courseCredit, courseCycle);

							course.setCourseCode(courseCode);
							course.setCourseName(courseName);
							course.setCourseCredit(courseCredit);
							course.setCourseCycle(courseCycle);

							courseList.put(courseCode, course);

							txtAreaCourse.setText("A new Course was created: " + "\n" + "Code: " + courseCode + "\n"
									+ "Name:  " + courseName + "\n" + "Credit: " + courseCredit + "\n" + "Cycle: "
									+ courseCycle);

						} else {
							txtAreaCourse.setText("Error: Cycle may not be empty");
						}
					}
				} else {
					txtAreaCourse.setText("Error: A course with that code (" + courseMap.get(courseCode).getCourseCode()
							+ ") already exists.\nPlease make sure to use another Course code");
				}

			}

		}

		catch (NumberFormatException e) {
			txtAreaCourse.setText("Course credit must be written in numbers");
		}
	}

	// Delete Course

	// Overkill men den funkar
	public void btnCourseDelete(ActionEvent event) {

		String courseCode = txtCourseCode.getText();

		// ComboBox later
		if (!courseCode.isEmpty()) {

			Course course = courseList.get(courseCode);
			// Check if the departmentName is already in the departmentNameList HashMap
			if (courseList.containsKey(courseCode)
			/* && department.equals(departmentNameList.get(departmentName)) */) {

				courseList.get(courseCode);
				courseList.remove(courseCode, course);

				txtAreaDepartment.setText("Teacher was removed");
			} else {
				// If the departmentName is not in the HashMap, print an error message
				txtAreaDepartment.setText("Error: a teacher with that course code does not exist.");
			}
		} else {

			// If departmentName is empty, print an error message
			txtAreaDepartment.setText("Please make sure to fill in a Course Code \nto be able to delete");

			return;

		}
	}

	// Create Department

	public void btnDepartmentCreate(ActionEvent event) {
		String departmentName = txtDepartmentName.getText();
		String departmentAddress = txtDepartmentAddress.getText();
		String departmentBudget = txtDepartmentBudget.getText();

		// Return if any of the values are empty
		if (departmentName.isEmpty() || txtDepartmentAddress.getText().isEmpty()
				|| txtDepartmentBudget.getText().isEmpty()) {
			// Print an error message
			txtAreaDepartment.setText("Error: department name, address, and budget \nmust not be empty.");
			return;
		}

		// Parse the budget as a double
		double depBudget;
		try {
			depBudget = Double.parseDouble(departmentBudget);
		} catch (NumberFormatException e) {
			txtAreaDepartment.setText("Department Budget must be written in numbers");
			return;
		}

		// Check if the departmentName is already in the departmentNameList HashMap
		if (departmentList.containsKey(departmentName) || depMap.containsKey(departmentName)) {
			txtAreaDepartment.setText(
					"Error: A department with that name already exists.\nPlease make sure to use another Department Name");
			return;
		}

		// Check that departmentBudget is not a negative value
		if (depBudget < 0) {
			txtAreaDepartment.setText("Budget cannot be negative value");
			return;
		}

		// Create a new Department object with the given values
		Department dep = new Department(departmentName, departmentAddress, depBudget);

		// Add the department to the HashMap
		departmentList.put(departmentName, dep);

		// Print a success message
		txtAreaDepartment.setText("A new Department was created: " + "\n" + "Name: " + departmentName + "\n"
				+ "Address:  " + departmentAddress + "\n" + "Budget:" + departmentBudget);
	}

	// update
	// Gör metod if och else if //Switch för ifall man bara vill ändra budget,
	// adress eller både och
	public void btnDepartmentUpdate(ActionEvent event) {

		String departmentName = txtDepartmentName.getText();
		String departmentAddress = txtDepartmentAddress.getText();
		String departmentBudget = txtDepartmentBudget.getText(); // ändra som i 156
		try {
			if (departmentName.isEmpty()) {
				txtAreaDepartment.setText("Please make sure to fill in a Department Name \nto be able to update");

				return;
			}

			// Check if the departmentName is already in the departmentNameList HashMap
			if (departmentList.containsKey(departmentName) || depMap.containsKey(departmentName)) {

				// Get the value Department (named department) where the Key = departmentName
				Department department = departmentList.get(departmentName);

				// Set the new values
				department.setDepartmentAddress(departmentAddress);
				department.setBudget(Double.parseDouble(departmentBudget));

				txtAreaDepartment.setText("The Department: " + department.getDepartmentName() + " was updated\n"
						+ "Address:  " + department.getDepartmentAddress() + "\n" + "Budget:" + department.getBudget());

			} else

			{
				// If the departmentName is not in the HashMap, print an error message
				txtAreaDepartment.setText("Error: a department with that name does not exist.");

			}

		} catch (NumberFormatException e) {
			txtAreaDepartment.setText("Department Budget must be written in numbers");
		}
	}

	// Overkill men den funkar
	public void btnDepartmentDelete(ActionEvent event) {

		String departmentName = txtDepartmentName.getText();

		// ComboBox later
		if (!departmentName.isEmpty()) {

			Department dep = departmentList.get(departmentName);
			// Check if the departmentName is already in the departmentNameList HashMap
			if (departmentList.containsKey(departmentName)
			/* && department.equals(departmentNameList.get(departmentName)) */) {

				departmentList.get(departmentName);
				departmentList.remove(departmentName, dep);

				txtAreaDepartment.setText("The Department was deleted");
			} else {
				// If the departmentName is not in the HashMap, print an error message
				txtAreaDepartment.setText("Error: a department with that name does not exist.");
			}
		} else {

			// If departmentName is empty, print an error message
			txtAreaDepartment.setText("Please make sure to fill in a Department Name \nto be able to delete");

			return;

		}
	}
}
