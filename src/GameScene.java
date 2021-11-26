import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.image.ImageView;
import javafx.animation.AnimationTimer;

public class GameScene extends Scene {
    private static staticThing heart1;
    private static staticThing heart2;
    private static staticThing heart3;
    public staticThing staticThingLeft;
    public staticThing staticThingRight;
    public Hero hero;
    public staticThing obstacle;
    public AnimationTimer timer;
    private Camera camera;


    public GameScene(Pane pane, double x, double y) {
        super(pane, x, y);
        this.staticThingLeft = new staticThing("img/desert.png", 0, 0);
        pane.getChildren().add(staticThingLeft.getImageView());
        this.staticThingRight = new staticThing("img/desert.png", 800 - getX() % 800, 0);
        pane.getChildren().add(staticThingRight.getImageView());


        this.hero = new Hero(100, 250, 1, 0, 100000000, 6, 75, 100, 10, "img/heros.png");
        hero.getImageView().setViewport(new Rectangle2D(20, 0, 60, 100));

        pane.getChildren().add(hero.getImageView());

        this.camera = new Camera(100, 0);

        this.obstacle = new staticThing("./img/cactusbis2.png", 800 - getX() % 800, 0);
        pane.getChildren().add(obstacle.getImageView());


        // Affichage nombre de vies //

        String HeartFileName = "./img/heart.png";

        //Vie 1
        this.heart1 = new staticThing(HeartFileName, 0, 0);
        heart1.getImageView().setX(730);
        heart1.getImageView().setY(20);
        pane.getChildren().add(heart1.getImageView());

        //Vie 2
        this.heart2 = new staticThing(HeartFileName, 0, 0);
        heart2.getImageView().setX(690);
        heart2.getImageView().setY(20);
        pane.getChildren().add(heart2.getImageView());

        //Vie 3
        this.heart3 = new staticThing(HeartFileName, 0, 0);
        heart3.getImageView().setX(650);
        heart3.getImageView().setY(20);
        pane.getChildren().add(heart3.getImageView());

        AnimationTimer timer = new AnimationTimer() {
            public void handle(long time) {
                camera.update(time, hero);
                hero.update(time);
                staticThingLeft.getImageView().setViewport(new Rectangle2D(camera.getXback() % 800, 0, 800, 400));
                staticThingLeft.getImageView().setX(staticThingLeft.getX());
                staticThingLeft.getImageView().setY(-camera.getY());
                staticThingRight.getImageView().setViewport(new Rectangle2D(0, 0, 800, 400));
                staticThingRight.getImageView().setX((800 - camera.getXback() % 800));
                staticThingRight.getImageView().setY(-camera.getY());


                obstacle.getImageView().setViewport(new Rectangle2D(0, 0, 150, 105));
                obstacle.getImageView().setX(800 - camera.getXback() % 800);
                obstacle.getImageView().setY(-camera.getY() + 245);

                hero.getImageView().setX(hero.getX() - camera.getX());

                hero.getImageView().setX(50);
                hero.getImageView().setY(hero.getY());

                setOnKeyPressed((event) -> {
                    switch (event.getCode()) {
                        case SPACE -> {
                            System.out.println("Jump");
                            hero.jump();
                            System.out.println("a_y=" + hero.getA_y());
                            System.out.println("v_y=" + hero.getV_y());
                            System.out.println("y=" + hero.getY());
                            System.out.println("f_y=" + hero.getF_y());
                            break;

                        }
                    }
                });
                //GameScene.update(time);
            }
        };
        timer.start();
    }
}

