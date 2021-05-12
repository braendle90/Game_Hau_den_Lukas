package at.domnik.games.firstgame;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class Circle implements IActor {


    enum DIRECTION {UP, DOWN, LEFT, RIGHT}

    private float x;
    private float y;
    private float speed;
    private float circleDiameter;

    DIRECTION direction = DIRECTION.DOWN;

    public Circle(float x, float y, float speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.circleDiameter = 50;

    }

    @Override
    public void render(Graphics graphics) {

        graphics.drawOval(x, y, circleDiameter, circleDiameter);

    }

    @Override
    public void update(GameContainer gameContainer, int delta) {

        this.circleDiameter += 1;

        if (this.direction == DIRECTION.DOWN) {

            //  System.out.println("DOWN");
            this.y += (float) delta / speed;

            if (this.y >= 600) {

                //System.out.println("changedirecton");
                this.direction = DIRECTION.UP;


            }
        }


        if (this.direction == DIRECTION.UP) {

            //   System.out.println("UP");
            this.y -= (float) delta / speed;

            if (this.y <= 00) {

                //System.out.println("changedirecton");
                this.direction = DIRECTION.DOWN;

            }
        }


    }


}
