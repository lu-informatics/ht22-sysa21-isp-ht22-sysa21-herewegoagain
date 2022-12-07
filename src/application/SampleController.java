package application;

import java.util.ArrayList;
import java.util.HashMap;
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

	// Departments depList = Departments;

	// Create Department
	public void btnDepartmentCreate(ActionEvent event) {

		String departmentName = txtDepartmentName.getText();
		String departmentAddress = txtDepartmentAddress.getText();
		String departmentBudget = txtDepartmentBudget.getText();
		// why || and not &&? It checks if ANY of these are empty - if yes, returns from
		// method, if not, continue

		if (departmentName.trim().isEmpty() || txtDepartmentAddress.getText().isEmpty()
				|| txtDepartmentBudget.getText().isEmpty()) {
			// Print an error message if any of the values are empty
			txtAreaDepartment.appendText("Error: department name, address, and budget must not be empty.");
			return;
		} else {

			// Check if the departmentName is already in the departmentNameList HashMap
			if (departmentNameList.containsKey(departmentName)) {
				// If the departmentName is already in the HashMap, get the ArrayList associated
				// with that key
				System.out.println(
						"Error: a department with that name already exists: " + departmentNameList.get(departmentName));
				return;
			}


		txtAreaDepartment.appendText("A new Department was created: " + "\n" + "Name: " + departmentName + "\n"
				+ "Address:  " + departmentAddress + "\n" + "Budget:" + departmentBudget);

		txtAreaDepartment.clear();

		return;
		
		
		///den är inte klar än
		}

	}

	// update
	//den är inte klar än
	public void btnDepartmentUpdate(ActionEvent event) {

		String departmentName = txtDepartmentName.getText();
		String departmentAddress = txtDepartmentAddress.getText();
		Double departmentBudget = Double.parseDouble(txtDepartmentBudget.getText()); //ändra som i 156 

		if (departmentName.trim().isEmpty()) {
			txtAreaDepartment.appendText("Please make sure to fill in a \nDepartment Name to be able to update");

			return;
		}

		// Check if the departmentName is already in the departmentNameList HashMap
		if (departmentNameList.containsKey(departmentName)) {

			// Get the value Department (named department) where the Key = departmentName
			Department department = departmentNameList.get(departmentName);

			// Set the new values
			department.setAddress(departmentAddress);
			department.setBudget(departmentBudget);

			txtAreaDepartment.appendText("The Department: " + department.getdepartmentName() + "was updated\n"
					+ "Address:  " + department.getAddress() + "\n" + "Budget:" + department.getBudget());

			txtAreaDepartment.clear();

		} else

		{
			// If the departmentName is not in the HashMap, print an error message
			txtAreaDepartment.appendText("Error: a department with that name does not exist.");
		}

	}
}
