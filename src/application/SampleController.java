package application;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.net.URL;
import java.util.ResourceBundle;
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






	
	/*
	//      Key ,    Value
	HashMap<String, ArrayList<Departments>> departmentNameList = new HashMap<>();

	ArrayList<Departments> depList = new ArrayList<>();

	public ArrayList<Departments> getDepList() {
		return depList;
	}

	public void setDepList(ArrayList<Departments> depList) {
		this.depList = depList;
	}

<<<<<<< Updated upstream
	public void addDepartments(String departmentAddress, int Budget) {
		
	}
	
	
	public void pop() {
		System.out.println(  );
=======
	// Create Department
	public void btnDepartmentCreate(ActionEvent event) {

		String departmentName = txtDepartmentName.getText();
		String departmentAddress = txtDepartmentAddress.getText();
		Double departmentBudget = Double.parseDouble(txtDepartmentBudget.getText());
		// why || and not &&? It checks if ANY of these are empty - if yes, returns from
		// method, if not, continue
		if (departmentName.trim().isEmpty() || departmentAddress.trim().isEmpty() || departmentBudget == null) {
			// Print an error message if any of the values are empty
			txtAreaDepartment.appendText("Error: Department Name, Address, and Budget must not be empty.");

			txtAreaDepartment.clear();

			return;
		}
		// Check if the departmentBudget is a number and if it is a positive value
		if (departmentBudget.isNaN() == true || Double.isNaN(Double.parseDouble(txtDepartmentBudget.getText()))
				|| departmentBudget < 0) {
			// Print a message to solve the departmentBudget issue
			txtAreaDepartment.appendText("Error: Budget must be written in numbers and be a positive value");

			txtAreaDepartment.clear();
			return;
		}

		// Check if the departmentName is already in the departmentNameList HashMap
		if (departmentNameList.containsKey(departmentName)) {
			// If the departmentName is already in the HashMap, get the ArrayList associated
			// with that key
			txtAreaDepartment.appendText(
					"Error: a department with that name already exists: " + departmentNameList.get(departmentName));
			txtAreaDepartment.clear();

			return;
		}

		// If the departmentName is not in the HashMap, create a new ArrayList and add
		// the Department object to it
		ArrayList<Departments> list = new ArrayList<>();
		// Create a new Department object with the given name, address, and budget
		Departments department = new Departments(departmentName, departmentAddress, departmentBudget);
		list.add(department);
		// Add the new departmentName and ArrayList to the HashMap
		departmentNameList.put(departmentName, list);

		txtAreaDepartment.appendText("A new Department was created: " + "\n" + "Name: " + departmentName + "\n"
				+ "Address:  " + departmentAddress + "\n" + "Budget:" + departmentBudget);

		txtAreaDepartment.clear();

		return;
	}

	// update
	public void btnDepartmentUpdate(ActionEvent event) {

		String departmentName = txtDepartmentName.getText();
		String departmentAddress = txtDepartmentAddress.getText();
		Double departmentBudget = Double.parseDouble(txtDepartmentBudget.getText());

		// makes sure departmentName is not empty
		if (departmentName.trim().isEmpty()) {
			txtAreaDepartment.appendText("Please make sure to fill in a \nDepartment Name to be able to update");

			return;
		}

		// Check if the departmentName is already in the departmentNameList HashMap
		if (departmentNameList.containsKey(departmentName)) {

			// Get the departmentList associated with departmentName
			ArrayList<Departments> departmentList = departmentNameList.get(departmentName);

			for (Departments department : departmentList) {
				department.setAddress(departmentAddress);
				department.setBudget(departmentBudget);

				txtAreaDepartment.appendText("The Department: " + departmentName + "was updated\n" + "Address:  "
						+ department.getAddress() + "\n" + "Budget:" + department.getBudget());

				txtAreaDepartment.clear();

			}

			// Update the HashMap with the new values of the Department object
			departmentNameList.put(departmentName, departmentList);
		} else {
			// If the departmentName is not in the HashMap, print an error message
			txtAreaDepartment.appendText("Error: a department with that name does not exist.");
		}

>>>>>>> Stashed changes
	}
	*/
}
