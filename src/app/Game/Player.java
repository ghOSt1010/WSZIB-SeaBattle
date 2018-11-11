package app.Game;

import app.UI.Board;

public class Player {

   public Board board = null;

   public Player(int boardsize){
      this.board = new Board(boardsize,boardsize,true,true);

   }
}
