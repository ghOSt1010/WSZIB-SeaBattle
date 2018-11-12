package app.UI;

import java.util.ArrayList;
import java.util.Random;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import app.Game.Ship;

public class Board extends VBox{

   private VBox rows = new VBox();
   private ArrayList<Ship> fleet = new ArrayList<>(1);

   private int nextShip;
   private int x_size;
   private int y_size;
   private boolean canShoot;
   private int score;
   private boolean ShipPlace;
   private boolean directVertical;
   private boolean isHuman;

   public Board(int x_size, int y_size, boolean canShoot, boolean isHuman){
     this.x_size = x_size;
     this.y_size = y_size;
     this.canShoot = canShoot;
     this.directVertical = false;
     this.ShipPlace = true;
     this.isHuman = isHuman;
     this.score = 10;
     this.nextShip = 0;
     initFleet();
     initBoard();
   }

   private void initBoard(){
      this.setSpacing(5);
      for (int i = 0; i < this.y_size; i++){
         HBox row =new HBox();
         row.setSpacing(5);
         for(int j =0; j <this.x_size; j++){
            Point point =new Point(i,j,Color.BLUE);
            point.setOnMouseClicked(event -> OnMouseClicked(event));
            row.getChildren().add(point);
         }
         this.getChildren().add(row);
      }
   }
   private void initFleet(){
      for (int i = 0; i < 4; i++){
         fleet.add(new Ship(1,false));
      }
      for(int i = 0; i < 3; i ++){
         fleet.add(new Ship(2,false));
      }
      for(int i = 0; i < 2; i++){
         fleet.add(new Ship(3,false));
      }
      fleet.add(new Ship(4,false));
   }
   public void setCanShoot(boolean canShoot){
      this.canShoot = canShoot;
   }
   public void initPC(){

      while(this.ShipPlace){
         Random rand = new Random();
         Point point = this.getPoint(rand.nextInt(9),rand.nextInt(9));
         int vh = rand.nextInt(1);
         if (vh == 0) {
            this.directVertical = true;
            this.placeShip(point, fleet.get(this.nextShip));
         } else {
            this.directVertical = false;
            this.placeShip(point, fleet.get(this.nextShip));
         }
      }
   }
   public void placeShip(Point point, Ship ship){

      int x = point.getx();
      int y = point.gety();
      int lenght = ship.getSize();

      if (this.canPlaceShip(point, ship)){
         if(this.directVertical){
            for (int i =  0; i < lenght; i++){
               //color with ship + point is ship
               Point pointToShip = getPoint(x,y+i);
               if (this.isHuman) {
                  pointToShip.markAsShip();
               }else{
                  pointToShip.setShip(true);
               }
            }
         }else{
            for (int i = 0; i < lenght; i++){
               //color with ship + point is ship
               Point pointToShip = getPoint(x+i, y);
               if (this.isHuman) {
                  pointToShip.markAsShip();
               }else{
                  pointToShip.setShip(true);
               }
            }
         }
         nextShip ++;
         if (this.nextShip == 10){
            this.ShipPlace = false;
            this.canShoot = true;
         }
         System.out.println(this.nextShip + " " + this.ShipPlace);
      }

   }
   public boolean canPlaceShip(Point point, Ship ship){
      if (this.ShipPlace){
         if ( point.getx() < 10 && point.gety() < 10){
            if (this.directVertical){
               if (point.getx() + ship.getSize() <= 10) {
                  return true;
               }
            }else{
               if (point.gety() + ship.getSize() <= 10) {
                  return true;
               }
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

      Point point = (Point) event.getSource();

      if (this.ShipPlace){
         if ("SECONDARY" == event.getButton().toString()) {
            //ship orientation = vertical
            this.directVertical = true;
            placeShip(point,fleet.get(this.nextShip));
         } else {
            //ship orientation horizontal
            this.directVertical = false;
            placeShip(point,fleet.get(this.nextShip));
      }
         System.out.println(this.nextShip);
      }
      if (!this.ShipPlace && this.nextShip == 10 && this.canShoot){
         point.hit();
      }
   }

   public int getScore() {
      return score;
   }
   public void setScore(int score) {
      this.score = score;
   }
   public boolean areShipsPlaced() {
      return this.ShipPlace;
   }
   public void setShipsPlaced(boolean areShipsPlaced) {
      this.ShipPlace = areShipsPlaced;
   }
   public  boolean isShootable(){return this.canShoot;}
   public void setShootable(boolean Shootable){this.canShoot = Shootable;}
}
