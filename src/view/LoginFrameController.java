package view;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import application.Main;
import dao.DaoClient;
import dao.DaoPerformer;
import db.DB;
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
	
	DB db;

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
			
			showNewUser(loader, st);
			
			if(person != null){
				
				this.st.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
			person = null;
		}
	}
	
	private void showNewUser(FXMLLoader loader,Stage st){
		if(role =="client"){
			NewClientFrameController controller = loader.getController(); 
			loader.setController(controller);
			controller.setStage(st);
			st.showAndWait();
			person = controller.person();
			if(person != null){
				DaoClient dc = new DaoClient(db);
				dc.insert((Client)person);
			}
		}
		else{
			NewPerformerFrameController controller = loader.getController(); 
			loader.setController(controller);
			controller.setStage(st);
			st.showAndWait();
			person = controller.person();
			if(person != null){
				DaoPerformer dc = new DaoPerformer(db);
				dc.insert((Performer)person);
			}
		}
		if(person != null){
			
			this.st.close();
		}
	}

	@FXML
	private void handleConnectButtonClick() {
		if (!valid()) {
			return;
		}
		if (role == "client") {
			try {
				if(!db.query("SELECT * FROM "+role+" WHERE name='"+name.getText()+"' AND password='"+password.getText()+"'").isBeforeFirst()){
					thowErrorDialog("Name or password wrong");
					return;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ResultSet rs = db.query("SELECT * FROM client WHERE name='"+((Client)person).getName()+"' AND password='"+((Client)person).getPassword()+"'");
			Client t = new Client();
			try {
				if(rs.next()){
					t.setId_client(rs.getInt(1));
					t.setName(rs.getString(2));
					t.setPassword(rs.getString(3));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			person = t;
		} else {// if role == performer
			try {
				if(!db.query("SELECT * FROM "+role+" WHERE name='"+name.getText()+"' AND password='"+password.getText()+"'").isBeforeFirst()){
					thowErrorDialog("Name or password wrong");
					return;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ResultSet rs = db.query("SELECT * FROM performer WHERE name='"+((Performer)person).getName()+"' AND password='"+((Performer)person).getPassword()+"'");
			Performer t = new Performer();
			try {
				if(rs.next()){
					t.setId_performer(rs.getInt(1));
					t.setName(rs.getString(2));
					t.setPassword(rs.getString(3));
					t.setK(rs.getFloat(4));
					thowErrorDialog(t.getId_performer()+" "+t.getName()+" "+t.getPassword()+" "+t.getK());
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			person = t;
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

	public void setDB(DB db) {
		this.db = db;
		
	}
}
