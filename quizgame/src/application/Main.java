package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;


public class Main extends Application {
	
	

	@Override
		public void start(Stage stage) throws Exception{
			Parent root = FXMLLoader.load(getClass().getResource("sceneone.fxml"));
			Image icon = new Image("logo.png");
			stage.getIcons().add(icon);
			stage.setWidth(1000);
			stage.setHeight(700);
			stage.setResizable(false);
			stage.setTitle("Stage demo");
			stage.setFullScreen(false);
			stage.setFullScreenExitHint(" Esc انزل على FULL SCREEN كان تحب تخرج من ");
			stage.setScene(new Scene(root, 800, 500));
			stage.show();
			}
		
		
		/*
		
		Image icon = new Image("logo.png");
		stage.getIcons().add(icon);
		stage.setWidth(1000);
		stage.setHeight(700);
		stage.setResizable(false);
		stage.setTitle("Stage demo");
		stage.setFullScreen(false);
		stage.setFullScreenExitHint(" Esc انزل على FULL SCREEN كان تحب تخرج من ");
		stage.setScene(scene);
		stage.show();
		
		*/
	
//	public static void main(String[] args) {	launch(args);}

}
