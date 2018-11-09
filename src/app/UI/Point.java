package app.UI;

import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;


public class Point extends Rectangle{

      private int x;
      private int y;
      private Color color;
      private boolean wasHit;

      Point(int x, int y, Color color){
         super(x,y,color);
         this.x = x;
         this.y = y;
         this.color = color;
      }

      public void hit(){
         this.color = Color.RED;
      }

      public void hideContent(){
         this.color = Color.AQUA;
      }

      public void setColor(Color color){
         this.color = color;
      }

      public void setDefaultColor(){
         this.color = Color.DARKBLUE;
      }

}
