package ball.model;

import ball.Ball;
import ball.behaviour.Behaviour;
import ball.ui.BallWorld;

public class BouncingBall implements Behaviour {
    public static final int MOVEMENT_SPEED = 12;

    static final int DOWN = 1;
    static final int UP = -1;

    private int direction;

    private BallImpl ballState;

    public BouncingBall(int direction) {

        this.direction = direction;
    }

    @Override
    public void update() {
        direction = reverseDirectionIfNecessary();
        ballState.y = move();
    }

    @Override
    public void setState(BallImpl ballState) {
        this.ballState = ballState;
    }

    /***********************************************************************************
     *
     * Do not change Bouncing ALGORITHM below.
     *
     ***********************************************************************************/

    private int reverseDirectionIfNecessary() {
        if (movingTooHigh() || movingTooLow()) {
            return switchDirection();
        }

        return this.direction;
    }

    private boolean movingTooLow() {
        return ballState.y + ballState.radius >= BallWorld.BOX_HEIGHT && movingDown();
    }

    private boolean movingTooHigh() {
        return ballState.y - ballState.radius <= 0 && movingUp();
    }

    private int switchDirection() {
        return movingDown() ? UP : DOWN;
    }

    private int move() {
        return ballState.y + (MOVEMENT_SPEED * direction);
    }

    private boolean movingDown() {
        return direction == DOWN;
    }

    private boolean movingUp() {
        return direction == UP;
    }
}
