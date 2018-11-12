package app.UI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class SceneCreator {

   Board playerBoard = null;
   Board pcBoard = null;
   private boolean isPlayerTurn;

   public SceneCreator(){
      this.playerBoard =new Board(10,10,true,true);
      this.pcBoard = new Board(10,10,false,false);
      this.isPlayerTurn = true;
   }

   public Scene createScene(){
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
      playerBoard.setOnMouseClicked(event -> onMouseClicked(event));
      pcBoard.setOnMouseClicked(event -> onMouseClicked(event));

      pcBoard.initPC();
      pcBoard.setShootable(true);

      grid.add(playerBoard,2,2);
      grid.add(pcBoard,4,2);

      Scene appWindow =new Scene(grid,900,520);

      return appWindow;
   }

   private static void onMouseClicked(MouseEvent event) {
      Board board = (Board) event.getSource();
      //TODO
      //gameplay to be developed here

   }

}
