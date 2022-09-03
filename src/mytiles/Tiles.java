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



       /* Tiles Tiles = null;
        Tiles STiles = null;
        HashMap<Integer, Rectangle> map1 = new HashMap<>();

        map1.put(1, firstSet);
        map1.put(2, secondSet);
        map1.put(3, thirdSet);

        HashMap<Integer, Rectangle> map2 = new HashMap<>();
        map2.put(1, firstSet);
        map2.put(2, secondSet);
        map2.put(3, thirdSet);

        if(map1.get(1).equals(map2.get(1))){
            firstSet.setVisible(false);
            secondSet.setVisible(false);
            map1.remove(1, firstSet);
            map2.remove(1, firstSet);

        }
        else {
            map1.get(1).setVisible(true);
            map2.get(2).setVisible(true);
        }*/



      /* HashSet<Rectangle> check = new HashSet<>(map2.values());
       check.addAll(map1.values());
       check.remove(map.)

       HashSet<Rectangle> tile2 = new HashSet<>();
       tile2.add(firstSet);
       tile2.add(secondSet);
       tile2.add(thirdSet);*/



      /*  Tiles myTile = null;
        Tiles otherTile;

        List<Tiles> tiles = new ArrayList<>();
        tiles.add(myTile);
        tiles.add(otherTile);

        if(myTile.firstSet.getFill().equals(otherTile.firstSet.getFill())) {
            myTile.firstSet.setVisible();*/



}





