package Q1;

	import javafx.application.Application;
	import javafx.fxml.FXMLLoader;
	import javafx.scene.Parent;
	import javafx.scene.Scene;
	import javafx.stage.Stage;
	public class Game extends Application{
		static Stage myStage;
		public void start(Stage stage) throws Exception{
			myStage = stage;
			Parent root = (Parent) FXMLLoader.load(getClass().getResource("GameController.fxml"));
			Scene scene = new Scene(root);
			stage.setTitle("Game");
			stage.setScene(scene);
			stage.show();
		}
		
		public static void main(String[] args) {
			launch(args);
		}
	} 



