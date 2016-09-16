package ball.behaviour;

import ball.model.BallImpl;

public interface Behaviour {

    void update();
    void setState(BallImpl ballState);

}
