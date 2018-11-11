package app.UI;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

import app.UI.*;

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
      lbPlayer.setAlignment(Pos.CENTER);
      grid.add(lbPlayer,2,1);
      Label lbPC =new Label("PC");
      lbPC.setAlignment(Pos.CENTER);
      grid.add(lbPC,4,1);

      //setting button
      Button btnStartNewGame =new Button("New Game");
      grid.add(btnStartNewGame,5,1);


      //setting Player and PC boards
      Board playerBoard =new Board(10,10,true);
      Board pcBoard =new Board(10,10,false);

      grid.add(playerBoard,2,2);
      grid.add(pcBoard,4,2);

      Scene appWindow =new Scene(grid,900,520);

      return appWindow;
   }

   private static void onMouseClicked(MouseEvent event) {
   }

}
