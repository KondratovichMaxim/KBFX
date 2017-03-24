package view;

import java.io.IOException;

import application.Main;
import entity.Client;
import entity.Performer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;

public class LoginFrameController {

	@FXML
	Label title;

	@FXML
	TextField name;

	@FXML
	TextField password;

	@FXML
	Button newUser;

	@FXML
	Button connect;

	String role;

	Stage st;

	Object person;

	public void setRole(String role) {
		this.role = role;
		title.setText("Hello " + role);
		newUser.setText("New " + role);
	}
	
	@FXML
	private void handleNewUserButtonClick(){
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/view/New"+String.valueOf( role.charAt(0) ).toUpperCase()+role.substring(1, role.length())+"Frame.fxml"));

			Stage st = new Stage();
			st.setTitle("New "+role);

			Scene scene = new Scene((BorderPane) loader.load());
			st.setScene(scene);
			st.setResizable(false);
			st.sizeToScene();
			
			Class t = Class.forName("New"+String.valueOf( role.charAt(0) ).toUpperCase()+role.substring(1, role.length())+"FrameController");
			t controller = loader.getController(); //TODO Починить это говно
			loader.setController(controller);
			
			controller.setStage(st);

			st.showAndWait();
			
			person = controller.person();
			this.st.close();

		} catch (IOException e) {
			e.printStackTrace();
			person = null;
		}
	}

	@FXML
	private void handleConnectButtonClick() {
		if (!valid()) {
			return;
		}
		if (role == "client") {
			person = new Client(name.getText(), password.getText());
		} else {// if role == performer
			person = new Performer(name.getText(), password.getText());
		}
		st.close();
	}

	private boolean valid() {
		if (name.getText().isEmpty()) {
			thowErrorDialog("Name can not be empty");
			return false;
		}
		if (password.getText().isEmpty()) {
			thowErrorDialog("Password can not be empty");
			return false;
		}
		return true;
	}

	private void thowErrorDialog(String explanation) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error");
		alert.setHeaderText("");
		alert.setContentText(explanation);

		alert.showAndWait();
	}

	public void setStage(Stage st) {
		this.st = st;
	}

	public Object person() {
		return person;
	}
}
