package at.domnik.games.firstgame;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class Ellipse  implements  IActor{


    enum DIRECTION {UP, DOWN, LEFT, RIGHT}

    private float x;
    private float y;
    private float speed;

    DIRECTION direction = DIRECTION.RIGHT;


    public Ellipse(float x, float y, float speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.direction = direction;
    }

    @Override
    public void render(Graphics graphics) {


        graphics.drawOval(this.x, this.y, 200, 100);



    }

    @Override
    public void update(GameContainer gameContainer, int delta) {



        if (this.direction == DIRECTION.RIGHT) {

            //System.out.println("Right");
            this.x += (float) delta / speed;

            if (this.x >= 500) {
                this.direction = DIRECTION.DOWN;



            }


        }


        if (this.direction == DIRECTION.DOWN) {

           // System.out.println("Right");
            this.x -= (float) delta / speed;

            if (this.x <= 0) {
                this.direction = DIRECTION.RIGHT;



            }


        }


    }
}
