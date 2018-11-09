package app.UI;

import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

public class Point extends Rectangle{

      private int x;
      private int y;
      private Color color;
      private boolean wasHit;

      Point(int x, int y, Color color){
         super(25,25,color);
         this.color = color;
      }
      Point(int x,int y, int width, int height, Color color){
         super(width,height,color);
         this.x = x;
         this.y = y;
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

}
