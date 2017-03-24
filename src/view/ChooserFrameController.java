package view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ChooserFrameController {

	@FXML
	Button client;
	
	@FXML
	Button pefrormer;
	
	Stage st;
	
	int role;
	
	@FXML
	private void handleClientButton(){
		role = 1;
		st.close();
	}
	
	@FXML
	private void handlePerformerButton(){
		role = 2;
		st.close();
	}
	
	public void setStage(Stage st){
		this.st = st;
	}
	
	public int result(){
		return role;
	}
}
