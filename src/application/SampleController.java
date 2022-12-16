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
import javafx.scene.control.TableRow;
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

	CourseRegister courseReg = new CourseRegister();

	// ObservableList
	ObservableList<Course> courseList = FXCollections.observableArrayList();

	@FXML
	private TableView<Course> tableViewCourse = new TableView<>();

	@FXML
	private TableColumn<Course, Double> tableColumnCourseCode = new TableColumn<>("Key");

	@FXML
	private TableColumn<Course, String> tableColumnCourseName = new TableColumn<>("Value");

	@FXML
	private TableColumn<Course, Integer> tableColumnCourseCredits = new TableColumn<>("Value");

	@FXML
	private TableColumn<Course, String> tableColumnCourseCycle = new TableColumn<>("Value");

	// Department Lists

	DepartmentRegister depReg = new DepartmentRegister();

	ObservableList<Department> departmentList = FXCollections.observableArrayList();

	@FXML
	private TableView<Department> tableViewDepartment;

	@FXML
	private TableColumn<Department, String> tableColumnDepartmentName = new TableColumn<>("Key");

	@FXML
	private TableColumn<Department, String> tableColumnDepartmentAddress = new TableColumn<>("Value");

	@FXML
	private TableColumn<Department, Double> tableColumnDepartmentBudget = new TableColumn<>("Value");

	// Teacher Lists
	TeacherRegister teacherReg = new TeacherRegister();

	ObservableList<Teacher> teacherList = FXCollections.observableArrayList();

	@FXML
	private TableView<Teacher> tableViewTeacher;

	@FXML
	private TableColumn<Teacher, Integer> columnEmployeeID = new TableColumn<>("Key");;

	@FXML
	private TableColumn<Teacher, String> columnTeacherName = new TableColumn<>("Value");;

	@FXML
	private TableColumn<Teacher, String> columnTeacherAddress = new TableColumn<>("Value");;

	@FXML
	private TableColumn<Teacher, Double> columnTeacherSalary = new TableColumn<>("Value");;

	@FXML
	private TableColumn<Teacher, String> columnTeacherTitle = new TableColumn<>("Value");;

	public void initialize() {

		// TableColumn Course

		tableColumnCourseCode.setCellValueFactory(new PropertyValueFactory<Course, Double>("courseCode"));
		tableColumnCourseName.setCellValueFactory(new PropertyValueFactory<Course, String>("courseName"));
		tableColumnCourseCredits.setCellValueFactory(new PropertyValueFactory<Course, Integer>("courseCredit"));
		tableColumnCourseCycle.setCellValueFactory(new PropertyValueFactory<Course, String>("courseCycle"));

		// TableView Course
		tableViewCourse.setItems(courseList);

		tableViewCourse.setRowFactory(tv -> {

			TableRow<Course> row = new TableRow<>();
			row.setOnMouseClicked(event -> {

				Course rowData = row.getItem();
				txtCourseCode.setText(rowData.getCourseCode().toString());

			});
			return row;
		});

		// TableColumn Department

		tableColumnDepartmentName.setCellValueFactory(new PropertyValueFactory<Department, String>("departmentName"));
		tableColumnDepartmentAddress
				.setCellValueFactory(new PropertyValueFactory<Department, String>("departmentAddress"));
		tableColumnDepartmentBudget.setCellValueFactory(new PropertyValueFactory<Department, Double>("budget"));

		// TableView Department

		tableViewDepartment.setItems(departmentList);

		tableViewDepartment.setRowFactory(tv -> {

			TableRow<Department> row = new TableRow<>();
			row.setOnMouseClicked(event -> {

				Department rowData = row.getItem();
				txtDepartmentName.setText(rowData.getDepartmentName());

			});
			return row;
		});

		// TableColumn Teacher

		columnEmployeeID.setCellValueFactory(new PropertyValueFactory<Teacher, Integer>("employeeID"));
		columnTeacherName.setCellValueFactory(new PropertyValueFactory<Teacher, String>("teacherName"));
		columnTeacherAddress.setCellValueFactory(new PropertyValueFactory<Teacher, String>("teacherAddress"));
		columnTeacherSalary.setCellValueFactory(new PropertyValueFactory<Teacher, Double>("hourlySalary"));
		columnTeacherTitle.setCellValueFactory(new PropertyValueFactory<Teacher, String>("teacherTitle"));

		// TableView Teacher

		tableViewTeacher.setItems(teacherList);

		tableViewTeacher.setRowFactory(tv -> {

			TableRow<Teacher> row = new TableRow<>();
			row.setOnMouseClicked(event -> {

				Teacher rowData = row.getItem();
				txtTeacherEmployeeID.setText(Integer.toString(rowData.getEmployeeID()));

			});
			return row;
		});

//Populating ComboBoxes
		// Teacher

		// Courses

		// Course Cycles
		comboBoxCourseCycle.getItems().addAll("First Cycle", "Second Cycle", "Third Cycle");
		comboBoxCourseCycle.getSelectionModel().selectFirst(); // cycles?
		// Course Responsibility //Lista över Teacher och Courses behövs

		// Populating Teacher Title Combobox
		comboBoxTeacherTitle.getItems().addAll("Lecturer", "Assistant Professor", "Associate Professor", "Professor");
		comboBoxTeacherTitle.getSelectionModel().selectFirst();

	}

// Create Course

	public void btnCourseCreate(ActionEvent event) {
		String courseCode = txtCourseCode.getText();
		String courseName = txtCourseName.getText();
		String stringCourseCredit = txtCourseCredit.getText();
		String courseCycle = comboBoxCourseCycle.getValue();

		if (txtCourseCode.getText().isEmpty() || txtCourseName.getText().isEmpty()
				|| txtCourseCredit.getText().isEmpty()) {
			// Print an error message if any of the values are empty
			txtAreaCourse.setText("Error: course code, name, credits and cycle \nmust not be empty ");
			return;
		}
		// Parse the credit as an int
		int courseCredit;
		try {
			courseCredit = Integer.parseInt(stringCourseCredit);
		} catch (NumberFormatException e) {
			txtAreaCourse.setText("Course credit must be written in numbers");
			return;
		}

		Course c = courseReg.findCourse(courseCode);
		// Check if the courseCode is already in the coureList HashMap
		if (c != null) {
			txtAreaCourse.setText(
					"Error: A department with that name already exists.\nPlease make sure to use another Department Name");
			return;
		}

		// Check that courseCredit is not a negative value
		if (courseCredit < 0) {
			txtAreaCourse.setText("Course credit cannot be a negative value");
			return;
		}
		// Create a new Course object with the given values
		Course course = new Course(courseCode, courseName, courseCredit, courseCycle);

		// Add the course to the HashMap
		courseReg.addCourse(course);
		courseList.add(courseReg.findCourse(courseCode));

		txtAreaCourse.setText("A new Course was created: " + "\n" + "Code: " + courseCode + "\n" + "Name:  "
				+ courseName + "\n" + "Credit: " + courseCredit + "\n" + "Cycle: " + courseCycle);
	}

	// Update Course

	// Delete Course
	public void btnCourseDelete(ActionEvent event) {
		String courseCode = txtCourseCode.getText();
		// ComboBox later
		if (!courseCode.isEmpty()) {
			Course c = courseReg.findCourse(courseCode);
			// Check if the courseCode is already in the depReg
			if (c == null) {
				txtAreaCourse.setText("A course with course code(" + courseCode + ") does not exist");
				return;
			} else {

				courseList.remove(courseReg.findCourse(courseCode));
				courseReg.removeCourse(courseCode);
				txtAreaCourse.setText("The course (" + courseCode + ") was deleted");

			}

		} else {
			// If departmentName is empty, print an error message
			txtAreaCourse.setText("Please make sure to fill in a Course Code \nto be able to delete");
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

		Department d = depReg.findDepartment(departmentName);
		// Check if the departmentName is already in the departmentNameList HashMap
		if (d != null) {
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

		depReg.addDepartment(dep);
		departmentList.add(depReg.findDepartment(departmentName));

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

			Department d = depReg.findDepartment(departmentName);
			// Check if the departmentName is already in the departmentNameList HashMap
			if (depReg.findDepartment(departmentName).equals(d)) {

				// Get the value Department (named department) where the Key = departmentName
				depReg.findDepartment(departmentName);

				// Set the new values
				// departmentList.replace(departmentBudget, department, department);
				depReg.findDepartment(departmentName).setBudget(Double.parseDouble(departmentBudget));

				depReg.findDepartment(departmentName).setDepartmentAddress(departmentAddress);

				txtAreaDepartment.setText("The Department: " + depReg.findDepartment(departmentName) + " was updated\n"
						+ "Address:  " + depReg.findDepartment(departmentName).getDepartmentAddress() + "\n" + "Budget:"
						+ depReg.findDepartment(departmentName).getBudget());

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

			Department dep = depReg.findDepartment(departmentName);
			// Check if the departmentName is already in the departmentList
			if (dep == null) {
				txtAreaDepartment.setText("A Department with that Name(" + departmentName + ")does not exist");

				return;
			} else {
				departmentList.remove(depReg.findDepartment(departmentName));
				depReg.removeDepartment(departmentName);
				txtAreaDepartment.setText("The Department (" + departmentName + ") was deleted");

				return;
			}
		} else {
			// If departmentName is empty, print an error message
			txtAreaDepartment.setText("Please make sure to fill in a Department Name \nto be able to delete");

			return;

		}
	}

	// Teacher TableView

	public void btnTeacherCreate(ActionEvent event) {

		String teacherName = txtTeacherName.getText();
		String teacherLastname = txtTeacherLastname.getText();
		String teacherAddress = txtTeacherAddress.getText();
		String teacherID = txtTeacherEmployeeID.getText();
		String teacherSalary = txtTeacherHourlySalary.getText();
		String teacherTitle = comboBoxTeacherTitle.getValue();

		if (teacherName.isEmpty() || teacherLastname.isEmpty() || teacherAddress.isEmpty() || teacherID.isEmpty()
				|| teacherSalary.isEmpty() || teacherTitle.isEmpty()) {
			txtAreaTeacher.setText("Please make sure all required fields have been filled in");
			return;
		}

		double salary;
		try {
			salary = Double.parseDouble(teacherSalary);

		} catch (NumberFormatException e) {
			txtAreaTeacher.setText("Teacher salary must be written in numbers");
			return;
		}

		Teacher t = teacherReg.findTeacher(Integer.parseInt(teacherID));
		if (t != null) {
			txtAreaTeacher.setText("A teacher with id: " + teacherID + " already exist");
			return;
		}

		int ID;
		try {
			ID = Integer.parseInt(teacherID);
		} catch (NumberFormatException e) {
			txtAreaTeacher.setText("Teacher ID must be written in numbers");
			return;

		}

		if (salary < 0) {
			txtAreaTeacher.setText("Salary cannot be negative value");
			return;
		}

		Teacher teacher = new Teacher(ID, teacherName, teacherLastname, teacherTitle, teacherAddress, salary);

// Add the teacher to the teacherReg
		teacherReg.addTeacher(teacher);
		teacherList.add(teacherReg.findTeacher(ID));

// Print a success message
		txtAreaTeacher.setText("A new teacher was created: " + "\n" + "Name: " + teacherName + " " + teacherLastname
				+ "\n" + "Employee ID: " + ID + "\n" + "Address:  " + teacherAddress + "\n" + "Hourly salary:" + salary
				+ "\n" + "Title: " + teacherTitle);
		txtTeacherName.clear();
		txtTeacherLastname.clear();
		txtTeacherAddress.clear();
		txtTeacherEmployeeID.clear();
		txtTeacherHourlySalary.clear();

	}

	public void btnTeacherDelete(ActionEvent event) {

		String teacherID = txtTeacherEmployeeID.getText();

		// ComboBox later
		if (!teacherID.isEmpty()) {

			int ID;
			try {
				ID = Integer.parseInt(teacherID);
			} catch (NumberFormatException e) {
				txtAreaTeacher.setText("Teacher ID must be written in numbers");
				return;

			}

			Teacher t = teacherReg.findTeacher(ID);
			if (t == null) {
				txtAreaTeacher.setText("A teacher with that ID(" + teacherID + ")\n" + " does not exist");

			} else {
				teacherList.remove(teacherReg.findTeacher(ID));
				teacherReg.removeTeacher(ID);
				txtAreaTeacher.setText("The teacher with ID("+ teacherID+ ") was deleted");

			}

		} else {
			txtAreaTeacher.setText("Plase make sure to fill in a TeacherID \n" + "to be able to delete");
		}

	}

	// Teacher update
	public void teacherUpdate(ActionEvent event) {
		String teacherName = txtTeacherName.getText();
		String teacherLastname = txtTeacherLastname.getText();
		String teacherAddress = txtTeacherAddress.getText();
		String teacherID = txtTeacherEmployeeID.getText();
		String teacherSalary = txtTeacherHourlySalary.getText();
		String teacherTitle = (String) comboBoxTeacherTitle.getValue();
		try {
			if (teacherID.isEmpty()) {
				txtAreaTeacher.setText("Please make sure to fill in a Teacher ID \nto be able to update");
				return;
			}

			Teacher t = teacherReg.findTeacher(Integer.parseInt(teacherID));
			// Check if the departmentName is already in the departmentNameList HashMap
			if (teacherReg.findTeacher(Integer.parseInt(teacherID)).equals(t)) {
				txtAreaTeacher.setText("The teacher: " + teacherName + " " + teacherLastname + " was updated" + "\n"
						+ "Employee ID: " + teacherID + "\n" + "Address:  " + teacherAddress + "\n" + "Hourly salary:"
						+ teacherSalary + "\n" + "Title: " + teacherTitle);
			} else {
				// If the departmentName is not in the HashMap, print an error message
				txtAreaTeacher.setText("Error: a teacher with that ID does not exist.");
			}

		} catch (NumberFormatException e) {
			txtAreaTeacher.setText("Teacher Salary must be written in numbers");
		}
	}

}
