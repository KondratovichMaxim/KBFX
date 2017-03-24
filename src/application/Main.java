package application;

import java.io.IOException;

import entity.Client;
import entity.Performer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import view.ChooserFrameController;
import view.ClientViewController;
import view.ConnectionFrameController;
import view.LoginFrameController;
import view.PerformerViewController;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {

			if (showConnectionFrame()) {
				System.out.println("succesfully connected");
				
				switch (showChooserFrame()) {
				case 1:
					
					showClientViewFrame((Client)showLoginFrame("client"));
					break;
				case 2:

					showPerformerViewFrame((Performer)showLoginFrame("performer"));
					break;

				default:
					System.out.println("Wrong value or null");
					break;
				}
			} else {
				System.out.println("fail during connecting");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void showClientViewFrame(Client client) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/view/ClientViewFrame.fxml"));

			Stage st = new Stage();
			st.setTitle("Client view frame");

			Scene scene = new Scene((BorderPane) loader.load());
			st.setScene(scene);
			st.setResizable(false);
			st.sizeToScene();

			ClientViewController controller = loader.getController();
			loader.setController(controller);
			
//			controller.setStage(st); TODO

			st.showAndWait();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void showPerformerViewFrame(Performer performer) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/view/PerformerViewFrame.fxml"));

			Stage st = new Stage();
			st.setTitle("Performer view frame");

			Scene scene = new Scene((BorderPane) loader.load());
			st.setScene(scene);
			st.setResizable(false);
			st.sizeToScene();

			PerformerViewController controller = loader.getController();
			loader.setController(controller);
			
//			controller.setStage(st); TODO

			st.showAndWait();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private Object showLoginFrame(String role) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/view/LoginFrame.fxml"));

			Stage st = new Stage();
			st.setTitle("Login frame");

			Scene scene = new Scene((BorderPane) loader.load());
			st.setScene(scene);
			st.setResizable(false);
			st.sizeToScene();

			LoginFrameController controller = loader.getController();
			loader.setController(controller);
			
			controller.setStage(st);
			controller.setRole(role);

			st.showAndWait();
			
			return controller.person();

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	private int showChooserFrame() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/view/ChooserFrame.fxml"));

			Stage st = new Stage();
			st.setTitle("Chooser frame");

			Scene scene = new Scene((BorderPane) loader.load());
			st.setScene(scene);
			st.setResizable(false);
			st.sizeToScene();

			ChooserFrameController controller = loader.getController();
			loader.setController(controller);

			controller.setStage(st);

			st.showAndWait();

			return controller.result();
		} catch (IOException e) {
			e.printStackTrace();
			return 0;
		}
	}

	private boolean showConnectionFrame() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/view/ConnectionFrame.fxml"));

			Stage st = new Stage();
			st.setTitle("Connection frame");

			Scene scene = new Scene((BorderPane) loader.load());
			st.setScene(scene);
			st.setResizable(false);
			st.sizeToScene();

			ConnectionFrameController controller = loader.getController();
			loader.setController(controller);

			controller.setStage(st);

			st.showAndWait();

			return controller.result();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
