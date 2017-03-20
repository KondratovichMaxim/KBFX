package view;

import javafx.fxml.FXML;
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
	
	public ConnectionFrameController() {
		state = false;
	}
	
	@FXML
    private void initialize() {
	}
	
	@FXML
	private void handleCreateClick(){
		
		
	}
	@FXML
	private void handleDeleteClick(){
		
	}
	@FXML
	private void handleConnectClick(){
		state = true;
		st.close();
	}

	public boolean result() {

		return state;
	}

	public void setStage(Stage primaryStage) {

		st = primaryStage;
	}

}
