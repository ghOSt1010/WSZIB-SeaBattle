package app.Game;

public class Ship {

   private int x;
   private int y;
   private int size;
   private boolean isPlaced;
   private boolean isDestroyed;
   private boolean isVertical;

   public Ship(int size, boolean isDestroyed, boolean isVertical){
      this.size = size;
      this.isDestroyed = isDestroyed;
      this.isVertical = isVertical;
      this.isPlaced = false;
   }
   public Ship(int size, boolean isVertical){
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
   public boolean isPlaced() {
      return isPlaced;
   }
   public void setPlaced(boolean placed) {
      isPlaced = placed;
   }


   //ship position info + get & set
   public void setPosition(int x, int y){
      this.x = x;
      this.y = y;
   }
   public int getX() {
      return x;
   }
   public void setX(int x) {
      this.x = x;
   }
   public int getY() {
      return y;
   }
   public void setY(int y) {
      this.y = y;
   }
   public boolean isVertical() {
      return this.isVertical;
   }
   public void setVertical(boolean vertical) {
      this.isVertical = vertical;
   }
   public int getSize() {
      return this.size;
   }
   public void setSize(int size) {
      this.size = size;
   }
}
