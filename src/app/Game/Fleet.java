package app.Game;

import app.Game.Ship;

public class Fleet {
   /*
    *  Ships to create
    *  (1x length 4, 2x length 3, 3x length 2 and 4x length 1).
    *
    *    Player and PC ships holder
    *
    */
   //All ships needed : Quantity x Length
   public Ship[] MicroShips =new Ship[4];   // 4x1
   public Ship[] MiniShips =new Ship[3];    // 3x2
   public Ship[] MidShips =new Ship[2];     // 2x3
   public Ship LongShip = null;             // 1x4

   public void initShips(){
      for (int i = 0; i < MicroShips.length; i++){
         MicroShips[i] =new Ship(4,false,false);
      }
      for(int i = 0; i < MiniShips.length; i ++){
         MiniShips[i] =new Ship(3,false,false);
      }
      for(int i = 0; i < MidShips.length; i++){
         MidShips[i] =new Ship(2,false,false);
      }
      LongShip =new Ship(4,false,false);
   }

}
