package app.UI;

import app.tools.GetNode;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class SceneCreator {

   private Board playerBoard = null;
   private Board pcBoard = null;
   //setting main grid
   GridPane grid = null;

   private boolean PlayerSetShips;
   private boolean isPlayerTurn;

   public SceneCreator(){
      this.playerBoard =new Board(10,10,true,true);
      this.pcBoard = new Board(10,10,false,false);
      this.grid = new GridPane();
      this.PlayerSetShips = false;
      this.isPlayerTurn = true;
      this.grid.setHgap(10);
      this.grid.setVgap(10);
      this.grid.setPadding(new Insets(25, 25, 25, 25));
   }

   public Scene createScene(){
      //setting button
      Button btnStartNewGame =new Button("New Game");
      grid.add(btnStartNewGame,5,1);
      grid.setOnMouseClicked(event -> onMouseClicked(event));
      //setting labels
      this.setLabels();

      //setting Player and PC boards
      pcBoard.initPC();
      pcBoard.setShootable(true);
      pcBoard.setCanInteract(true);

      grid.add(playerBoard,2,2);
      grid.add(pcBoard,4,2);

      Scene appWindow =new Scene(grid,900,520);

      return appWindow;
   }
   private void setLabels(){
      Label lbPlayer =new Label("Player");
      lbPlayer.setAlignment(Pos.CENTER);
      grid.add(lbPlayer,2,1);
      Label lbPC =new Label("PC");
      lbPC.setAlignment(Pos.CENTER);
      grid.add(lbPC,4,1);
   }

   //main game interaction
   private static void onMouseClicked(MouseEvent event) {
      GridPane app = (GridPane) event.getSource();
      GetNode getNode =new GetNode();

      Board _playerBoard = (Board)getNode.getNodeByRowColumnIndex(2,2,app);
      Board _pcBoard = (Board)getNode.getNodeByRowColumnIndex(2,2,app);

      if(!_playerBoard.areShipsPlaced()){
         _pcBoard.shootPC(_playerBoard);
      }

      app.getChildren().remove(getNode.getNodeByRowColumnIndex(1, 2, app));
      Label _playerLabel = new Label("Player | Score: " + _playerBoard.getScore());
      app.add(_playerLabel, 2, 1);

      app.getChildren().remove(getNode.getNodeByRowColumnIndex(1, 4, app));
      Label _pcLabel = new Label("PC | Score: " + _pcBoard.getScore());
      app.add(_pcLabel, 4, 1);
   }
}
