package app.UI;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import app.UI.Point;

public class Board extends VBox{

   private int x_size;
   private int y_size;
   private boolean canShoot;
   private VBox board;

   Board(int x_size, int y_size, boolean canShoot){
     this.x_size = x_size;
     this.y_size = y_size;
     this.canShoot = canShoot;
     initBoard();
   }

   private void initBoard(){
      this.setSpacing(5);
      for (int i = 0; i < this.y_size; i++){
         HBox row =new HBox();
         row.setSpacing(5);
         for(int j =0; j <this.x_size; j++){
            Point point =new Point(25,25,Color.BLUE);
            point.setOnMouseClicked(event -> OnMouseClicked(event));
            row.getChildren().add(point);
         }
         this.getChildren().add(row);
      }
   }

   private void OnMouseClicked(MouseEvent event) {
      if (this.canShoot) {
         Point point = (Point) event.getSource();
         point.setColor(Color.ORANGE);
      }
   }

   public void setCanShoot(boolean canShoot){
      this.canShoot = canShoot;
   }

}
