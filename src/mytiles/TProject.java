package mytiles;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.concurrent.atomic.AtomicReference;

public class TProject extends Application {

    public static final int TILE_SIZE = 100;
    public static final int BOARD_WIDTH = 5;
    public static final int BOARD_HEIGHT = 6;

    private int mouseClick = 0;
    Tiles tile1 = new Tiles();
    Tiles tile2 = new Tiles();


    private Parent theGame() {
        GridPane root = new GridPane();
        root.setPrefSize(BOARD_WIDTH * TILE_SIZE, BOARD_HEIGHT * TILE_SIZE);

        /*Color[] colorVal = Tiles.myShuffle();
        Color[] nColor = Tiles.myShuffle();
        Color[] mColor = Tiles.myShuffle();
        int choice = 0;*/

        for (int i = 0; i < BOARD_WIDTH; i++) {
            for (int j = 0; j < BOARD_HEIGHT; j++) {

                Tiles tiles = new Tiles();
                tiles.setTranslateX(i * 100);
                tiles.setTranslateY(j * 100);


                /*Action event that lets the player compare tiles
                * based on color*/
                tiles.setOnMouseClicked(event -> {
                    mouseClick++;
                    if (mouseClick == 1) {
                        tile1 = tiles;
                        tile1.firstSet.setStroke(Color.ORANGE);
                        System.out.println("First Click");
                    }
                        else if (mouseClick == 2) {
                            System.out.println("Second Click");
                            tile2 = tiles;
                            tile2.firstSet.setStroke(Color.ORANGE);

                            if(tile1.firstSet.getFill().equals(tile2.firstSet.getFill())) {
                                tile1.firstSet.setVisible(false);
                                tile2.firstSet.setVisible(false);
                            }

                        if(tile1.secondSet.getFill().equals(tile2.secondSet.getFill())) {
                            tile1.secondSet.setVisible(false);
                            tile2.secondSet.setVisible(false);
                        }

                        if(tile1.thirdSet.getFill().equals(tile2.thirdSet.getFill())) {
                            tile1.thirdSet.setVisible(false);
                            tile2.thirdSet.setVisible(false);
                        }

                        mouseClick = 0;

                    }


                });
                root.add(tiles, BOARD_WIDTH, BOARD_HEIGHT);


            }


        }
        return root;
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
