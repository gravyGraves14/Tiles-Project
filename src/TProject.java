
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class TProject extends Application {


    public static final int TILE_SIZE = 100;
    public static final int BOARD_WIDTH = 5;
    public static final int BOARD_HEIGHT = 6;


    private Parent theGame() {
        GridPane root = new GridPane();
        root.setPrefSize(BOARD_WIDTH * TILE_SIZE, BOARD_HEIGHT * TILE_SIZE);

        Color[] colorVal = Tiles.myShuffle();
        Color[] nColor = Tiles.myShuffle();
        Color[] mColor = Tiles.myShuffle();
        int pick = 0;

        for (int i = 0; i < BOARD_WIDTH; i++) {
            for (int j = 0; j < BOARD_HEIGHT; j++) {

                Tiles tiles = new Tiles(nColor[pick], colorVal[pick], mColor[pick]);
                tiles.setTranslateX(i * 100);
                tiles.setTranslateY(j * 100);
                root.getChildren().addAll(tiles);
                pick++;
                if (pick >= 10) {
                    pick = 0;
                }
            }
        }
        return root;
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(theGame()));
        primaryStage.setTitle("My Tiles");
        primaryStage.setHeight(750);
        primaryStage.show();


    }
}