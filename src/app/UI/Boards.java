package app.UI;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

public class Boards {

   private int x_size;
   private int y_size;
   private GridPane Board;

   Boards(int x_size, int y_size){
      this.x_size = x_size;
      this.y_size = y_size;

      for(int i = 0; i < x_size; i++){
         this.Board.addRow(i);
      }
      for(int j = 0; j < y_size; j++) {
         this.Board.addColumn(j);
      }
      this.Board.setHgap(10);
      this.Board.setVgap(10);
      this.Board.setPadding(new Insets(5, 5, 5, 5));
   }

   public GridPane getBoard(){
      return this.Board;
   }


}
