package mytiles;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.util.*;
import java.util.List;

public class Tiles extends StackPane {

    Rectangle firstSet;
    Rectangle secondSet;
    Rectangle thirdSet;


    /*This method shuffles the colors*/
     public static Color[] myShuffle() {
        Color[] colorVal = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.PINK};

        List<Color> list = Arrays.asList(colorVal);
        Collections.shuffle(list);

        return colorVal;
    }

    /*This method adds the shuffled color
    * to each individual rectangle*/
    public Rectangle addColor(Rectangle rect) {

         Color colorVal[] = myShuffle();
         int choice = 0;

         if(rect.equals(firstSet)) {
             choice++;
             rect.setFill(colorVal[choice]);

         }
         else if(rect.equals(secondSet)) {
             choice++;
             rect.setFill(colorVal[choice]);
         }

         else if(rect.equals(thirdSet)) {
             choice++;
             rect.setFill(colorVal[choice]);
         }
         return rect;
    }

    /*This Tiles constructor is just creating rectangles
     * to display on the board*/

    public Tiles() {

        firstSet = new Rectangle(100, 100);
        firstSet.setStroke(Color.BLACK);
        firstSet.setArcHeight(20);
        firstSet.setArcWidth(20);
        firstSet.setStrokeWidth(3);

        secondSet = new Rectangle(70, 70);
        secondSet.setStroke(Color.BLACK);
        secondSet.setArcHeight(20);
        secondSet.setArcWidth(20);
        secondSet.setStrokeWidth(3);

        thirdSet = new Rectangle(40, 40);
        thirdSet.setStroke(Color.BLACK);
        thirdSet.setArcHeight(20);
        thirdSet.setArcWidth(20);
        thirdSet.setStrokeWidth(3);

        getChildren().addAll(addColor(firstSet), addColor(secondSet), addColor(thirdSet));
    }

}





