package md.utm.labs.gc;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApplication extends Application {
	
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader();
		loader.setController(new Controller());
		loader.load(getClass().getResourceAsStream("/metadata.fxml"));
		Parent parent = loader.getRoot();
		primaryStage.setScene(new Scene(parent));
		primaryStage.setTitle("Function plotter v1.0");
		primaryStage.show();
	}
}
