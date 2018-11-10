package app.Game;



public class Ship {

   private int size;
   private boolean isPlaced;
   private boolean isDestroyed;
   private boolean isVertical;

   /*
    *  Ships to create
    *  (1x length 4, 2x length 3, 3x length 2 and 4x length 1).
    *
    */
   //All ships needed : Quantity x Length
   public Ship[] MicroShips =new Ship[4];   // 4x1
   public Ship[] MiniShips =new Ship[3];    // 3x2
   public Ship[] MidShips =new Ship[2];     // 2x3
   public Ship LongShip = null;             // 1x4

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
   public Ship(){
      this.initShips();
   }
   public void initShips(){
      for (int i = 0; i < MicroShips.length; i++){
         MicroShips[i] =new Ship(4,false,true);
      }
      for(int i = 0; i < MiniShips.length; i ++){
         MiniShips[i] =new Ship(3,false,true);
      }
      for(int i = 0; i < MidShips.length; i++){
         MidShips[i] =new Ship(2,false,true);
      }
      LongShip =new Ship(4,false,true);
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
}
