import javafx.animation.AnimationTimer;
import javafx.scene.image.ImageView;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;

abstract public class AnimatedThing {

    public Attitude attitute;
    public double x;
    public double y;
    public int attitude;
    public long a;
    public double duration;
    public int maxa;
    public double sizex;
    public double sizey;
    public int offset;
    public String filename;
    public ImageView imageView;
    public AnimationTimer timer;
    public int  acceleration = 6;

    public AnimatedThing(double x, double y, int attitude, long a, double duration, int maxa, double sizex, double siezy, int offset, String filename) {
        this.x = x;
        this.y = y;
        this.attitude = attitude;
        this.a = a;
        this.duration = duration;
        this.maxa = maxa;
        this.sizex = sizex;
        this.sizey = siezy;
        this.offset = offset;
        this.filename = filename;
        this.imageView = new ImageView(filename);
    }

    public ImageView getImageView() {
        return imageView;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void update(long t) {
        if (attitute == Attitude.JUMPING_UP) {
            this.imageView.setViewport(new Rectangle2D(10, 160, 60, 105));
        } else if (attitute == Attitude.RUNNING) {
            if (attitude % (6*acceleration)== acceleration) {
                this.imageView.setViewport(new Rectangle2D(20, 0, 60, 100));
            } else if (attitude % (6*acceleration) == 2*acceleration) {
                this.imageView.setViewport(new Rectangle2D(95, 0, 70, 100));
            } else if (attitude % (6*acceleration) == 3*acceleration) {
                this.imageView.setViewport(new Rectangle2D(170, 10, 85, 90));
            } else if (attitude % (6*acceleration) == 4*acceleration) {
                this.imageView.setViewport(new Rectangle2D(270, 10, 65, 90));
            } else if (attitude % (6*acceleration) == 5*acceleration) {
                this.imageView.setViewport(new Rectangle2D(345, 0, 70, 100));
            } else if (attitude % (6*acceleration) == 0) {
                this.imageView.setViewport(new Rectangle2D(425, 15, 80, 85));
            }
        }else if(attitute==Attitude.JUMPING_DOWN) {
            this.imageView.setViewport(new Rectangle2D(95, 160, 70, 105));
        }

    }

    public abstract void updateAttitude();

    public abstract void updateCollision();
    public enum Attitude {JUMPING_UP, JUMPING_DOWN, RUNNING}
}


