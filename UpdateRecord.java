import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.Window;

public class UpdateRecord { 
	public static void show() {
	Stage window = new Stage(); 
	// make my buttons, text field, label and styles
	Label ppsn = new Label("PPSN : ");
	TextField newMarks = new TextField();
	newMarks.setPromptText("Exam Number");
	newMarks.setStyle("-fx-base: white;");
	
	
	Label newOS = new Label("Operating System : ");
	TextField osNewResult = new TextField();
	osNewResult.setPromptText(" New Result");
	osNewResult.setStyle("-fx-base: white;"); 
	
	
	Label newNW = new Label("Networking : ");
	TextField networkingNew = new TextField();
	networkingNew.setPromptText("New Result");
	networkingNew.setStyle("-fx-base: white;"); 
	
	Label hardwareNew = new Label("Hardware : ");
	TextField hardwareNewResult = new TextField();
	hardwareNewResult.setPromptText("New Result");
	hardwareNewResult.setStyle("-fx-base: white;"); 
	
	Label virtualisationNew = new Label("Vitualisation : ");
	TextField virtualisationNewResult = new TextField();
	virtualisationNewResult.setPromptText("New Result");
	virtualisationNewResult.setStyle("-fx-base: white;"); 
	
	Label programmingNew = new Label("Programming : ");
	TextField programmingNewResult = new TextField();
	programmingNewResult.setPromptText("New Result");
	programmingNewResult.setStyle("-fx-base: white;");
	
	Label mathNew = new Label("Maths for IT : ");
	TextField mathNewResult = new TextField();
	mathNewResult.setPromptText("New Result");
	mathNewResult.setStyle("-fx-base: white;");
	
	Label databaseNew = new Label("Databse : ");	
	TextField databaseNewResult = new TextField();
	databaseNewResult.setPromptText("New Result");
	databaseNewResult.setStyle("-fx-base: white;"); 
	
	Label communicationNew = new Label("Communications : ");	
	TextField communicationNewResult = new TextField();
	communicationNewResult.setPromptText("New Result");
	communicationNewResult.setStyle("-fx-base: white;");

	Label weNew = new Label("Work Experience : ");	
	TextField weNewResult = new TextField();
	weNewResult.setPromptText("New Result");
	weNewResult.setStyle("-fx-base: white;");
	
	Button updateRecord = new Button("Update");


	Button exit = new Button("Exit");
	exit.setOnAction(e -> window.close()); 
		
	Button infoBtn = new Button ("Info");
	// make my grid
	GridPane grid = new GridPane();
	grid.setStyle("-fx-base: black;");
	grid.setAlignment(Pos.TOP_LEFT);
	grid.setPadding(new Insets(5, 5, 5, 5));
	grid.setVgap(7);
	grid.setHgap(7);
	grid.add(ppsn, 2, 8);
	grid.add(newMarks, 3, 8);
	grid.add(newOS, 2, 9);
	grid.add(osNewResult, 3, 9);
	grid.add(networkingNew, 3, 10);
	grid.add(newNW, 2, 10);
	grid.add(hardwareNewResult, 3, 11);
	grid.add(hardwareNew, 2, 11);
	grid.add(virtualisationNewResult, 3, 12);
	grid.add(virtualisationNew, 2, 12);
	grid.add(programmingNewResult, 3, 13);
	grid.add(programmingNew, 2, 13);
	grid.add(mathNewResult, 3, 14);
	grid.add(mathNew, 2, 14);
	grid.add(databaseNewResult, 3, 15);
	grid.add(databaseNew, 2, 15);
	grid.add(communicationNewResult, 3, 16);
	grid.add(communicationNew, 2, 16);
	grid.add(weNewResult, 3, 17);
	grid.add(weNew, 2, 17);
	grid.add(updateRecord, 2, 18);
	grid.add(infoBtn, 2, 19);
	grid.add(exit, 3, 18);
	updateRecord.setStyle(" -fx-border-color: yellow;");
	grid.getStylesheets().add("Style.css");
		
		Scene scene = new Scene(grid, 500, 650);
		window.setTitle("Update record");
		window.setScene(scene);
		window.show();
		
		infoBtn.setOnAction(e -> {
			showAlert(Alert.AlertType.INFORMATION, grid.getScene().getWindow(), "!!",
			"If you want to upgrade one mark only you MUST to reenter all mark over again and update the one that you want to change.");
			return;
			});
		
		updateRecord.setOnAction(e -> {
		Connection databaseConnection = null;
		String connectionUrl = "jdbc:sqlserver://sql.coccork.ie:8080;databaseName=MGCao;user=moises.gianizelli@coccork.ie;password=32554111m";
		System.out.println(connectionUrl);
		try {
		databaseConnection = DriverManager.getConnection(connectionUrl);
		String mark = newMarks.getText().replace("'", "`");
		String mark1 = osNewResult.getText().replace("'", "`");
		String mark2 = networkingNew.getText().replace("'", "`");
		String mark3 = hardwareNewResult.getText().replace("'", "`");
		String mark4 = virtualisationNewResult.getText().replace("'", "`");
		String mark5 = programmingNewResult.getText().replace("'", "`");
		String mark6 = mathNewResult.getText().replace("'", "`");
		String mark7 = databaseNewResult.getText().replace("'", "`");
		String mark8 = communicationNewResult.getText().replace("'", "`");
		String mark9 = weNewResult.getText().replace("'", "`");
		String updateM = "UPDATE dbo.MGModuleResults set [5N2928] = '" + mark1 + "', [5N2929] = '" + mark2
		+ "', [5N0548] = '" + mark3 + "', [5N2434] = '" + mark4 + "', [5N2927] = '" + mark5
		+ "', [5N18396] = '" + mark6 + "', [5N0783] = '" + mark7 + "', [5N0690] = '" + mark8
		+ "', [5N1356] = '" + mark9 + "' where PPSN = '" + mark + "'"; PreparedStatement ps = databaseConnection.prepareStatement(updateM); if (newMarks.getText().isEmpty()) {
		showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), "Form Error!",
		"Please enter the sudents exam number");
		return;
		} 
			if (osNewResult.getText().isEmpty()) {
			showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), "Form Error!",
			"Please enter the new mark for operating systems!");
			return;
			} 
			
			if (networkingNew.getText().isEmpty()) {
			showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), "Form Error!",
			"Please enter the new mark for Networking!");
			return;
			}
			
			if (hardwareNewResult.getText().isEmpty()) {
			showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), "Form Error!",
			"Please enter the new mark for Hardware!");
			return;
			} 
			if (virtualisationNewResult.getText().isEmpty()) {
			showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), "Form Error!",
			"Please enter the new mark for Virtualisation!");
			return;
			} 
			
			if (programmingNewResult.getText().isEmpty()) {
			showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), "Form Error!",
			"Please enter the new mark for Programming!");
			return;
			}
			
			if (mathNewResult.getText().isEmpty()) {
			showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), "Form Error!",
			"Please enter the new mark for Maths for IT!");
			return;
			} 
			
			if (databaseNewResult.getText().isEmpty()) {
			showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), "Form Error!",
			"Please enter the new mark for Database!");
			return;
			} 
			
			if (communicationNewResult.getText().isEmpty()) {
			showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), "Form Error!",
			"Please enter the new mark for Communications!");
			return;
			} 
			
			if (weNewResult.getText().isEmpty()) {
			showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), "Form Error!",
			"Please enter the new mark for Work Experience!");
			return;
			}
			
			else {
			
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Update record");
				alert.setHeaderText("You're about to Update this record!");
				alert.setContentText("Are you sure you want to Update?");
				if (alert.showAndWait().get() == ButtonType.OK) {
					showAlert(Alert.AlertType.INFORMATION, grid.getScene().getWindow(), "!!",
							"You have Update a record");

					System.out.println("Record Updated!");

					ps.executeUpdate(); // executing the update
					

					}
					else  {
						
						showAlert(Alert.AlertType.INFORMATION, grid.getScene().getWindow(), "!!",
								"Record not Update!");

					System.out.println("Record not Update!");

					}

		} } 
		
		catch (Exception exc) {
		exc.printStackTrace();
		}
		});
		} private static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
		Alert alert = new Alert(alertType);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.initOwner(owner);
		alert.show();

		}}
		
