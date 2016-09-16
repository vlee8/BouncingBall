package ball.model;

import ball.Ball;
import ball.behaviour.Behaviour;

public class BallFactory {

    public static Ball[] all(){
        return new Ball[]{
                bouncingBall(75, 50, Ball.DEFAULT_RADIUS, BouncingBall.DOWN),
                elasticBall(250, 100, Ball.DEFAULT_RADIUS, ElasticBall.SHRINK),
                bouncingElasticBall(400, 150, Ball.DEFAULT_RADIUS, ElasticBall.SHRINK, BouncingBall.UP)
        };
    }

    public static Ball bouncingBall(int centerX, int centerY, int radius, int direction) {
        BouncingBall bounce = new BouncingBall(direction);
        return new BallImpl(centerX, centerY, radius, new Behaviour[] { bounce });
    }

    public static Ball elasticBall(int centerX, int centerY, int radius, int direction) {
        ElasticBall elastic = new ElasticBall(direction);
        return new BallImpl(centerX, centerY, radius, new Behaviour[] { elastic });
    }

    public static Ball bouncingElasticBall(int centerX, int centerY, int radius, int direction, int bounceDirection) {
        BouncingBall bounce = new BouncingBall(direction);
        ElasticBall elastic = new ElasticBall(bounceDirection);
        return new BallImpl(centerX, centerY, radius, new Behaviour[]{ bounce, elastic });
    }
}
