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
	private TextField txtTeacherLastName;

	@FXML
	private TextField txtTeachingHours;

	// Course Lists

	private CourseRegister courseReg = new CourseRegister();

	// ObservableList

	ObservableList<Course> courseList = FXCollections.observableArrayList();
	ObservableList<String> courses = FXCollections.observableArrayList();

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

	private DepartmentRegister depReg = new DepartmentRegister();

	private ObservableList<Department> departmentList = FXCollections.observableArrayList();

	@FXML
	private TableView<Department> tableViewDepartment;

	@FXML
	private TableColumn<Department, String> tableColumnDepartmentName = new TableColumn<>("Key");

	@FXML
	private TableColumn<Department, String> tableColumnDepartmentAddress = new TableColumn<>("Value");

	@FXML
	private TableColumn<Department, Double> tableColumnDepartmentBudget = new TableColumn<>("Value");

	// Teacher Lists
	private TeacherRegister teacherReg = new TeacherRegister();


	ObservableList<Teacher> teacherList = FXCollections.observableArrayList();
	ObservableList<String> teachers = FXCollections.observableArrayList();


	@FXML
	private TableView<Teacher> tableViewTeacher;

	@FXML
	private TableColumn<Teacher, Integer> columnEmployeeID = new TableColumn<>("Key");;

	@FXML
	private TableColumn<Teacher, String> columnTeacherName = new TableColumn<>("Value");;

	@FXML
	private TableColumn<Teacher, String> columnTeacherLastName = new TableColumn<>("Value");

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
				txtCourseName.setText(rowData.getCourseName());
				txtCourseCredit.setText(Integer.toString(rowData.getCourseCredit()));

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
				txtDepartmentAddress.setText(rowData.getDepartmentAddress());
				txtDepartmentBudget.setText(Double.toString(rowData.getBudget()));

			});
			return row;
		});

		// TableColumn Teacher

		columnEmployeeID.setCellValueFactory(new PropertyValueFactory<Teacher, Integer>("employeeID"));
		columnTeacherName.setCellValueFactory(new PropertyValueFactory<Teacher, String>("teacherName"));
		columnTeacherLastName.setCellValueFactory(new PropertyValueFactory<Teacher, String>("teacherLastName"));
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
				txtTeacherName.setText(rowData.getTeacherName());
				txtTeacherLastName.setText(rowData.getTeacherLastName());
				txtTeacherAddress.setText(rowData.getTeacherAddress());
				txtTeacherHourlySalary.setText(Double.toString(rowData.getHourlySalary()));
				comboBoxTeacherTitle.setValue(rowData.getTeacherTitle());

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
		comboBoxResponsibilityCourse.setItems(courses);
		comboBoxResponsibilityTeacher.setItems(teachers);

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
		courses.add(courseCode);

		txtAreaCourse.setText("A new Course was created: " + "\n" + "Code: " + courseCode + "\n" + "Name:  "
				+ courseName + "\n" + "Credit: " + courseCredit + "\n" + "Cycle: " + courseCycle);
		
		txtCourseCode.clear();
		txtCourseName.clear();
		txtCourseCredit.clear();
	}

	// Update Course

	public void btnCourseUpdate(ActionEvent event) {
		String courseCode = txtCourseCode.getText();
		String courseName = txtCourseName.getText();
		String stringCourseCredit = txtCourseCredit.getText();
		String courseCycle = comboBoxCourseCycle.getValue();
		
		try {
			int courseCredit;

			courseCredit = Integer.parseInt(stringCourseCredit);

			Course c = courseReg.findCourse(courseCode);
			// Check if the courseCode exists
			if (c != null) {

				// Update courseName
				if (c.getCourseCredit() == courseCredit && c.getCourseCycle().equals(courseCycle)) {

					Course updatedCourse = new Course(courseCode, courseName, courseCredit, courseCycle);

					courseList.remove(courseReg.findCourse(courseCode));
					courseReg.removeCourse(courseCode);
					courseReg.addCourse(updatedCourse);
					courseList.add(updatedCourse);
					
					txtAreaCourse.setText("Course Name was updated for ("+courseCode +")");
					
					txtCourseCode.clear();
					txtCourseName.clear();
					txtCourseCredit.clear();

				}

				// Update courseCredit
				if (c.getCourseName().equals(courseName) && c.getCourseCycle().equals(courseCycle)) {

					Course updatedCourse = new Course(courseCode, courseName, courseCredit, courseCycle);

					courseList.remove(courseReg.findCourse(courseCode));
					courseReg.removeCourse(courseCode);
					courseReg.addCourse(updatedCourse);
					courseList.add(updatedCourse);
					
					txtAreaCourse.setText("Course Credit was updated for ("+courseCode +")");
					
					txtCourseCode.clear();
					txtCourseName.clear();
					txtCourseCredit.clear();
				}

				// Update courseCycle
				if (c.getCourseName().equals(courseName) && c.getCourseCredit() == courseCredit) {

					Course updatedCourse = new Course(courseCode, courseName, courseCredit, courseCycle);

					courseList.remove(courseReg.findCourse(courseCode));
					courseReg.removeCourse(courseCode);
					courseReg.addCourse(updatedCourse);
					courseList.add(updatedCourse);
					
					txtAreaCourse.setText("Course Cycle was updated for ("+courseCode +")");
					
					txtCourseCode.clear();
					txtCourseName.clear();
					txtCourseCredit.clear();
				}

				// Update all
				if (!c.getCourseName().equals(courseName) && c.getCourseCredit() != courseCredit
						&& !c.getCourseCycle().equals(courseCycle)) {

					
					Course updatedCourse = new Course(courseCode, courseName, courseCredit, courseCycle);

					courseList.remove(courseReg.findCourse(courseCode));
					courseReg.removeCourse(courseCode);
					courseReg.addCourse(updatedCourse);
					courseList.add(updatedCourse);
					
					txtAreaCourse.setText("Course Name, Credit and Cycke was updated for ("+courseCode +")");
					
					txtCourseCode.clear();
					txtCourseName.clear();
					txtCourseCredit.clear();
					
				}
				// No Update
				if (c.getCourseName().equals(courseName) && c.getCourseCredit() == courseCredit
						&& c.getCourseCycle().equals(courseCycle)) {

					txtAreaCourse.setText("You have to make a change on Course(" +courseCode+") "
							+ "\n in order to update");
					
				}

			} else {
				txtAreaCourse.setText(
						"Error: A department with that name does not exist.\nPlease make sure to use another Department Name");
				return;
			}

		} catch (NumberFormatException n) {
			txtAreaCourse.setText("Make sure courseCredit is written in number");
		} catch (NullPointerException npe) {
			txtAreaCourse.setText("Make sure no value is left empty");
		}
	}

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
		
		txtDepartmentName.clear();
		txtDepartmentAddress.clear();
		txtDepartmentBudget.clear();
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
			} else {

				Department d = depReg.findDepartment(departmentName);
				// Check if the departmentName is already in the departmentNameList HashMap
				if (d != null) {

					// om adressen är densamma som den som har skrivits in
					// ändra budget
					if (d.getDepartmentAddress().equals(departmentAddress)) {
// går nog att korta ner
						double depBudget;
						try {
							depBudget = Double.parseDouble(departmentBudget);
						} catch (NumberFormatException e) {
							txtAreaDepartment.setText("Department Budget must be written in numbers");
							return;
						}
						if (depBudget < 0) {
							txtAreaDepartment.setText("Budget cannot be negative value");
							return;
						}
						Department dep = new Department(departmentName, departmentAddress, depBudget);

						departmentList.remove(depReg.findDepartment(departmentName));
						depReg.removeDepartment(departmentName);
						depReg.addDepartment(dep);
						departmentList.add(dep);

						txtAreaDepartment.setText("Updated Budget of Department (" + departmentName + ")");
						
						txtDepartmentName.clear();
						txtDepartmentAddress.clear();
						txtDepartmentBudget.clear();

					}
					// if the budget is the same as in depReg, update departmentAddress
					if (d.getBudget() == (Double.parseDouble(departmentBudget))) {

						Department dep = new Department(departmentName, departmentAddress,
								Double.parseDouble(departmentBudget));

						departmentList.remove(depReg.findDepartment(departmentName));
						depReg.removeDepartment(departmentName);
						depReg.addDepartment(dep);
						departmentList.add(dep);

						txtAreaDepartment.setText("Updated Adress of Department (" + departmentName + ")");
						
						txtDepartmentName.clear();
						txtDepartmentAddress.clear();
						txtDepartmentBudget.clear();

					}
					// Om ingen är lik, ändra båda
					if (d.getBudget() != (Double.parseDouble(departmentBudget))
							&& !d.getDepartmentAddress().equals(departmentAddress)) {

						double depBudget;
						try {
							depBudget = Double.parseDouble(departmentBudget);
						} catch (NumberFormatException e) {
							txtAreaDepartment.setText("Department Budget must be written in numbers");
							return;
						}
						if (depBudget < 0) {
							txtAreaDepartment.setText("Budget cannot be negative value");
							return;
						}

						Department dep = new Department(departmentName, departmentAddress, depBudget);

						departmentList.remove(depReg.findDepartment(departmentName));
						depReg.removeDepartment(departmentName);
						depReg.addDepartment(dep);
						departmentList.add(dep);

						txtAreaDepartment
								.setText("Updated Address and Budget of \n" + "Department(" + departmentName + ")");
						
						txtDepartmentName.clear();
						txtDepartmentAddress.clear();
						txtDepartmentBudget.clear();

					}

					// Om båda är lika, ändra inget
					if (d.getBudget() == (Double.parseDouble(departmentBudget))
							&& d.getDepartmentAddress().equals(departmentAddress)) {

						txtAreaDepartment.setText(
								"You have to change either Department Address or Budget\n" + "in order to Update");

					}

				} else {

					txtAreaDepartment.setText(
							"Error: A department with that name does exists.\nPlease make sure to use another Department Name");
					return;

				}

			}

		} catch (NullPointerException np) {
			txtAreaTeacher.setText("A value must not be left empty");
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

	// Teacher

	public void btnTeacherCreate(ActionEvent event) {

		String teacherName = txtTeacherName.getText();
		String teacherLastname = txtTeacherLastName.getText();
		String teacherAddress = txtTeacherAddress.getText();
		String teacherID = txtTeacherEmployeeID.getText();
		String teacherSalary = txtTeacherHourlySalary.getText();
		String teacherTitle = comboBoxTeacherTitle.getValue();

		try {
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

			int iD;
			try {
				iD = Integer.parseInt(teacherID);
			} catch (NumberFormatException e) {
				txtAreaTeacher.setText("Teacher ID must be written in numbers");
				return;

			}

			if (salary < 0) {
				txtAreaTeacher.setText("Salary cannot be negative value");
				return;
			}

			Teacher teacher = new Teacher(iD, teacherName, teacherLastname, teacherTitle, teacherAddress, salary);


// Add the teacher to the teacherReg
		teacherReg.addTeacher(teacher);
		teacherList.add(teacherReg.findTeacher(iD));
		teachers.add(teacherID);

// Print a success message
		txtAreaTeacher.setText("A new teacher was created: " + "\n" + "Name: " + teacherName + " " + teacherLastname
				+ "\n" + "Employee ID: " + iD + "\n" + "Address:  " + teacherAddress + "\n" + "Hourly salary:" + salary
				+ "\n" + "Title: " + teacherTitle);
		txtTeacherName.clear();
		txtTeacherLastName.clear();
		txtTeacherAddress.clear();
		txtTeacherEmployeeID.clear();
		txtTeacherHourlySalary.clear();

		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (NullPointerException npe) {
			txtAreaTeacher.setText("Make sure no value is empty");
		}


	}
	

	public void btnTeacherDelete(ActionEvent event) {

		String teacherID = txtTeacherEmployeeID.getText();

		// ComboBox later
		if (!teacherID.isEmpty()) {

			int iD;
			try {
				iD = Integer.parseInt(teacherID);
			} catch (NumberFormatException e) {
				txtAreaTeacher.setText("Teacher ID must be written in numbers");
				return;

			}

			Teacher t = teacherReg.findTeacher(iD);
			if (t == null) {
				txtAreaTeacher.setText("A teacher with that ID(" + teacherID + ")\n" + " does not exist");

			} else {
				teacherList.remove(teacherReg.findTeacher(iD));
				teacherReg.removeTeacher(iD);
				txtAreaTeacher.setText("The teacher with ID(" + teacherID + ") was deleted");

				txtTeacherName.clear();
				txtTeacherLastName.clear();
				txtTeacherAddress.clear();
				txtTeacherEmployeeID.clear();
				txtTeacherHourlySalary.clear();
				
			}

		} else {
			txtAreaTeacher.setText("Plase make sure to fill in a TeacherID \n" + "to be able to delete");
		}

	}

	// Teacher update
	public void teacherUpdate(ActionEvent event) {
		String teacherName = txtTeacherName.getText();
		String teacherLastName = txtTeacherLastName.getText();
		String teacherAddress = txtTeacherAddress.getText();
		String teacherID = txtTeacherEmployeeID.getText();
		String teacherSalary = txtTeacherHourlySalary.getText();
		String teacherTitle = (String) comboBoxTeacherTitle.getValue();
		try {
			if (teacherID.isEmpty()) {
				txtAreaTeacher.setText("Please make sure to fill in a Teacher ID \nto be able to update");
				return;
			}

			int iD;
			try {
				iD = Integer.parseInt(teacherID);
			} catch (NumberFormatException e) {
				txtAreaTeacher.setText("Teacher ID must be written in numbers");
				return;

			}

			Teacher t = teacherReg.findTeacher(Integer.parseInt(teacherID));
			// Check if the TeacherID exists.
			if (t != null) {
				// If all these are the same as an existing teacher
				// change TeacherName
				if (t.getTeacherLastName().equals(teacherLastName) && t.getTeacherAddress().equals(teacherAddress)
						&& t.getTeacherTitle().equals(teacherTitle)) {

					Teacher updatedTeacher = new Teacher(iD, teacherName, teacherLastName, teacherTitle, teacherAddress,
							Double.parseDouble(teacherSalary));

					teacherList.remove(iD);
					teacherReg.removeTeacher(iD);
					teacherReg.addTeacher(updatedTeacher);
					teacherList.add(updatedTeacher);

					txtAreaTeacher.setText("Teacher Name changed for teacher with \n" + "EmployeeId (" + iD + ")");

					txtTeacherName.clear();
					txtTeacherLastName.clear();
					txtTeacherAddress.clear();
					txtTeacherEmployeeID.clear();
					txtTeacherHourlySalary.clear();
					
				}
				// Update LastName
				if (t.getTeacherName().equals(teacherName) && t.getTeacherAddress().equals(teacherAddress)
						&& t.getHourlySalary() == Integer.parseInt(teacherSalary)
						&& t.getTeacherTitle().equals(teacherTitle)) {

					Teacher updatedTeacher = new Teacher(iD, teacherName, teacherLastName, teacherTitle, teacherAddress,
							Double.parseDouble(teacherSalary));

					teacherList.remove(iD);
					teacherReg.removeTeacher(iD);
					teacherReg.addTeacher(updatedTeacher);
					teacherList.add(updatedTeacher);

					txtAreaTeacher.setText("Teacher Last Name changed for teacher with \n" + "EmployeeId (" + iD + ")");

					txtTeacherName.clear();
					txtTeacherLastName.clear();
					txtTeacherAddress.clear();
					txtTeacherEmployeeID.clear();
					txtTeacherHourlySalary.clear();
					
				}
				// Update Address
				if (t.getTeacherLastName().equals(teacherLastName) && t.getTeacherName().equals(teacherName)
						&& t.getHourlySalary() == Integer.parseInt(teacherSalary)
						&& t.getTeacherTitle().equals(teacherTitle)) {

					Teacher updatedTeacher = new Teacher(iD, teacherName, teacherLastName, teacherTitle, teacherAddress,
							Double.parseDouble(teacherSalary));

					teacherList.remove(iD);
					teacherReg.removeTeacher(iD);
					teacherReg.addTeacher(updatedTeacher);
					teacherList.add(updatedTeacher);

					txtAreaTeacher.setText("Teacher Name changed for teacher with \n" + "EmployeeId (" + iD + ")");

					txtTeacherName.clear();
					txtTeacherLastName.clear();
					txtTeacherAddress.clear();
					txtTeacherEmployeeID.clear();
					txtTeacherHourlySalary.clear();
				}
				// Updated Salary
				if (t.getTeacherLastName().equals(teacherLastName) && t.getTeacherName().equals(teacherName)
						&& t.getTeacherAddress().equals(teacherAddress) && t.getTeacherTitle().equals(teacherTitle)) {

					double salary;
					salary = Double.parseDouble(teacherSalary);
					txtAreaTeacher.setText("Teacher salary must be written in numbers");

					if (salary < 0) {
						txtAreaTeacher.setText("Salary cannot be negative value");
						return;
					}

					Teacher updatedTeacher = new Teacher(iD, teacherName, teacherLastName, teacherTitle, teacherAddress,
							salary);

					teacherList.remove(iD);
					teacherReg.removeTeacher(iD);
					teacherReg.addTeacher(updatedTeacher);
					teacherList.add(updatedTeacher);

					txtAreaTeacher.setText("Teacher Salary changed for teacher with \n" + "EmployeeId (" + iD + ")");

					txtTeacherName.clear();
					txtTeacherLastName.clear();
					txtTeacherAddress.clear();
					txtTeacherEmployeeID.clear();
					txtTeacherHourlySalary.clear();
				}

				// Update Title
				if (t.getTeacherLastName().equals(teacherLastName) && t.getTeacherName().equals(teacherName)
						&& t.getTeacherAddress().equals(teacherAddress)
						&& t.getHourlySalary() == Integer.parseInt(teacherSalary)) {

					Teacher updatedTeacher = new Teacher(iD, teacherName, teacherLastName, teacherTitle, teacherAddress,
							Double.parseDouble(teacherSalary));

					teacherList.remove(iD);
					teacherReg.removeTeacher(iD);
					teacherReg.addTeacher(updatedTeacher);
					teacherList.add(updatedTeacher);

					txtAreaTeacher.setText("Teacher Title changed for teacher with \n" + "EmployeeId (" + iD + ")");

					txtTeacherName.clear();
					txtTeacherLastName.clear();
					txtTeacherAddress.clear();
					txtTeacherEmployeeID.clear();
					txtTeacherHourlySalary.clear();
				}

				if (!t.getTeacherLastName().equals(teacherLastName) && !t.getTeacherName().equals(teacherName)
						&& !t.getTeacherAddress().equals(teacherAddress)
						&& t.getHourlySalary() != Integer.parseInt(teacherSalary)
						&& !t.getTeacherTitle().equals(teacherTitle)) {

					double salary;
					salary = Double.parseDouble(teacherSalary);
					txtAreaTeacher.setText("Teacher salary must be written in numbers");

					if (salary < 0) {
						txtAreaTeacher.setText("Salary cannot be negative value");
						return;
					}
					Teacher updatedTeacher = new Teacher(iD, teacherName, teacherLastName, teacherTitle, teacherAddress,
							Double.parseDouble(teacherSalary));

					teacherList.remove(iD);
					teacherReg.removeTeacher(iD);
					teacherReg.addTeacher(updatedTeacher);
					teacherList.add(updatedTeacher);

					txtAreaTeacher.setText("Name, Last Name, Address, Salary and Title was changed for\n"
							+ "Teacher with Employee ID(" + iD + ")");
					txtTeacherName.clear();
					txtTeacherLastName.clear();
					txtTeacherAddress.clear();
					txtTeacherEmployeeID.clear();
					txtTeacherHourlySalary.clear();
				}

				// If everything is the same, no change will be made
				if (t.getTeacherLastName().equals(teacherLastName) && t.getTeacherName().equals(teacherName)
						&& t.getTeacherAddress().equals(teacherAddress)
						&& t.getHourlySalary() == Integer.parseInt(teacherSalary)
						&& t.getTeacherTitle().equals(teacherTitle)) {

					txtAreaTeacher.setText("You have to change something in order to Update the Teacher");
				}

			} else {
				// If the TeacherID does not exist, print an error message
				txtAreaTeacher.setText("Error: a teacher with that ID does not exist.");
			}

		} catch (NumberFormatException e) {
			txtAreaTeacher.setText("Teacher Salary must be written in numbers");
		} catch (NullPointerException np) {
			txtAreaTeacher.setText("A value must not be left empty");
		}
	}
	
	//Assigning course for teacher responsibility
	

	public void btnResponsibilityGive(ActionEvent event) {
		String teacherId = comboBoxResponsibilityTeacher.getSelectionModel().getSelectedItem();
		String coursecode = comboBoxResponsibilityCourse.getSelectionModel().getSelectedItem();
		Course course = courseReg.findCourse((coursecode));
		Teacher teacher = teacherReg.findTeacher(Integer.parseInt(teacherId));
		
		if (teacher.findCourseResponsible(coursecode) != null) {
			txtAreaResponsibility.setText("Teacher with ID: " + teacherId + ", \n is already responsible for this course");
			return;
		}
		
		if (teacherId != null || coursecode != null) {
			teacher.addCourseResponsible(course);
			txtAreaResponsibility.setText("Teacher with employee ID: " + teacherId + ", has been assigned \n responsibility for"
					+ " course with course code: " + coursecode);
		
		
	}else { txtAreaResponsibility.setText("Please make sure you have selected a teacher and a course");
	
	
	}
		
	
		}
	
	public void btnResponsibilityRemove(ActionEvent event) {
		String teacherId = comboBoxResponsibilityTeacher.getSelectionModel().getSelectedItem();
		String courseCode = comboBoxResponsibilityCourse.getSelectionModel().getSelectedItem();
		//Course course = courseReg.findCourse((courseCode));
		Teacher teacher = teacherReg.findTeacher(Integer.parseInt(teacherId));
		
		if (teacher.findCourseResponsible(courseCode) == null) {
			txtAreaResponsibility.setText("Teacher with ID: " + teacherId + ", \n is not responsible for this course");
			return;
		}
		
		if (teacherId != null || courseCode != null) {
			teacher.removeCourseResponsible(courseCode);
			txtAreaResponsibility.setText("Teacher with employee ID: " + teacherId + ", is no longer \n responsible for"
					+ " course with course code: " + courseCode);
			return;
			
		}else { txtAreaResponsibility.setText("Please make sure you have selected a teacher and a course");
			
		}
		
	}
	

	}



