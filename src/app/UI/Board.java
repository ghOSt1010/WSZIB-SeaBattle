package app.UI;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import app.UI.Point;


public class Board{

   private int x_size;
   private int y_size;
   private VBox board;

   Board(int x_size, int y_size){
     this.x_size = x_size;
     this.y_size = y_size;
   }

   public VBox getBoard(){
      board =new VBox();
      board.setSpacing(5);
      for (int i = 0; i < this.y_size; i++){
         HBox row =new HBox();
         row.setSpacing(5);
         for(int j =0; j <this.x_size; j++){
            Point point =new Point(25,25,Color.AQUA);
            point.setOnMouseClicked(event -> OnMouseClicked(event));
            point.setOnMouseReleased(event -> onMouseReleased(event));
            row.getChildren().add(point);
         }
         this.board.getChildren().add(row);
      }
      return this.board;
   }

   private void onMouseReleased(MouseEvent event) {
      Point point =(Point) event.getSource();
      point.setColor(Color.RED);
   }

   private void OnMouseClicked(MouseEvent event) {
      Point point = (Point) event.getSource();
      System.out.println(event.getSource());
      point.setColor(Color.RED);
   }

}
