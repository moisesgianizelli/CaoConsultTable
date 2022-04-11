import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;

// Set up my info page 

public class infoPage {
	public static Stage window;
	public static Scene scene1;

	public  static void show() {
		Stage window = new Stage();
		
		// making my button 
		Button info = new Button("Table info");
		
		Button infoSrc = new Button ("Courses info");
		
		Button exitBtn = new Button ("EXIT");
		exitBtn.setOnAction(e -> window.close());
		
		// create my grid
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.TOP_CENTER);
		grid.setPadding(new Insets(5, 5, 5, 5));
		grid.setVgap(7);
		grid.setHgap(7);
		grid.add(info, 0, 3);
		grid.add(infoSrc, 0, 4);
		grid.add(exitBtn, 0, 5);
		
		//CS
		grid.getStylesheets().add("Style.css");

		// Scene Size
		Scene scene = new Scene(grid, 400, 300);
		window.setTitle("INFO");
		window.setScene(scene);
		window.show();
		
	
	info.setOnAction(e -> {
		showAlert(Alert.AlertType.INFORMATION, grid.getScene().getWindow(), "About Table",
		"If you are not seeing yours update, please close up the table and open up again\n"
				+ "you can add, delete, update records\n"+
				"hover the mouse over the buttons to check help");
		return;
		});

	infoSrc.setOnAction(e -> {
		showAlert(Alert.AlertType.INFORMATION, grid.getScene().getWindow(), "About Courses",
		"Every year CAO change requirments if you need more information\n" + "www.cao.ie");
		return;
		});

		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Delete");
		alert.setHeaderText("You're about to Delete this record!");
		alert.setContentText("Are you sure you want to Delete?");


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