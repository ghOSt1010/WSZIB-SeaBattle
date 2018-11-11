package app.UI;

import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

public class Point extends Rectangle{

   private int x;
   private int y;
   private boolean isShip;
   private boolean isUsed;

   Point(int x, int y, Color color){
         super(25,25);
         this.x= x;
         this.y = y;
         setFill(color);
         this.isShip = false;
         this.isUsed = false;
      }
   Point(int x,int y, int width, int height, Color color){
         super(width,height);
         this.x = x;
         this.y = y;
         setFill(color);
      }

   public void hit() {
      if (this.isShip) {
         setFill(Color.RED);
      }else{
         setFill(Color.ORANGE);
      }
   }
   public void setColor(Color color){
         setFill(color);
      }
   public void setDefaultColor(){
         setFill(Color.AQUA);
      }
   public void markAsShip(){
      this.setColor(Color.BROWN);
      this.isShip = true;
   }
   public int getx() {
      return x;
   }
   public void setx(int x) {
      this.x = x;
   }
   public int gety() {
      return y;
   }
   public void sety(int y) {
      this.y = y;
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

   public void setUsed(boolean used) {
      isUsed = used;
   }
}
