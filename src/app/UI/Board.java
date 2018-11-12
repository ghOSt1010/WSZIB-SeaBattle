package app.UI;

import app.Game.Ship;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Random;

public class Board extends VBox{

   private VBox rows = new VBox();
   private ArrayList<Ship> fleet = new ArrayList<>(1);

   private int nextShip;
   private int x_size;
   private int y_size;
   private int score;
   private boolean ShipPlace;
   private boolean directVertical;
   private boolean canShoot;
   private boolean canInteract;
   private boolean isHuman;

   public Board(int x_size, int y_size, boolean canInteract, boolean isHuman){
     this.x_size = x_size;
     this.y_size = y_size;
     this.canInteract = canInteract;
     this.canShoot = false;
     this.directVertical = false;
     this.ShipPlace = true;
     this.isHuman = isHuman;
     this.score = 20;
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
   //PC player controls
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
   public void placePCShip(){
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
   public boolean shootPC(Board board){
      Random rand = new Random();
      Point point = this.getPointFromBoard(rand.nextInt(10),rand.nextInt(10),board);
      if(!point.isUsed()){
         if(point.hit()){
            this.score --;
            System.out.println("PC: " + this.score);
            return true;
         }

      }else{
         this.shootPC(board);
      }
      return false;
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
         }
      }
   }
   public boolean canPlaceShip(Point point, Ship ship){

      if (this.ShipPlace){

         if(this.directVertical){
            if(point.gety() + ship.getSize()-1 < 9){
               return true;
            }
         }else{
            if(point.getx() + ship.getSize()-1 < 9){
               return true;
            }
         }
         return false;
      }
      return false;
   }
   private boolean shipOverlap(Point point, Ship ship){
      if(this.directVertical) {
         for (int i = 0; i == ship.getSize(); i++) {
            Point _point = this.getPoint(point.getx() + i, point.gety());
            System.out.println("Testing " + point.isShip());
            if (point.isShip()) {
               return true;
            }
         }
      }else{
         for (int i = 0; i == ship.getSize(); i++) {
            Point _point = this.getPoint(point.getx(), point.gety()+i);
            System.out.println("Testing " + point.isShip());
            if (point.isShip()) {
               return true;
            }
         }
      }
      return false;
   }
   public Point getPoint(int x, int y) {
      return (Point)((HBox)this.getChildren().get(x)).getChildren().get(y);
   }
   public Point getPointFromBoard(int x, int y, Board board) {
      return (Point)((HBox)board.getChildren().get(x)).getChildren().get(y);
   }

   //user interaction
   private void OnMouseClicked(MouseEvent event) {
      if(this.canInteract){
         Point point = (Point) event.getSource();

         //ship placing mode
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
         }
         //ship fight mode
         if (this.canShoot){
            if (point.hit()){
               score--;
               System.out.println("Player: " +score);
            }
         }
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
   public void setCanInteract(boolean CanInteract){this.canInteract = CanInteract;}
   public boolean setCanInteract(){return this.canInteract;}
}
