package app.Game;

import app.Game.*;
import app.UI.*;

import java.net.HttpURLConnection;

public class Game {

   public Player HumanPlayer = null;
   public Player PCPlayer = null;

   private boolean IsGameStarted;
   private int boardsize;


   public Game(){
      this.IsGameStarted = false;
      this.boardsize = 10;
      this.HumanPlayer = new Player(this.boardsize);
      this.PCPlayer = new Player(this.boardsize);
   }

   public boolean start(){
      this.IsGameStarted = true;






      return this.IsGameStarted;
   }

}
