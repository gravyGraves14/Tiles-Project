import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.*;

public class Tiles extends StackPane implements Comparable {

    private final Rectangle firstSet;
    private final Rectangle secondSet;
    private final Rectangle thirdSet;

    /*This Class just shuffles my colors in
    * a random order*/
    public static Color[] myShuffle() {

        Color[] colorVal = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.AZURE, Color.BLUEVIOLET, Color.PINK, Color.BURLYWOOD,
                Color.ORANGE, Color.FUCHSIA};
        List<Color> list = Arrays.asList(colorVal);
        Collections.shuffle(list);

        return colorVal;
    }

    /*This Tiles constructor is just creating rectangles
    * to display on the board*/
    public Tiles(Color color, Color nColor, Color mColor) {


        firstSet = new Rectangle(100, 100);
        firstSet.setFill(color);
        firstSet.setArcHeight(20);
        firstSet.setArcWidth(20);
        firstSet.setStrokeWidth(3);


        secondSet = new Rectangle(70, 70);
        secondSet.setStroke(Color.BLACK);
        secondSet.setFill(nColor);
        secondSet.setArcHeight(20);
        secondSet.setArcWidth(20);


        thirdSet = new Rectangle(40, 40);
        thirdSet.setStroke(Color.BLACK);
        thirdSet.setFill(mColor);
        thirdSet.setArcHeight(20);
        thirdSet.setArcWidth(20);

        List<Rectangle> rects = new ArrayList<>();
        rects.add(firstSet);
        rects.add(secondSet);
        rects.add(thirdSet);

        setOnMouseClicked(e -> firstSet.setVisible(true));
        setOnMouseClicked(e -> firstSet.setStroke(Color.BLACK));

        setOnMouseClicked(event -> {
            if (firstSet.getFill().equals(secondSet.getFill()) ||
                    firstSet.getFill().equals(thirdSet.getFill()) ||
                    secondSet.getFill().equals(thirdSet.getFill())) {
                setVisible(false);
            } else {
                setVisible(true);

            }
        });


        getChildren().addAll(firstSet, secondSet, thirdSet);
    }


    @Override
    public int compareTo(Object o) {
        return 0;
    }
}