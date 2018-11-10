package app.Game;

public class Ship {

   private int size;
   private boolean isDestroyed;
   private boolean isVertical;

   Ship(int size, boolean isDestroyed, boolean isVertical){
      this.size = size;
      this.isDestroyed = isDestroyed;
      this.isVertical = isVertical;
   }

   Ship(int size, boolean isVertical){
      this.size = size;
      this.isDestroyed = false;
      this.isVertical = isVertical;
   }

   public void setDestroyed(){
      this.isDestroyed = true;
   }
   public boolean getDestroyed(){
      return  this.isDestroyed;
   }
}
