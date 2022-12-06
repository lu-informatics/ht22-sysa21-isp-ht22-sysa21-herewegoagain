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

	public void addDepartments(String departmentAddress, int Budget) {
		
	}
	
	
	public void pop() {
		System.out.println(  );
	}
	*/
}
