package app.UI;

import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

public class Point extends Rectangle{

      private int x;
      private int y;
      private Color color;
      private String ID;
      boolean isUncovered;

      Point(int x, int y, Color color){
         super(25,25,color);
         this.color = color;
         this.isUncovered = false;
      }
      Point(int x,int y, int width, int height, Color color){
         super(width,height,color);
         this.x = x;
         this.y = y;
      }

      public void hit(){
         setFill(Color.RED);
      }
      public boolean uncover(){return this.isUncovered;}

      public void setColor(Color color){
         setFill(color);
      }

      public void setDefaultColor(){
         setFill(Color.AQUA);
      }

      public void setID(String id){this.ID = id;}
      public String getID(){return this.ID;}

}
