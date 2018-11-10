package app.UI;

import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

public class Point extends Rectangle{

   private int pos_x;
   private int pos_y;
   private Color color;
   private String ID;
   private boolean isShip;

   Point(int pos_x, int pos_y, Color color){
         super(25,25,color);
         this.pos_x= pos_x;
         this.pos_y = pos_y;
         this.color = color;
         this.isShip = false;
      }
   Point(int pos_x,int pos_y, int width, int height, Color color){
         super(width,height,color);
         this.pos_x = pos_x;
         this.pos_y = pos_y;
      }

   public void hit(){
         setFill(Color.RED);
      }
   public void setColor(Color color){
         setFill(color);
      }
   public void setDefaultColor(){
         setFill(Color.AQUA);
      }
   public void markAsShip(){
      this.setColor(Color.BROWN);
   }
   public void setID(String id){this.ID = id;}
   public String getID(){return this.ID;}

   public int getPos_x() {
      return pos_x;
   }
   public void setPos_x(int pos_x) {
      this.pos_x = pos_x;
   }
   public int getPos_y() {
      return pos_y;
   }
   public void setPos_y(int pos_y) {
      this.pos_y = pos_y;
   }
   public boolean isShip() {
      return isShip;
   }
   public void setShip(boolean ship) {
      isShip = ship;
   }
}
