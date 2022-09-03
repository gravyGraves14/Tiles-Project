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
    Tiles tiles1 = new Tiles();
    Tiles tiles2 = new Tiles();


    private Parent theGame() {
        GridPane root = new GridPane();
            root.setPrefSize(BOARD_WIDTH * TILE_SIZE, BOARD_HEIGHT * TILE_SIZE);

            Color[] colorVal = Tiles.myShuffle();
            Color[] nColor = Tiles.myShuffle();
            Color[] mColor = Tiles.myShuffle();
            int choice = 0;

            for (int i = 0; i < BOARD_WIDTH; i++) {
                for (int j = 0; j < BOARD_HEIGHT; j++) {

                    Tiles tiles = new Tiles();
                    tiles.setTranslateX(i * 100);
                    tiles.setTranslateY(j * 100);

                    choice++;
                    if (choice >= 10) {
                        choice = 0;
                    }

                    tiles.setOnMouseClicked(event -> {
                    if (mouseClick == 0) {
                      tiles1 = tiles;
                      System.out.println("First");
                    }
                    else if(mouseClick == 1) {
                        tiles2 = tiles;
                        System.out.println("Second");

                        if(tiles1 == tiles2); {
                            System.out.println("Three");
                            tiles1.firstSet.setVisible(false);
                            tiles1.secondSet.setVisible(false);
                            tiles1.thirdSet.setVisible(false);
                            tiles2.firstSet.setVisible(false);
                            tiles2.secondSet.setVisible(false);
                            tiles2.thirdSet.setVisible(false);

                        }
                        mouseClick = 0;

                    }
                        mouseClick++;
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
