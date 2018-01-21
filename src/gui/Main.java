package gui;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Main extends Application {
	
private static BorderPane root = new BorderPane();
	
	@Override
	public void start(Stage primaryStage) {
		try {
			this.root = FXMLLoader.load(getClass().getResource("/gui/TelaInicio.fxml"));
			Scene scene = new Scene(root,1020,680);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Donaso");
			primaryStage.getIcons().add(new Image("/imagens/logo.png"));
			primaryStage.setResizable(false);
			//primaryStage.setMaximized(true);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public static BorderPane getRoot() { 
		return root; 
	} 
	
}
