package mytiles;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;

public class TProject extends Application {

    public static final int TILE_SIZE = 100;
    public static final int BOARD_WIDTH = 5;
    public static final int BOARD_HEIGHT = 6;

    private int mouseClick = 0;
    Tiles tile1 = new Tiles();
    Tiles tile2 = new Tiles();
    int currScore = 0;
    int longScore;

    private Parent theGame() {
        GridPane root = new GridPane();
        root.setPrefSize(500, 750);

        Label text = new Label(newStreak(0, 0).get(0));
        Label text1 = new Label(newStreak(0, 0).get(1));

        root.add(text, 7, 0);
        root.add(text1, 10, 0);

        for (int i = 0; i < BOARD_WIDTH; i++) {
            for (int j = 0; j < BOARD_HEIGHT; j++) {

                Tiles tiles = new Tiles();
                tiles.setTranslateX(i * 100);
                tiles.setTranslateY(j * 100);


                /*Action event that lets the player compare tiles
                * based on color, then gradually moves through if and
                * else statements to determine what colors match*/
                tiles.setOnMouseClicked(event -> {

                    mouseClick++;
                    if (mouseClick == 1) {
                        tile1 = tiles;
                        tile1.firstSet.setStroke(Color.ORANGE);

                    }
                        else if (mouseClick == 2 && tile1 != tiles) {

                            tile2 = tiles;
                            tile2.firstSet.setStroke(Color.ORANGE);

                        if (tile1.firstSet.getFill() == tile2.firstSet.getFill() ||
                        tile1.secondSet.getFill() == tile2.secondSet.getFill() ||
                        tile1.thirdSet.getFill() == tile2.thirdSet.getFill()) {
                            currScore++;

                            if (currScore >= longScore) {
                                longScore = currScore;
                            }
                        }

                        else {
                            currScore = 0;
                        }

                        if(tile1.firstSet.getFill() == tile2.firstSet.getFill()) {
                            tile1.firstSet.setVisible(false);
                            tile2.firstSet.setVisible(false);

                        }

                        if(tile1.secondSet.getFill() == tile2.secondSet.getFill()) {
                            tile1.secondSet.setVisible(false);
                            tile2.secondSet.setVisible(false);

                        }

                        if(tile1.thirdSet.getFill() == tile2.thirdSet.getFill()) {
                            tile1.thirdSet.setVisible(false);
                            tile2.thirdSet.setVisible(false);

                        }

                        tile1.firstSet.setStroke(Color.BLACK);
                        tile2.firstSet.setStroke(Color.BLACK);

                        mouseClick = 0;

                        newStreak(currScore, longScore);

                        text.setText(newStreak(currScore, longScore).get(0));
                        text1.setText(newStreak(currScore, longScore).get(1));
                    }
                });

                root.add(tiles, BOARD_WIDTH, BOARD_HEIGHT);
            }
        }
        return root;
    }


    /*This newStreak method takes in my current record and longest
    * into a list and adds it to the parent method above*/
    public List<String> newStreak(int currScore, int longScore) {
        List<String> myStreak = new ArrayList<>();
        myStreak.add("Current Score = " + currScore);
        myStreak.add("  Longest Streak = " + longScore);
        return myStreak;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(theGame()));
        primaryStage.setTitle("My Tiles");
        primaryStage.setHeight(750);
        primaryStage.setResizable(false);
        primaryStage.show();

    }
    public static void main(String[] args) {
        launch(args);
    }
}
