package app.UI;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Point extends Rectangle{

   private int x;
   private int y;
   private boolean isShip;
   private boolean isUsed;

   public Point(int x, int y, Color color){
         super(25,25);
         this.x= x;
         this.y = y;
         setFill(color);
         this.isShip = false;
         this.isUsed = false;
   }

   public boolean hit() {
      if (this.isShip) {
         this.isUsed= true;
         setFill(Color.RED);
         return true;
      }else{
         this.isUsed = true;
         setFill(Color.ORANGE);
         return false;
      }
   }
   public void setColor(Color color){
         setFill(color);
      }

   public void markAsShip(){
      this.setColor(Color.BROWN);
      this.isShip = true;
   }

   //get& set
   public int getx() {
      return x;
   }

   public int gety() {
      return y;
   }

   public boolean isShip() {
      return isShip;
   }
   public void setShip(boolean ship) {
      isShip = ship;
   }
   public boolean isUsed() {
      return isUsed;
   }

}
