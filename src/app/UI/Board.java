package app.UI;

import app.Game.Ship;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.geometry.Point2D;

import app.UI.Point;
import app.Game.Ship;

public class Board extends VBox{

   private VBox rows = new VBox();
   private int x_size;
   private int y_size;
   private boolean canShoot;
   //private VBox board;

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
            Point point =new Point(i,j,Color.BLUE);
            System.out.println(point.getx() + " " + point.gety());
            point.setOnMouseClicked(event -> OnMouseClicked(event));
            row.getChildren().add(point);
         }
         this.getChildren().add(row);
      }
   }
   public void setCanShoot(boolean canShoot){
      this.canShoot = canShoot;
   }
   public void placeShip(Point point, Ship ship){

      int x = point.getx();
      int y = point.gety();
      int lenght = ship.getSize();

      if (this.canPlaceShip(point, ship)){
         if(ship.isVertical()){
            for (int i =  x; i < x + lenght; i++){
               //color with ship + point is ship
               Point pointToShip = getPoint(x,y+i);
               pointToShip.markAsShip();
            }
         }else{
            for (int i = x; i < x + lenght; i++){
               //color with ship + point is ship
               Point pointToShip = getPoint(x+i, y);
               pointToShip.markAsShip();
            }
         }

      }
   }

   public boolean canPlaceShip(Point point, Ship ship){
      if ( point.getx() < 10 && point.gety() < 10){
         if (ship.isVertical()){
            if (point.getx() + ship.getSize() <= 10) {
               return true;
            }
         }else{
            if (point.gety() + ship.getSize() <= 10) {
               return true;
            }
         }
      }
      return false;
   }

   public Point getPoint(int x, int y) {
      return (Point)((HBox)this.getChildren().get(x)).getChildren().get(y);
   }

   //user interaction
   private void OnMouseClicked(MouseEvent event) {
      if (this.canShoot) {
         Point point = (Point) event.getSource();
         point.setColor(Color.ORANGE);
         //point = this.getPoint(0,0);
         Ship ship = new Ship(4,true);
         System.out.println(point.getx() + " " + point.gety());
         this.placeShip(point,ship);
      }
   }
}
