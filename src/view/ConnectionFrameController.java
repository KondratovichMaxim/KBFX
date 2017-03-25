package view;


import db.DB;
import db.WorkDB;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ConnectionFrameController {

	Stage st;
	
	@FXML
	TextField url;
	
	@FXML
	TextField name;
	
	@FXML
	TextField login;
	
	@FXML
	TextField password;
	
	@FXML
	Button create;
	
	@FXML
	Button delete;
	
	@FXML
	Button connect;
	
	boolean state;
	
	DB db;
	
	public ConnectionFrameController() {
		state = false;
	}
	
	@FXML
    private void initialize() {
	}
	
	@FXML
	private void handleCreateClick(){
		
		if(!valid()){
			return;
		}
		
		try {
			WorkDB.create(url.getText(), name.getText(), login.getText(), password.getText());
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	@FXML
	private void handleDeleteClick(){
		
		if(!valid()){
			return;
		}
		
		try {
			WorkDB.deleteDB(url.getText(), name.getText(), login.getText(), password.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@FXML
	private void handleConnectClick(){
		
		if(!valid()){
			return;
		}
		
		try {
			db = new DB(url.getText(), name.getText(), login.getText(), password.getText());
		} catch (Exception e) {
			thowErrorDialog("Did not found database");
			e.printStackTrace();
		}
		
		state = true;
		st.close();
	}

	private boolean valid() {
		if(url.getText().isEmpty()){
			thowErrorDialog("URL can not be empty");
			return false;
		}
		else{
			if(!url.getText().endsWith("/")){
				thowErrorDialog("Incorrect URL");
				return false;
			}
				
		}
		if(name.getText().isEmpty()){
			thowErrorDialog("Name can not be empty");
			return false;
		}
		if(login.getText().isEmpty()){
			thowErrorDialog("Login can not be empty");
			return false;
		}
		if(password.getText().isEmpty()){
			thowErrorDialog("Password can not be empty");
			return false;
		}
		return true;
		
	}
	
	private void thowErrorDialog(String explanation){
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error");
		alert.setHeaderText("");
		alert.setContentText(explanation);

		alert.showAndWait();
	}

	public boolean result() {

		return state;
	}

	public void setStage(Stage primaryStage) {

		st = primaryStage;
	}

	public DB getDB() {
		return db;
	}

}
