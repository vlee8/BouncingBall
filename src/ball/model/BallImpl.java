package ball.model;

import ball.Ball;
import ball.behaviour.Behaviour;

import java.awt.*;

public class BallImpl implements Ball {
    protected int x;
    protected int y;
    protected int radius;
    Behaviour[] behaviours;


    protected BallImpl(int x, int y, int radius, Behaviour[] behaviours) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.behaviours = behaviours;

        for (Behaviour behaviour : behaviours) {
            behaviour.setState(this);
        }
    }

    protected BallImpl(int x, int y, Behaviour[] behaviours) {

        this(x, y, DEFAULT_RADIUS, behaviours);
    }

    // DO NOT CHANGE
    @Override
    public int radius() {
        return radius;
    }

    // DO NOT CHANGE
    @Override
    public Point center() {
        return new Point(x, y);
    }

    @Override
    public void update(){
        for (Behaviour behaviour : behaviours) {
            behaviour.update();
        }
    }
}
