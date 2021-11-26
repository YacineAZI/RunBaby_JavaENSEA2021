import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.image.ImageView;
import javafx.geometry.Rectangle2D;
import javafx.scene.layout.HBox;


public class Main extends Application {

    public static void main(String[] args) {
    launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Run Baby !");
        primaryStage.getIcons().add(new Image("./img/Logo_ENSEA.png"));
        Group root = new Group();
        Pane pane = new Pane(root);

        GameScene gameScene = new GameScene(pane,800,300);
        primaryStage.setScene(gameScene);
        primaryStage.show();
    }
}
