package app.UI;

import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

public class Point extends Rectangle{

   private int x;
   private int y;
   private boolean isShip;
   private boolean isDamaged;
   private boolean isUsed;

   public Point(int x, int y, Color color){
         super(25,25);
         this.x= x;
         this.y = y;
         setFill(color);
         this.isShip = false;
         this.isUsed = false;
         this.isDamaged = false;
      }

   public void hit() {
      if (this.isShip) {
         this.isDamaged = true;
         this.isUsed= true;
         setFill(Color.RED);
      }else{
         this.isUsed = true;
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

   //get& set
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
   public boolean isDamaged() {
      return isDamaged;
   }
   public void setDamaged(boolean damaged) {
      isDamaged = damaged;
   }

}
