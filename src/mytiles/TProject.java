package mytiles;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.control.TextArea;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

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

        Label text = new Label(newStreak(0, 0)[0]);
        Label text1 = new Label(newStreak(0, 0)[1]);

//        Text text = new Text("Current Score = " + currScore);
//        Text text1 = new Text("   Longest Streak = " + longScore);


        root.add(text, 7, 0);
        root.add(text1, 10, 0);


        for (int i = 0; i < BOARD_WIDTH; i++) {
            for (int j = 0; j < BOARD_HEIGHT; j++) {




                Tiles tiles = new Tiles();
                tiles.setTranslateX(i * 100);
                tiles.setTranslateY(j * 100);

                List<Tiles> myTiles = new ArrayList<>();
                myTiles.add(tiles);
                myTiles.add(tile1);
                myTiles.add(tile2);

                                /*Action event that lets the player compare tiles
                * based on color*/
                tiles.setOnMouseClicked(event -> {


                    mouseClick++;
                    if (mouseClick == 1) {
                        tile1 = tiles;
                        //tile1.firstSet.setStroke(Color.ORANGE);
                      //  System.out.println("First Click");
                    }
                        else if (mouseClick == 2 && tile1 != tiles) {
                           // System.out.println("Second Click");
                            tile2 = tiles;
                           // tile2.firstSet.setStroke(Color.ORANGE);

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
                                myTiles.remove(tile1.firstSet);
                                myTiles.remove(tile2.firstSet);
                            }

                        if(tile1.secondSet.getFill() == tile2.secondSet.getFill()) {
                            tile1.secondSet.setVisible(false);
                            tile2.secondSet.setVisible(false);
                            myTiles.remove(tile1.secondSet);
                            myTiles.remove(tile2.secondSet);
                        }

                        if(tile1.thirdSet.getFill() == tile2.thirdSet.getFill()) {
                            tile1.thirdSet.setVisible(false);
                            tile2.thirdSet.setVisible(false);
                            myTiles.remove(tile1.thirdSet);
                            myTiles.remove(tile2.thirdSet);
                        }

                        mouseClick = 0;

                        /*System.out.println("Current score = " + currScore);
                        System.out.println("Longest Score = " + longScore);*/


                       newStreak(currScore, longScore);

                      /* text.setText(newStreak(currScore, longScore).toString());
                       text1.setText(newStreak(currScore, longScore).toString());*/

                        text.setText(newStreak(currScore, longScore)[0]);
                        text1.setText(newStreak(currScore, longScore)[1]);



                        
                    }


                });

                root.add(tiles, BOARD_WIDTH, BOARD_HEIGHT);


            }



        }
        return root;
    }

   /* public List<String> newStreak(int currScore, int longScore) {
        List<String> myStreak = new ArrayList<>();
        myStreak.add("Current Score = " + currScore);
        myStreak.add("Longest Streak = " + longScore);
        return myStreak;
    }*/

    public String[] newStreak(int currScore, int longScore) {
        String[] myStreak = new String[2];
        myStreak[0] = ("Current Score = " + currScore);
        myStreak[1] = ("   Longest Streak = " + longScore);
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
