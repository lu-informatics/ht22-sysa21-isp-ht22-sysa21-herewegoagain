package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ResourceBundle;
import java.net.URL;
import java.util.ResourceBundle;
import application.Course;
import application.Department;
import application.Teacher;
import javafx.beans.binding.Binding;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.MapChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

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
	private ComboBox<String> comboBoxResponsibilityCourse;

	@FXML
	private ComboBox<String> comboBoxResponsibilityTeacher;

	@FXML
	private ComboBox<String> comboBoxTeacherTitle;

	@FXML
	private ComboBox<?> comboBoxTeachingCourse;

	@FXML
	private ComboBox<?> comboBoxTeachingTeacher;

	@FXML
	private TableView<?> tableViewResponsibility;

	@FXML
	private TableView<Teacher> tableViewTeacher;
	
	@FXML
	private TableColumn<Teacher, String> columnAddress;

	@FXML
	private TableColumn<Teacher, String> columnEmployeeID;

	@FXML
	private TableColumn<Teacher, String> columnSalary;

	@FXML
	private TableColumn<Teacher, String> columnTeacherName;

	@FXML
	private TableColumn<Teacher, String> columnTitle;


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

	// Course Lists

	HashMap<String, Course> courseList = new HashMap<String, Course>();

	// ObservableList from the HashMap - This is to keep track of
	// changes in the HashMap
	ObservableList<Course> courses = FXCollections.observableArrayList();
	
  @FXML
	private TableView<Course> tableViewCourse = new TableView<>();

	@FXML
	private TableColumn<Course, String> tableColumnCourseCode = new TableColumn<>("Key");

	@FXML
	private TableColumn<Course, String> tableColumnCourseName = new TableColumn<>("Value");

	@FXML
	private TableColumn<Course, Integer> tableColumnCourseCredits = new TableColumn<>("Value");

	@FXML
	private TableColumn<Course, String> tableColumnCourseCycle = new TableColumn<>("Value");

  // Department Lists

	Map<String, Department> departmentList = new HashMap<>();

	ObservableList<Department> departments = FXCollections.observableArrayList();
  
	@FXML
	private TableView<Department> tableViewDepartment;

	@FXML
	private TableColumn<Department, String> tableColumnDepartmentName = new TableColumn<>("Key");

	@FXML
	private TableColumn<Department, String> tableColumnDepartmentAddress = new TableColumn<>("Value");

	@FXML
	private TableColumn<Department, Double> tableColumnDepartmentBudget = new TableColumn<>("Value");

	// Teacher List
	HashMap<String, Teacher> teacherList = new HashMap<>()
  ObservableList<Teacher> teachers = FXCollections.observableArrayList();
 

	public void initialize() {

		// TableColumn Course

		tableColumnCourseCode.setCellValueFactory(new PropertyValueFactory<Course, String>("courseCode"));
		tableColumnCourseName.setCellValueFactory(new PropertyValueFactory<Course, String>("courseName"));
		tableColumnCourseCredits.setCellValueFactory(new PropertyValueFactory<Course, Integer>("courseCredit"));
		tableColumnCourseCycle.setCellValueFactory(new PropertyValueFactory<Course, String>("courseCycle"));

		// TableView Course
		tableViewCourse.setItems(courses);


		// TableColumn Department

		tableColumnDepartmentName.setCellValueFactory(new PropertyValueFactory<Department, String>("departmentName"));
		tableColumnDepartmentAddress.setCellValueFactory(new PropertyValueFactory<Department, String>("departmentAddress"));
		tableColumnDepartmentBudget.setCellValueFactory(new PropertyValueFactory<Department, Double>("budget"));

		// TableView Department

		tableViewDepartment.setItems(departments);

		// Populating Course ComboBox
		// Course
		comboBoxCourseCycle.getItems().addAll("First Cycle", "Second Cycle", "Third Cycle");
		comboBoxCourseCycle.getSelectionModel().selectFirst();

		/*
		 * Course Responsibility //for(Course course :
		 * courseList.containsKey(courseCode)) {
		 * 
		 * }
		 * 
		 * comboBoxResponsibilityCourse.getItems().add(courseList.get(""+courseList).
		 * getCourseCode());
		 * comboBoxResponsibilityCourse.getSelectionModel().selectFirst();
		 * comboBoxTeachingCourse.getSelectionModel().selectFirst();
		 * 
		 */

	
 
//Populating ComboBoxes
		// Teacher
		comboBoxTeacherTitle.getItems().addAll("Lecturer", "Assistant Professor", "Associate Professor", "Professor");
		// Course
		comboBoxCourseCycle.getItems().addAll("First Cycle", "Second Cycle", "Third Cycle"); // Add the "names" in the
																								// cycles?
		// Course Responsibility //Lista över Teacher och Courses behövs
		
		
		// Teaching
	}
  
// Create Course


	public void btnCourseCreate(ActionEvent event) {

		String courseCode = txtCourseCode.getText();
		String courseName = txtCourseName.getText();
		String stringCourseCredit = txtCourseCredit.getText();
		String courseCycle = comboBoxCourseCycle.getValue().toString();

		try {
			if (txtCourseCode.getText().isEmpty() || txtCourseName.getText().isEmpty()
					|| txtCourseCredit.getText().isEmpty()) {
				// Print an error message if any of the values are empty
				txtAreaCourse.setText("Error: course code, name, credits and cycle \nmust not be empty ");
			} else {

				int courseCredit = Integer.parseInt(stringCourseCredit);

				if (!courseList.containsKey(courseCode)) {

					if (courseCredit < 0) {

						txtAreaCourse.setText("Course credit cannot be a negative value");
					} else {

						if (courseCycle != null) {

							Course course = new Course(courseCode, courseName, courseCredit, courseCycle);

							tableViewCourse.refresh();


							courseList.put(courseCode, course);
							courses.add(courseList.get(courseCode));

							txtAreaCourse.setText("A new Course was created: " + "\n" + "Code: " + courseCode + "\n"
									+ "Name:  " + courseName + "\n" + "Credit: " + courseCredit + "\n" + "Cycle: "
									+ courseCycle);

						} else {
							txtAreaCourse.setText("Error: Cycle may not be empty");
						}
					}
				} else {
					txtAreaCourse.setText("Error: A course with that code (" + courseCode
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
			if (courseList.containsKey(courseCode)) {

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
		if (departmentList.containsKey(departmentName)) {
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
		departments.add(departmentList.get(departmentName));

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
			if (departmentList.containsKey(departmentName)) {

				// Get the value Department (named department) where the Key = departmentName
				Department department = departmentList.get(departmentName);

				// Set the new values
				departmentList.replace(departmentBudget, department, department);
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
			if (departmentList.containsKey(departmentName)) {

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
	//Populating Teacher Title Combobox
	public void initialize() {
	comboBoxTeacherTitle.getItems().addAll("Lecturer", "Assistant Professor", "Associate Professor", "Professor" );
	}
	
	//Teacher TableView
	
	

public void btnTeacherCreate (ActionEvent event)  {
	
	String TeacherName = txtTeacherName.getText();
	String TeacherLastname = txtTeacherLastname.getText();
	String TeacherAddress = txtTeacherAddress.getText();
	String TeacherID = txtTeacherEmployeeID.getText();
	String TeacherSalary = txtTeacherHourlySalary.getText();
	String TeacherTitle = comboBoxTeacherTitle.getValue();


if (TeacherName.isEmpty() || TeacherLastname.isEmpty()|| TeacherAddress.isEmpty()
		|| TeacherID.isEmpty() || TeacherSalary.isEmpty()) {
	txtAreaTeacher.setText("Please make sure all required fields have been filled in");
	return;
}

int Salary;
try {
	Salary = Integer.parseInt(TeacherSalary);
	
} catch (NumberFormatException e) {
    txtAreaTeacher.setText("Teacher salary must be written in numbers");
    return;
}
	
if (teacherList.containsKey(TeacherID) ) {
    txtAreaTeacher.setText("A teacher with id: " + TeacherID + " already exist");
    return;
    
}
    
    if (Salary < 0) {
        txtAreaTeacher.setText("Salary cannot be negative value");
        return;
    }
    
    int ID = Integer.parseInt(TeacherID); 
Teacher teacher = new Teacher(ID, TeacherName, TeacherLastname, TeacherTitle, TeacherAddress, Salary);


// Add the department to the HashMap
teacherList.put(TeacherID, teacher);

// Print a success message
txtAreaTeacher.setText("A new teacher was created: " + "\n" + "Name: " + TeacherName + " " + TeacherLastname + "\n" + "Employee ID: "
+ ID + "\n" + "Address:  " + TeacherAddress + "\n" + "Hourly salary:" + Salary ); //+  "\n"  + "Title: " + TeacherTitle);
}

public void initialize() {
	private ObservableList<String, Teacher> teacherList = FXCollections.observableArrayList();
}

tableViewTeacher.setItems(null);;

	

	public void btnTeacherDelete (ActionEvent event) {

		String TeacherID = txtTeacherEmployeeID.getText();


		if (!TeacherID.isEmpty()) {

			Teacher teacher = teacherList.get(TeacherID);
			
			if (teacherList.containsKey(TeacherID)) {

				teacherList.get(TeacherID);
				teacherList.remove(TeacherID);

				txtAreaTeacher.setText("The Teacher was deleted");
			} else {
				// If the departmentName is not in the HashMap, print an error message
				txtAreaTeacher.setText("A teacher with id: " + TeacherID + " does not exist");
			}
		} else {

			// If departmentName is empty, print an error message
			txtAreaTeacher.setText("Please make sure to fill in a Teacher ID \nto be able to delete");

			return;

		}

	}
	// Teacher update
	public void teacherUpdate(ActionEvent event) {

		String TeacherName = txtTeacherName.getText();
		String TeacherLastname = txtTeacherLastname.getText();
		String TeacherAddress = txtTeacherAddress.getText();
		String TeacherID = txtTeacherEmployeeID.getText();
		String TeacherSalary = txtTeacherHourlySalary.getText();
		String TeacherTitle = (String) comboBoxTeacherTitle.getValue();
		try {
			if (TeacherID.isEmpty()) {
				txtAreaTeacher.setText("Please make sure to fill in a Teacher ID \nto be able to update");
				return;
			}

			// Check if the departmentName is already in the departmentNameList HashMap
			if (teacherList.containsKey(TeacherID)) {

				// Get the value Department (named department) where the Key = departmentName
				Teacher teacher = teacherList.get(TeacherID);

				// Set the new values
				teacherList.replace(TeacherName, teacher);
				teacherList.replace(TeacherLastname, teacher);
				teacherList.replace(TeacherAddress, teacher);
				teacherList.replace(TeacherID, teacher);
				teacherList.replace(TeacherSalary, teacher);
				teacherList.replace(TeacherTitle, teacher);
				

				txtAreaTeacher.setText("The teacher: " + TeacherName + TeacherLastname + " was updated" +  "\n" + "Employee ID: " 
				+ TeacherID + "\n" + "Address:  " + TeacherAddress + "\n" + "Hourly salary:" + TeacherSalary); // + "\n"  + "Title: " + TeacherTitle);

			} else

			{
				// If the departmentName is not in the HashMap, print an error message
				txtAreaTeacher.setText("Error: a teacher with that ID does not exist.");

			}

		} catch (NumberFormatException e) {
			txtAreaTeacher.setText("Teacher Salary must be written in numbers");
		}
	}
	
}





