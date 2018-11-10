package app.UI;

import app.Game.Ship;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import app.UI.Point;
import app.Game.Ship;

public class Board extends VBox{

   private VBox rows = new VBox();
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
            point.setID(Integer.toString(i) + Integer.toString(j));
            point.setOnMouseClicked(event -> OnMouseClicked(event));
            row.getChildren().add(point);
         }
         this.getChildren().add(row);
      }
   }

   private void OnMouseClicked(MouseEvent event) {
      if (this.canShoot) {
         Point point = (Point) event.getSource();
         System.out.println(point.getID());
         point.setColor(Color.ORANGE);
      }
   }

   public void setCanShoot(boolean canShoot){
      this.canShoot = canShoot;
   }

   public void placeShip(Point point, Ship ship){

      if (this.canPlaceShip(point, ship)){
         if(ship.isVertical()){
            for (int i =  point.getPos_y(); i < point.getPos_y() + ship.getSize(); i++){
               //color with ship + point is ship
               Point pointToShip = getPoint(point.getPos_x(), i);
               pointToShip.markAsShip();
            }
         }else{
            for (int i =  point.getPos_x(); i < point.getPos_x() + ship.getSize(); i++){
               //color with ship + point is ship
               Point pointToShip = getPoint(i, point.getPos_y());
               pointToShip.markAsShip();
            }
         }

      }
   }
   public boolean canPlaceShip(Point point, Ship ship){
      if ( point.getPos_x() < 10 && point.getPos_y() < 10){
         if (ship.isVertical()){
            if (point.getPos_x() + ship.getSize() < 10) {
               return true;
            }
         }else{
            if (point.getPos_y() + ship.getSize() < 10) {
               return true;
            }
         }
      }
      return false;
   }
   public Point getPoint(int x, int y) {

      return (Point)((HBox)rows.getChildren().get(y)).getChildren().get(x);
   }

}
