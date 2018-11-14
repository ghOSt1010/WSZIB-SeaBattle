package sample;

import app.UI.SceneCreator;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

   //App window init
    @Override
    public void start(Stage primaryStage) {
       //Parent root = FXMLLoader.load(getClass().getResource("sample_new.fxml"));

       primaryStage.setTitle("Welcome to Sea Battle");
       //primaryStage.setScene(new Scene(root));

       primaryStage.setScene(new SceneCreator().createScene());
       primaryStage.show();

    }

    public static void main(String[] args) {
       launch(args);
    }
}
