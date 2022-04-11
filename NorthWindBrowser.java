/* Author: Moises Gianizelli
 * LAST UPDATE: 10/04/2022
 * 
 * This application makes a connection with the database to manipulate 
 * the table referring to the candidates and their results in their respective subjects.
 * 
 * 
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import javafx.application.Application;
import javafx.collections.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.scene.layout.GridPane;


// Update alert box, info button main screen, info button content, change variables names, search for courses.

public class NorthWindBrowser extends Application {
	List<NorthWindDisplay> list = new ArrayList<>();
	
	// List of contact table properties
	float totalPoints = 0;

	private final GridPane gridPane = new GridPane();
	private final Label lblName = new Label("Search by Name");
	private ObservableList<NorthWindDisplay> observableNames;
	TableView<NorthWindDisplay> contactTableView = new TableView<>();
	
// starting 
	public NorthWindBrowser() {

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

			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String connectionUrl = "jdbc:sqlserver://sql.coccork.ie:8080;databaseName=MGCao;user=moises.gianizelli@coccork.ie;password=32554111m";
			System.out.println(connectionUrl);

			databaseConnection = DriverManager.getConnection(connectionUrl);
			System.out.println("Connected to the database");

			System.out.println("Database Connected");

			String queryString = "select * from MGModuleResults";
			System.out.println(queryString);
			PreparedStatement preparedStatement = databaseConnection.prepareStatement(queryString);
			ResultSet rset = preparedStatement.executeQuery();

			while (rset.next()) {
				String name = rset.getString("PPSN");

				String cname = rset.getString("Fname");

				System.out.println(name + " " + cname);
				NorthWindDisplay p = new NorthWindDisplay();
				p.setPpsn(rset.getString("PPSN"));
				p.setFname(rset.getString("Fname"));
				p.setSname(rset.getString("Sname"));
				p.setMod1(rset.getFloat("5N2928"));
				totalPoints = addTotal(rset.getFloat("5N2928"));
				p.setMod2(rset.getFloat("5N2929"));
				totalPoints = addTotal(rset.getFloat("5N2929"));
				p.setMod3(rset.getFloat("5N0548"));
				totalPoints = addTotal(rset.getFloat("5N0548"));
				p.setMod4(rset.getFloat("5N2434"));
				totalPoints = addTotal(rset.getFloat("5N2434"));
				p.setMod5(rset.getFloat("5N2927"));
				totalPoints = addTotal(rset.getFloat("5N2927"));
				p.setMod6(rset.getFloat("5N18396"));
				totalPoints = addTotal(rset.getFloat("5N18396"));
				p.setMod7(rset.getFloat("5N0783"));
				totalPoints = addTotal(rset.getFloat("5N0783"));
				p.setMod8(rset.getFloat("5N0690"));
				totalPoints = addTotal(rset.getFloat("5N0690"));
				p.setMod9(rset.getFloat("5N1356"));
				totalPoints = addTotal(rset.getFloat("5N1356"));
				p.setTotpts(totalPoints);

				list.add(p);
				totalPoints = 0;
				System.out.println("found one ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		lblName.setTextFill(Color.web("#0076a3"));
		observableNames = FXCollections.observableArrayList(list);
	}

	@Override
	public void start(Stage primaryStage) {
		observableNames = FXCollections.observableArrayList(list);
		TableView<NorthWindDisplay> contactsTable = new TableView<>();

		TableColumn<NorthWindDisplay, String> ppsn = new TableColumn<>("Personal No");
		contactsTable.getColumns().add(ppsn);
		ppsn.setCellValueFactory(new PropertyValueFactory<>("ppsn"));
		ppsn.setCellFactory(TextFieldTableCell.forTableColumn());

		TableColumn<NorthWindDisplay, String> fname = new TableColumn<>("First Name");
		contactsTable.getColumns().add(fname);
		fname.setCellValueFactory(new PropertyValueFactory<>("fname"));
		fname.setCellFactory(TextFieldTableCell.forTableColumn());

		TableColumn<NorthWindDisplay, String> sname = new TableColumn<>("Last Name");
		contactsTable.getColumns().add(sname);
		sname.setCellValueFactory(new PropertyValueFactory<>("sname"));
		sname.setCellFactory(TextFieldTableCell.forTableColumn());

		TableColumn<NorthWindDisplay, Float> mod1 = new TableColumn<>("Oper Sys");
		contactsTable.getColumns().add(mod1);
		mod1.setCellValueFactory(new PropertyValueFactory<>("mod1"));

		TableColumn<NorthWindDisplay, Float> mod2 = new TableColumn<>("Networking");
		contactsTable.getColumns().add(mod2);
		mod2.setCellValueFactory(new PropertyValueFactory<>("mod2"));

		TableColumn<NorthWindDisplay, Float> mod3 = new TableColumn<>("Hardware");
		contactsTable.getColumns().add(mod3);
		mod3.setCellValueFactory(new PropertyValueFactory<>("mod3"));

		TableColumn<NorthWindDisplay, Float> mod4 = new TableColumn<>("Virtualisation");
		contactsTable.getColumns().add(mod4);
		mod4.setCellValueFactory(new PropertyValueFactory<>("mod4"));

		TableColumn<NorthWindDisplay, Float> mod5 = new TableColumn<>("Programming");
		contactsTable.getColumns().add(mod5);
		mod5.setCellValueFactory(new PropertyValueFactory<>("mod5"));

		TableColumn<NorthWindDisplay, Float> mod6 = new TableColumn<>("Maths for IT");
		contactsTable.getColumns().add(mod6);
		mod6.setCellValueFactory(new PropertyValueFactory<>("mod6"));

		TableColumn<NorthWindDisplay, Float> mod7 = new TableColumn<>("Database");
		contactsTable.getColumns().add(mod7);
		mod7.setCellValueFactory(new PropertyValueFactory<>("mod7"));

		TableColumn<NorthWindDisplay, Float> mod8 = new TableColumn<>("Communications");
		contactsTable.getColumns().add(mod8);
		mod8.setCellValueFactory(new PropertyValueFactory<>("mod8"));

		TableColumn<NorthWindDisplay, Float> mod9 = new TableColumn<>("Work Experience");
		contactsTable.getColumns().add(mod9);
		mod9.setCellValueFactory(new PropertyValueFactory<>("mod9"));

		TableColumn<NorthWindDisplay, Float> totpts = new TableColumn<>("Total Points");
		contactsTable.getColumns().add(totpts);
		totpts.setCellValueFactory(new PropertyValueFactory<>("totpts"));
		
		Button findName = new Button("Search");
		Tooltip tooltipName = new Tooltip();
		tooltipName.setText(
		    "Insert name\n"   
		);
		
		//Buttons, text boxes and implementation
		
		findName.setTooltip(tooltipName);
		TextField enterName = new TextField();
		
		enterName.setPromptText("Name ");
		findName.setOnAction(e-> {
			if (!enterName.getText().trim().isEmpty()) {
			String queryName = enterName.getText().replace("'", "`");
			String searchString = "select * from dbo.MGModuleResults where Fname = '" + queryName + "'" ;
			readDB(searchString);
			observableNames = FXCollections.observableArrayList(list);
			contactsTable.setItems(observableNames);
			}
			else {
			readDB("select * from dbo.MGModuleResults");
			observableNames = FXCollections.observableArrayList(list);
			contactsTable.setItems(observableNames);
			}
		});
		
		Button findSurname = new Button("Search");
		Tooltip tooltipsurname = new Tooltip();
		tooltipsurname.setText(
		    "Insert surname \n");
		findSurname.setTooltip(tooltipsurname);
		
		
		TextField enterSurname = new TextField();
		enterSurname.setPromptText("Surname");
		findSurname.setOnAction(e-> {
		if (!enterSurname.getText().trim().isEmpty()) {
		String queryName = enterSurname.getText().replace("'", "`");
		String searchString = "select * from dbo.MGModuleResults where Sname = '" + queryName + "'";
		readDB(searchString);
		observableNames = FXCollections.observableArrayList(list);
		contactsTable.setItems(observableNames);
		}
		else {
		readDB("select * from dbo.MGModuleResults");
		observableNames = FXCollections.observableArrayList(list);
		contactsTable.setItems(observableNames);
		}
		});
		
		Button findPPSN = new Button("Search");
		Tooltip tooltipPPS = new Tooltip();
		tooltipPPS.setText(
		    "Insert the PPS number\n" 
		);
		
		
		findPPSN.setTooltip(tooltipPPS);
		TextField enterPPSN = new TextField();
		enterPPSN.setPromptText("PPS"); findPPSN.setOnAction(e-> {
			if (!enterPPSN.getText().trim().isEmpty()) {
			String queryName = enterPPSN.getText().replace("'", "`");
			String searchString = "select * from dbo.MGModuleResults where PPSN = '" + queryName + "'";
			readDB(searchString);
			observableNames = FXCollections.observableArrayList(list);
			contactsTable.setItems(observableNames);
	
			}
			else {
			readDB("select * from dbo.MGModuleResults");
			observableNames = FXCollections.observableArrayList(list);
			contactsTable.setItems(observableNames);
			}
			});
		
		Button findCourse = new Button("Search");
		Tooltip tooltipFCourse = new Tooltip();
		tooltipFCourse.setText(
		    "Insert the PPS number to check eligibility\n" 
		);
		findCourse.setTooltip(tooltipFCourse);
	
		TextField enterFindCourse = new TextField();
		
		
			enterFindCourse.setPromptText("Eligibility"); 
			findCourse.setOnAction(e-> {
				if  (!enterFindCourse.getText().trim().isEmpty()) {
					String queryName = enterFindCourse.getText().replace("'", "`");
					String searchString = "select * from dbo.MGModuleResults where PPSN = '" + queryName + "'";
					readDB(searchString);
					observableNames = FXCollections.observableArrayList(list);
					contactsTable.setItems(observableNames);

					if (totalPoints >= 38.75) {
						
						findCourse.setOnAction(s -> {
							showAlert(Alert.AlertType.INFORMATION, gridPane.getScene().getWindow(), "CAO", "courses");
							return;
							});
						System.out.print("ELIGIBLE FOR: COMPUTER SCIENCE, SOFTWARE DEVELOPMENT, IT, BUSINESS");
						
					} else if (totalPoints <= 38.75) {
						
						System.out.print("ELIGIBLE FOR: MATHS, ARTS, IT SUPPORT TECH, Bachelor of Commerce, Bachelor of Data Science ");
					} else if (totalPoints == 0) {
						System.out.print("ELIGIBLE FOR: Accounting, Biology, Chinese Studies, Film");
					}
					}
					else {
					readDB("select * from dbo.MGModuleResults");
					observableNames = FXCollections.observableArrayList(list);
					contactsTable.setItems(observableNames);
					}
				});
			
		
		Button infoBtn = new Button ("Info");
		infoBtn.setOnAction(e -> infoPage.show());

		
		
		Button partialSearch = new Button("Search");
		Tooltip tooltipPartial = new Tooltip();
		tooltipPartial.setText(
		    "Insert partial data you want to search"  
		);
		partialSearch.setTooltip(tooltipPartial);
		
		TextField enterPn = new TextField();
		enterPn.setPromptText("Partial Search");
		
		partialSearch.setOnAction(e->{
			if (!enterPn.getText().isEmpty()) {
				
				String partialsearch = enterPn.getText().replace("'","`");
				String ps = "Select * from MGModuleResults where Fname LIKE '" + partialsearch  + '%' + "'or Sname LIKE'" + partialsearch + "%'";
				readDB (ps) ;
				observableNames = FXCollections.observableArrayList(list);
				contactsTable.setItems(observableNames);

			}
			else {
				readDB("select * from dbo.MGModuleResults");
				observableNames = FXCollections.observableArrayList(list);
				contactsTable.setItems(observableNames);
				}
		});
		
		Button delete = new Button("DELETE");
		Tooltip tooltipDelete = new Tooltip();
		tooltipDelete.setText(
		    "Press this button if you\n" +
		    "want to delete a record\n"  
		);
		delete.setTooltip(tooltipDelete);
		
		delete.setOnAction(e -> DeleteRecord.show());
		delete.setStyle(" -fx-border-color: red;");

		Button add = new Button("ADD");
		Tooltip tooltipAdd = new Tooltip();
		tooltipAdd.setText(
		"Press this button if you\n" +
		"want to add a record\n"  
		);
		add.setTooltip(tooltipAdd);
		
		// set action
		add.setOnAction(e -> AddRecord.show());
		add.setStyle(" -fx-border-color: green;");
		
		Button upDate = new Button("UPDATE");
		Tooltip tooltipUpDate = new Tooltip();
		tooltipUpDate.setText(
		"Press this button if you\n" +
		"want to upload a record\n" 
		);
		upDate.setTooltip(tooltipUpDate);
		
		upDate.setOnAction(e -> UpdateRecord.show());
		upDate.setStyle(" -fx-border-color: yellow;");
		
		Button exit = new Button("EXIT");
		exit.setOnAction(e -> primaryStage.close());

		//fix the info btn
		
		contactsTable.setItems(observableNames);
		contactsTable.setEditable(true);
		primaryStage.setTitle("Student Names");
		BorderPane borderPane = new BorderPane();
		Scene scene = new Scene(borderPane, 1000, 750, true);
		scene.getStylesheets().add("Style.css");
		
		// Setting up my Grid

		GridPane gridPane = new GridPane();
		gridPane.setPadding(new Insets(10));
		gridPane.setHgap(5);
		gridPane.setVgap(5);
		gridPane.add(enterName, 0, 1);
		gridPane.add(findName, 1, 1);
		gridPane.add(enterPPSN, 0, 3);
		gridPane.add(findPPSN, 1, 3);
		gridPane.add(findCourse, 1, 5);
		gridPane.add(enterFindCourse, 0, 5);
		gridPane.add(partialSearch, 1, 4);
		gridPane.add(enterPn, 0, 4);
		gridPane.add(enterSurname, 0, 2);
		gridPane.add(findSurname, 1, 2);
		gridPane.add(add, 2, 8);
		gridPane.add(delete, 3, 8);
		gridPane.add(upDate, 2, 9);
		gridPane.add(exit, 3, 9);
		gridPane.add(infoBtn, 0, 6);
		gridPane.add(contactsTable, 3, 2); borderPane.setTop(contactsTable);
		borderPane.setLeft(gridPane);
		primaryStage.setScene(scene);
		primaryStage.show();
		}
	
		//Making my connections
			
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
		try { list.clear(); String connectionUrl = "jdbc:sqlserver://sql.coccork.ie:8080;databaseName=MGCao;user=moises.gianizelli@coccork.ie;password=32554111m"; databaseConnection = DriverManager.getConnection(connectionUrl);
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
		p.setTotpts(totalPoints); list.add(p);
		}
		} catch (Exception e) {
		e.printStackTrace();
		}
		}


	public static void main(String[] args) {
		launch(args);
	}
	
	//CAO points

	public float addTotal(float grade) {
		if (grade >= 80) {
			totalPoints += 38.75;
		} else if (grade >= 65) {
			totalPoints += 32.5;
		} else if (grade >= 50) {
			totalPoints += 16.35;
		}
		
		return totalPoints;

	}
	
	
	private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
		Alert alert = new Alert(alertType);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.initOwner(owner);
		alert.show();
		}
		
	
		


	
}

