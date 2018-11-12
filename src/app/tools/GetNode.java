package app.tools;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;

public class GetNode {

   public GetNode(){

   }

   public Node getNodeByRowColumnIndex (final int row, final int column, GridPane grid) {
      Node result = null;
      ObservableList<Node> childrens = grid.getChildren();

      for (Node node : childrens) {
         if(grid.getRowIndex(node) == row && grid.getColumnIndex(node) == column) {
            result = node;
            break;
         }
      }

      return result;
   }
}
