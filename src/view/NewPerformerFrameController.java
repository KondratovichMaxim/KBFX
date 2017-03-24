package view;

import entity.Performer;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class NewPerformerFrameController {

	@FXML
	TextField name;

	@FXML
	TextField password;
	
	@FXML
	TextField k;

	@FXML
	Button create;

	Stage st;

	private Performer person;

	@FXML
	private void handleCreateButtonClick() {
		if (!valid()) {
			return;
		}
		person = new Performer(name.getText(), password.getText());
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
		if (k.getText().isEmpty()) {
			thowErrorDialog("K can not be empty");
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
