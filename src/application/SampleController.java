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
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SampleController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button btnCoursesCreate;

	@FXML
	private Button btnCoursesDelete;

	@FXML
	private Button btnCoursesUpdate;

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
	private ComboBox<?> comboBoxCoursesLevels;

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
	private TableView<?> tableViewCourses;

	@FXML
	private TableView<?> tableViewDepartment;

	@FXML
	private TableView<?> tableViewResponsibility;

	@FXML
	private TableView<?> tableViewTeacher;

	@FXML
	private TableView<?> tableViewTeaching;

	@FXML
	private TextArea txtAreaCourses;

	@FXML
	private TextArea txtAreaDepartment;

	@FXML
	private TextArea txtAreaResponsibility;

	@FXML
	private TextArea txtAreaTeacher;

	@FXML
	private TextArea txtAreaTeaching;

	@FXML
	private TextField txtCoursesCode;

	@FXML
	private TextField txtCoursesCredits;

	@FXML
	private TextField txtCoursesName;

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
	private TextField txtTeachingHours;

//Department
	// Key , Value
	HashMap<String, Department> departmentNameList = new HashMap<>();

	// Synchronizing the HashMap
	Map<String, Department> depMap = Collections.synchronizedMap(departmentNameList);

	// Departments depList = Departments;

	// Create Department
	public void btnDepartmentCreate(ActionEvent event) {

		String departmentName = txtDepartmentName.getText();
		String departmentAddress = txtDepartmentAddress.getText();
		String departmentBudget = txtDepartmentBudget.getText();
		// why || and not &&? It checks if ANY of these are empty - if yes, returns from
		// method, if not, continue

		try {
			if (departmentName.trim().isEmpty() || txtDepartmentAddress.getText().isEmpty()
					|| txtDepartmentBudget.getText().isEmpty()) {
				// Print an error message if any of the values are empty
				txtAreaDepartment.setText("Error: department name, address, \nand budget must not be empty.");

			} else {

				double depBudget = Double.parseDouble(departmentBudget);

				// Check if the departmentName is already in the departmentNameList HashMap
				if (!departmentNameList.containsKey(departmentName) || !depMap.containsKey(departmentName)) {

					// If it is not in a departmentName HashMap, create one
					// Check that departmentBudget is not a negative value
					if (depBudget < 0) {

						txtAreaDepartment.setText("Budget cannot be negative value");

					} else {

						Department dep = new Department(departmentName, departmentAddress, depBudget);

						dep.setDepartmentName(departmentName);
						dep.setDepartmentAddress(departmentAddress);
						dep.setBudget(depBudget);

						departmentNameList.put(departmentName, dep);

						txtAreaDepartment.setText("A new Department was created: " + "\n" + "Name: " + departmentName
								+ "\n" + "Address:  " + departmentAddress + "\n" + "Budget:" + departmentBudget);

					}

				} else {

					// If the departmentName is already in the HashMap, get the ArrayList associated
					// with that key
					txtAreaDepartment.setText(
							"Error: A department with that name (" + depMap.get(departmentName).getDepartmentName()
									+ ") already exists.\nPlease make sure to use another Department Name ");

				}
			}
		} catch (NumberFormatException e) {
			txtAreaDepartment.setText("Department Budget must be written in numbers");
		}

	}

	// update
	// Gör metod if och else if //Switch för ifall man bara vill ändra budget,
	// adress eller både och
	public void btnDepartmentUpdate(ActionEvent event) {

		String departmentName = txtDepartmentName.getText();
		String departmentAddress = txtDepartmentAddress.getText();
		String departmentBudget = txtDepartmentBudget.getText(); // ändra som i 156
		try {
			if (departmentName.trim().isEmpty()) {
				txtAreaDepartment.setText("Please make sure to fill in a Department Name \nto be able to update");

				return;
			}

			// Check if the departmentName is already in the departmentNameList HashMap
			if (departmentNameList.containsKey(departmentName) || depMap.containsKey(departmentName)) {

				// Get the value Department (named department) where the Key = departmentName
				Department department = departmentNameList.get(departmentName);

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

	public void btnDepartmentDelete(ActionEvent event) {

		String departmentName = txtDepartmentName.getText();

		if (departmentName.trim().isEmpty()) {
			txtAreaDepartment.setText("Please make sure to fill in a Department Name \nto be able to delete");

			return;
		} else {
				// Get the value Department (named department) where the Key = departmentName
				//Department department = departmentNameList.get(departmentName);

			// Check if the departmentName is already in the departmentNameList HashMap
			if (departmentNameList.containsKey(departmentName)
					/*&& department.equals(departmentNameList.get(departmentName))*/) {

				departmentNameList.remove(departmentName);
				
				txtAreaDepartment.setText("The Department was deleted");
			} else {
				// If the departmentName is not in the HashMap, print an error message
				txtAreaDepartment.setText("Error: a department with that name does not exist.");
			}
		}
	}
}
