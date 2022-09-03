package mytiles;

import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.*;
import java.util.List;

public class Tiles extends StackPane {

    Rectangle firstSet;
    Rectangle secondSet;
    Rectangle thirdSet;
    private Color tileColor;

     public static Color[] myShuffle() {
        Color[] colorVal = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.DARKCYAN, Color.BLUEVIOLET, Color.PINK, Color.BURLYWOOD,
                Color.ORANGE, Color.GREY};

        List<Color> list = Arrays.asList(colorVal);
        Collections.shuffle(list);

        return colorVal;
    }

    public Color getTileColor() {
         return tileColor;
    }


    /*This Class just shuffles my colors in
     * a random order*/


    /*This Tiles constructor is just creating rectangles
     * to display on the board*/

    public Tiles() {

        firstSet = new Rectangle(100, 100);
        firstSet.setStroke(Color.BLACK);
        firstSet.setFill(Color.ORANGE);
        firstSet.setArcHeight(20);
        firstSet.setArcWidth(20);
        firstSet.setStrokeWidth(3);

        secondSet = new Rectangle(70, 70);
        secondSet.setStroke(Color.BLACK);
        secondSet.setFill(Color.BLUE);
        secondSet.setArcHeight(20);
        secondSet.setArcWidth(20);
        secondSet.setStrokeWidth(3);

        thirdSet = new Rectangle(40, 40);
        thirdSet.setStroke(Color.BLACK);
        thirdSet.setFill(Color.DARKGOLDENROD);
        thirdSet.setArcHeight(20);
        thirdSet.setArcWidth(20);
        thirdSet.setStrokeWidth(3);

        getChildren().addAll(firstSet, secondSet, thirdSet);
    }


    public static void Compare(Tiles tiles) {


        tiles.setOnMouseClicked(event -> tiles.firstSet.setStroke(Color.ORANGE));

        if (tiles.firstSet.getFill().equals(tiles.secondSet.getFill())) {
            tiles.firstSet.setVisible(false);
            tiles.secondSet.setVisible(false);
        }
        if (tiles.secondSet.getFill().equals(tiles.thirdSet.getFill())) {
            tiles.secondSet.setVisible(false);
            tiles.thirdSet.setVisible(false);
        }

        if (tiles.firstSet.getFill().equals(tiles.thirdSet.getFill())) {
            tiles.firstSet.setVisible(false);
            tiles.thirdSet.setVisible(false);
        }
    }

}





