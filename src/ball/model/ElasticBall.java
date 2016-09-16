package ball.model;

import ball.Ball;
import ball.behaviour.Behaviour;

public class ElasticBall implements Behaviour {
    public static final int GROWTH_RATE = 2;

    static final int GROW = 1;
    static final int SHRINK = -1;

    private int growthDirection;

    private BallImpl ballState;

    public ElasticBall(int growthDirection) {
        this.growthDirection = growthDirection;
    }

    @Override
    public void update() {
        growthDirection = reverseGrowthDirectionIfNecessary();
        ballState.radius = next();
    }

    @Override
    public void setState(BallImpl ballState) {

        this.ballState = ballState;
    }

    /***********************************************************************************
     *
     * Do not change Elastic ALGORITHM below.
     *
     ***********************************************************************************/

    private int reverseGrowthDirectionIfNecessary() {
        if (growingTooBig() || shrinkingTooSmall()) {
            return switchDirection();
        }

        return this.growthDirection;
    }

    private boolean shrinkingTooSmall() {
        return ballState.radius <= 0 && shrinking();
    }

    private boolean growingTooBig() {
        return ballState.radius >= Ball.DEFAULT_RADIUS && growing();
    }

    private int switchDirection() {
        return growing() ? SHRINK : GROW;
    }

    private int next() {
        return ballState.radius + (GROWTH_RATE * growthDirection);
    }

    private boolean shrinking() {
        return growthDirection == SHRINK;
    }

    private boolean growing() {
        return growthDirection == GROW;
    }
}
