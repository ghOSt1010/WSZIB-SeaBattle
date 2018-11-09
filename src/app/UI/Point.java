package app.UI;

import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

public class Point extends Rectangle{

      private int x;
      private int y;
      private Color color;
      private Rectangle rect;
      private boolean wasHit;

      Point(int x, int y, Color color){
         super(x,y,color);
         this.x = x;
         this.y = y;
         this.color = color;
         //to be removed
         this.rect =new Rectangle(this.x,this.y,this.color);
      }

      public Rectangle getPoint(){
         return this.rect;
      }

      public void hit(){
         this.color = Color.RED;
      }

      public void hideContent(){
         this.color = Color.AQUA;
      }

}
