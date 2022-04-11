import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.TextField;
import javafx.stage.Window;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;

public class AddRecord {
	List<NorthWindDisplay> list = new ArrayList<>();
	
	float totalPoints = 0;
	public  static void show() {
	Stage window = new Stage();
	
	//buttons, label, text field and local designs 
	
	Label PPSNLabel = new Label("PPSN : ");
	TextField PPSN = new TextField();
	PPSN.setPromptText("PPSN");
	PPSN.setStyle("-fx-base: white;");

	Label name = new Label("First Name : ");
	TextField Fname = new TextField();
	Fname.setPromptText("First Name");
	Fname.setStyle("-fx-base: white;");

	Label Surname = new Label("Surname : ");
	TextField Sname = new TextField();
	Sname.setPromptText("Surname");
	Sname.setStyle("-fx-base: white;");

	Label opSystem = new Label("Operating System : ");
	TextField opSystemResult = new TextField();
	opSystemResult.setPromptText("Result");
	opSystemResult.setStyle("-fx-base: white;");
	

	Label netWorking = new Label("Networking : ");
	TextField nwresult = new TextField();
	nwresult.setPromptText("Result");
	nwresult.setStyle("-fx-base: white;");

	Label hardware = new Label("Hardware : ");
	TextField hardwareResult = new TextField();
	hardwareResult.setPromptText("Result");
	hardwareResult.setStyle("-fx-base: white;");

	Label virtualisation = new Label("Vitualisation : ");
	TextField virtResult = new TextField();
	virtResult.setPromptText("Result");
	virtResult.setStyle("-fx-base: white;");
	
	Label programming = new Label("Programming : ");
	TextField programmingResult = new TextField();
	programmingResult.setPromptText("Result");
	programmingResult.setStyle("-fx-base: white;");
	
	Label maths = new Label("Maths for IT : ");
	TextField mathResults = new TextField();
	mathResults.setPromptText("Result");
	mathResults.setStyle("-fx-base: white;");

	Label dataBase = new Label("Databse : ");
	TextField dataBaseResult = new TextField();
	dataBaseResult.setPromptText("Result");
	dataBaseResult.setStyle("-fx-base: white;");

	Label communication = new Label("Communications : ");
	TextField commResult = new TextField();
	commResult.setPromptText("Result");
	commResult.setStyle("-fx-base: white;");
	
	Label workExp = new Label("Work Experience : ");
	TextField workExpResult = new TextField();
	workExpResult.setPromptText("Result");
	workExpResult.setStyle("-fx-base: white;");
	
	Button insert = new Button("Insert");
	
	Button exit = new Button ("EXIT");
	exit.setOnAction(e -> window.close());
	
	Button infoBtn = new Button ("Info");

	//make my grid to display my information
	
	GridPane grid = new GridPane();
	grid.setStyle("-fx-base: black;");
	grid.setAlignment(Pos.TOP_LEFT);
	grid.setPadding(new Insets(5, 5, 5, 5));
	grid.setVgap(7);
	grid.setHgap(7);
	grid.add(PPSNLabel, 0, 2);
	grid.add(PPSN, 1, 2);	
	grid.add(name, 0, 3);	
	grid.add(Fname, 1, 3);	
	grid.add(Surname, 0, 4);
	grid.add(Sname, 1, 4);	
	grid.add(opSystem, 0, 5);
	grid.add(opSystemResult, 1, 5);	
	grid.add(netWorking, 0, 6);
	grid.add(nwresult, 1, 6);
	grid.add(hardware, 0, 7);
	grid.add(hardwareResult, 1, 7);
	grid.add(virtualisation, 0, 8);
	grid.add(virtResult, 1, 8);
	grid.add(programming, 0, 9);
	grid.add(programmingResult, 1, 9);
	grid.add(maths, 0, 10);
	grid.add(mathResults, 1, 10);
	grid.add(dataBase, 0, 11);
	grid.add(dataBaseResult, 1, 11);
	grid.add(communication, 0, 12);
	grid.add(commResult, 1, 12);
	grid.add(workExp, 0, 13);
	grid.add(workExpResult, 1, 13);
	grid.add(insert, 0, 14);
	grid.add(infoBtn, 2, 14);
	grid.add(exit, 1, 14);
	insert.setStyle("-fx-border-color: red;");
	//CS
	grid.getStylesheets().add("Style.css");
	

	// Scene Size
	Scene scene = new Scene(grid, 500, 600);
	window.setTitle("Add record");
	window.setScene(scene);
	window.show();
	
	infoBtn.setOnAction(e -> {
	showAlert(Alert.AlertType.INFORMATION, grid.getScene().getWindow(), "!!",
	"This section allow you to add information");
	return;
	});
	
	//implement the functionality to my button
	insert.setOnAction(e -> {

		Connection databaseConnection = null;



		String connectionUrl = "jdbc:sqlserver://sql.coccork.ie:8080;databaseName=MGCao;user=moises.gianizelli@coccork.ie;password=32554111m";
		System.out.println(connectionUrl);
		try {
		databaseConnection = DriverManager.getConnection(connectionUrl);
		String insertName = PPSN.getText().replace("'", "`");
		String insertName2 = Fname.getText().replace("'", "`");
		String insertName3 = Sname.getText().replace("'", "`");
		String insertName4 = opSystemResult.getText().replace("'", "`");
		String insertName5 = nwresult.getText().replace("'", "`");
		String insertName6 = hardwareResult.getText().replace("'", "`");
		String insertName7 = virtResult.getText().replace("'", "`");
		String insertName8 = programmingResult.getText().replace("'", "`");
		String insertName9 = mathResults.getText().replace("'", "`");
		String insertName10 = dataBaseResult.getText().replace("'", "`");
		String insertName11 = commResult.getText().replace("'", "`");
		String insertName12 = workExpResult.getText().replace("'", "`");
		String insertString = "INSERT INTO dbo.MGModuleResults " + "VALUES('" + insertName + "', '" + insertName2
		+ "', '" + insertName3 + "', '" + insertName4 + "', '" + insertName5 + "', '" + insertName6
		+ "', '" + insertName7 + "', '" + insertName8 + "', '" + insertName9 + "', '" + insertName10
		+ "', '" + insertName11 + "', '" + insertName12 + "')";
		PreparedStatement ps = databaseConnection.prepareStatement(insertString);

		// implementation 
		if (PPSN.getText().isEmpty()) {
		showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), "Form Error!",
		"Please Enter the record you wish to add");
		return;
		}

		if (Fname.getText().isEmpty()) {
		showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), "Form Error!",
		"Please Enter the first name");
		return;}

		if (Sname.getText().isEmpty()) {
		showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), "Form Error!",
		"Please Enter the Surname");
		return;

		}

		if (opSystemResult.getText().isEmpty()) {
		showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), "Form Error!",
		"Please Enter the operating system result");
		return;

		}

		if (nwresult.getText().isEmpty()) {
		showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), "Form Error!",
		"Please Enter the networking result");
		return;

		}

		if (hardwareResult.getText().isEmpty()) {
		showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), "Form Error!",
		"Please Enter the hardware result");
		return;

		}

		if (virtResult.getText().isEmpty()) {
		showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), "Form Error!",
		"Please Enter the virtualisation result");
		return;

		}

		if (programmingResult.getText().isEmpty()) {
		showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), "Form Error!",
		"Please Enter the programming result");
		return;

		}

		if (mathResults.getText().isEmpty()) {
		showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), "Form Error!",
		"Please Enter the maths for IT result");
		return;

		}

		if (dataBaseResult.getText().isEmpty()) {
		showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), "Form Error!",
		"Please Enter the databse result");
		return;

		}

		if (commResult.getText().isEmpty()) {
		showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), "Form Error!",
		"Please Enter the communications result");
		return;

		}

		else {
			
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Add record");
			alert.setHeaderText("You're about to Add this record!");
			alert.setContentText("Are you sure you want to Add?");
			if (alert.showAndWait().get() == ButtonType.OK) {
				showAlert(Alert.AlertType.INFORMATION, grid.getScene().getWindow(), "!!",
						"You have added a record");

				System.out.println("Record Added!");

				ps.executeUpdate(); // executing the update
				

				}
				else  {
					
					showAlert(Alert.AlertType.INFORMATION, grid.getScene().getWindow(), "!!",
							"Record not added!");

				System.out.println("Record not Added!");

				}

		}

		} catch (Exception exc) {
		exc.printStackTrace();
		}
		});		
	}
	public void readDB(String query) {
		try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		System.out.println("JDBC driver loaded");
		} catch (Exception err) {
		System.err.println("Error loading JDBC driver");
		err.printStackTrace(System.err);
		System.exit(0);
		}
		Connection databaseConnection = null;
		try { 
		String connectionUrl = "jdbc:sqlserver://sql.coccork.ie:8080;databaseName=MGCao;user=moises.gianizelli@coccork.ie;password=32554111m"; databaseConnection = DriverManager.getConnection(connectionUrl);
		PreparedStatement preparedStatement = databaseConnection.prepareStatement(query);
		ResultSet rset = preparedStatement.executeQuery(); while (rset.next()) {
		NorthWindDisplay p = new NorthWindDisplay();
		p.setFname(rset.getString("Fname"));
		p.setSname(rset.getString("Sname"));
		p.setPpsn(rset.getString("PPSN"));
		p.setMod1(rset.getFloat("5N2928"));
		p.setMod2(rset.getFloat("5N2929"));
		p.setMod3(rset.getFloat("5N0548"));
		p.setMod4(rset.getFloat("5N2434"));
		p.setMod5(rset.getFloat("5N2927"));
		p.setMod6(rset.getFloat("5N18396"));
		p.setMod7(rset.getFloat("5N0783"));
		p.setMod8(rset.getFloat("5N0690"));
		p.setMod9(rset.getFloat("5N1356"));
		totalPoints = addTotal(rset.getFloat("5N1356"));
		p.setTotpts(totalPoints);
		
		list.add(p);
		}
		} catch (Exception e) {
		e.printStackTrace();
		}
		}


	private float addTotal(float grade) {
		if (grade >= 80) {
			totalPoints += 38.75;
		} else if (grade >= 65) {
			totalPoints += 32.5;
		} else if (grade >= 50) {
			totalPoints += 16.35;
		}
		
		return totalPoints;

	}
	private static void showAlert(AlertType error, Window window, String string, String string2) {
	Alert alert = new Alert(error);
	alert.setTitle(string);
	alert.setHeaderText(null);
	alert.setContentText(string2);
	alert.initOwner(window);
	alert.show();
	
	}	

}
