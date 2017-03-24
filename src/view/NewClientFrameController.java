package view;

import entity.Client;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class NewClientFrameController {

	@FXML
	TextField name;

	@FXML
	TextField password;

	@FXML
	Button create;

	Stage st;

	private Client person;

	@FXML
	private void handleCreateButtonClick() {
		if (!valid()) {
			return;
		}
		person = new Client(name.getText(), password.getText());
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
