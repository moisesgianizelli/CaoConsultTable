import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;


public class DeleteRecord {
	public  static void show() {
	Stage window = new Stage();
		// making my buttons and textfields
	Button delete = new Button("Delete");
	TextField deleteP = new TextField();
	deleteP.setPromptText("Delete record");
	delete.setStyle("-fx-border-color: red;");
	
	Button exitBtn = new Button ("EXIT");
	exitBtn.setOnAction(e -> window.close());
	
	Button infoSrc = new Button ("Info");
	// set up my grid
	GridPane grid = new GridPane();
	grid.setAlignment(Pos.TOP_CENTER);
	grid.setPadding(new Insets(5, 5, 5, 5));
	grid.setVgap(7);
	grid.setHgap(7);
	grid.add(delete, 1, 3);
	grid.add(deleteP, 0, 3);
	grid.add(exitBtn, 0, 4);
	grid.add(infoSrc, 0, 5);


	//CS
	grid.getStylesheets().add("Style.css");

	// Scene Size
	Scene scene = new Scene(grid, 400, 300);
	window.setTitle("Delete record");
	window.setScene(scene);
	window.show();

	// giving command to my button
	infoSrc.setOnAction(e -> {
	showAlert(Alert.AlertType.WARNING, grid.getScene().getWindow(), "!!",
	"To delete record please put PPSN");
	return;
	});


	delete.setOnAction(e -> {
	// if (!deleteP.getText().trim().isEmpty()) {

		if (deleteP.getText().isEmpty()) {
		showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), "Error",
		"Please Enter the record you wish to delete");
		return;
		}
		
		if (!deleteP.getText().matches("\\d{7}[A-Z]{1,2}")) {
			showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), "Error!",
			"Please enter a PPS you want to delete ");
			return;
			
		}

	Connection databaseConnection = null;
	try {
	String connectionUrl = "jdbc:sqlserver://sql.coccork.ie:8080;databaseName=MGCao;user=moises.gianizelli@coccork.ie;password=32554111m";
	System.out.println(connectionUrl);



	databaseConnection = DriverManager.getConnection(connectionUrl);
	String queryName = deleteP.getText().replace("'", "`");
	String deleteString = "DELETE from dbo.MGModuleResults where PPSN = '" + queryName + "'";
	System.out.println(queryName);
	PreparedStatement ps = databaseConnection.prepareStatement(deleteString);
	
	// declaring my alert 
	
	Alert alert = new Alert(AlertType.CONFIRMATION);
	alert.setTitle("Delete");
	alert.setHeaderText("You're about to Delete this record!");
	alert.setContentText("Are you sure you want to Delete?");

	// yes or no implementation 

	if (alert.showAndWait().get() == ButtonType.OK) {
		
		showAlert(Alert.AlertType.INFORMATION, grid.getScene().getWindow(), "!!",
				"You have deleted a record");

	System.out.println("Record Deleted!");

	ps.executeUpdate(); // executing the update
	}
	else  {

	System.out.println("Record not Deleted!");
	}

	} catch (Exception exc) {
	exc.printStackTrace();
	}



	});
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