package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import view.ConnectionFrameController;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class Main extends Application {


	@Override
	public void start(Stage primaryStage) {
		try {

			if(showConnectionFrame()){
				System.out.println("succesfully connected");
			}
			else{
				System.out.println("fail while connecting");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean showConnectionFrame() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/view/ConnectionFrame.fxml"));

			Stage st = new Stage();
			st.setTitle("Connection frame");
			

			Scene scene = new Scene((BorderPane) loader.load());
			st.setScene(scene);

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
