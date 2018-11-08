package app.UI;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import app.UI.Point;

public class Board {

   private int x_size;
   private int y_size;
   private VBox board;

   Board(int x_size, int y_size){
     this.x_size = x_size;
     this.y_size = y_size;
   }

   public VBox getBoard(){
      for (int i = 0; i < this.y_size; i++){
         HBox row =new HBox();
         for(int j =0; j <this.x_size; j++){
            Point point =new Point(25,25,Color.BLACK);
            row.getChildren().add(point);
         }
         this.board.getChildren().add(row);
      }
      return this.board;
   }


}
