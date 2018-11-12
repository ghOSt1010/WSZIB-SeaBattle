package app.UI;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
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

      grid.add(playerBoard,2,2);
      grid.add(pcBoard,4,2);

      Scene appWindow =new Scene(grid,900,520);

      return appWindow;
   }

   public Node getNodeByRowColumnIndex (final int row, final int column) {
      Node result = null;
      ObservableList<Node> childrens = this.grid.getChildren();

      for (Node node : childrens) {
         if(this.grid.getRowIndex(node) == row && this.grid.getColumnIndex(node) == column) {
            result = node;
            break;
         }
      }

      return result;
   }
   private void setLabels(){
      Label lbPlayer =new Label("Player");
      lbPlayer.setAlignment(Pos.CENTER);
      grid.add(lbPlayer,2,1);
      Label lbPC =new Label("PC");
      lbPC.setAlignment(Pos.CENTER);
      grid.add(lbPC,4,1);
   }
   private static void onMouseClicked(MouseEvent event) {
      //Board playerBoard = (Board) getNodeByRowColumnIndex(2,2);
      //Board pcBoard = (Board) getNodeByRowColumnIndex(2,4);

      //if(playerBoard.areShipsPlaced()){
      //   pcBoard.setShootable(true);
      //}

   }

}
