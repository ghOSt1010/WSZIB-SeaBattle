package app.UI;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.Node;

import app.UI.Boards;

//import java.awt.*;

public class SceneCreator {

   public static Scene createScene(){
      //setting main grid
      GridPane grid =new GridPane();

      //grid.setAlignment();
      grid.setHgap(10);
      grid.setVgap(10);
      grid.setPadding(new Insets(25, 25, 25, 25));

      //setting labels
      Label lbPlayer =new Label("Player");
      grid.add(lbPlayer,2,1);
      Label lbPC =new Label("PC");
      grid.add(lbPC,4,1);

      //setting button
      Button btnStartNewGame =new Button("New Game");
      grid.add(btnStartNewGame,5,1);

      //setting Player and PC boards
      Button b1 =new Button("1");
      Button b2 =new Button("2");
      Button b11 =new Button("11");
      Button b22 =new Button("22");
      HBox h1 =new HBox(b1,b2);
      HBox h2 =new HBox(b11,b22);
      VBox v1 =new VBox(h1,h2);

      grid.add(v1,2,2);


      Scene appWindow =new Scene(grid,940,520);


      return appWindow;
   }

}
