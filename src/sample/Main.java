package sample;

import javafx.application.Application;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import app.UI.SceneCreator;

public class Main extends Application {

   //App window init
    @Override
    public void start(Stage primaryStage) throws Exception{
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
