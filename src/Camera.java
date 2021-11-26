public class Camera {
    private final double k = 1;
    private final double m = 20;
    private final double f = 10;
    private int x;
    private int y;
    private int xback;
    private int yback;
    private double vx, vy;
    private double ax, ay;

    public Camera(int x, int y) {
        this.x = x;
        this.y = y;
        this.xback =x;
        this.yback =y;
    }

    public double getX() {
        return this.x;
    }
    public double getXback() {
        return this.xback;
    }
    public double getYback() {
        return this.yback;
    }

    public double getY() {return this.y; }

    @Override
    public String toString() {
        return " " + x + " ; " + y + " ";
    }

    public void update(long time, Hero hero) {
        this.xback = this.xback + 3;


        double x_hero=hero.getX();
        double y_hero=hero.getY();

        double c1=k/m;
        double c2=f/m;

        ax=c1*(x_hero-x)-c2*vx;
        vx+=ax;
        x+=vx;

        /*
        ay=c1*(y_hero-250-y)-c2*vy;

        vy+=ay;
        y+=vy;
        */

    }

}
