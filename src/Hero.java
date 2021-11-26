import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.geometry.Rectangle2D;

public class Hero extends AnimatedThing {

    protected final int yGround = 150;
    private final double g = 0.7;
    private final double m = 20;
    private int attitude;
    private double v_x, v_y;
    private double a_x, a_y;
    private double f_x, f_y;


    public Hero(double x, double y, int attitude, int a, double duration, int maxa, double sizex, double sizey, int offset, String filename) {
        super(x, y, attitude, a, duration, maxa, sizex, sizey, offset, filename);
        this.attitude = attitude;
    }

    public void jump(){
        if (y>=yGround+sizey){
            f_y +=300;
        }

    }
    public void setForce(double f_x,double f_y){
        this.f_x=f_x;
        this.f_y=0;
    }



    public void updateAttitude() {
        if (v_y>0){
            attitute=Attitude.JUMPING_DOWN;
        }
        else if (v_y<0){
            attitute=Attitude.JUMPING_UP;
        }
        else{
            attitute=Attitude.RUNNING;
        }
    }


    //@Override
    public void update(long t) {
        this.attitude= this.attitude+1;
        super.attitude=this.attitude;
        updateAttitude();
        super.update(t);

        a_x=f_x/m;
        v_x+=a_x;
        x += v_x;

        a_y =(g-(f_y/m));
        v_y += a_y;
        y += v_y;
        
        if (y > yGround + sizey) {
            if (v_y > 0) {
                    v_y = 0;
                }
                y = yGround + sizey;
            }
            setForce(0,0);

        }

    public double getV_y() {
        return v_y;
    }

    public double getA_y() {
        return a_y;
    }
    public double getF_y() {
        return f_y;
    }

    public void updateCollision() {
    }




}


