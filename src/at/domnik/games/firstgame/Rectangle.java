package at.domnik.games.firstgame;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class Rectangle implements IActor{

    enum DIRECTION {UP, DOWN, LEFT, RIGHT}

    private float x;
    private float y;
    private float speed;

    DIRECTION direction;




    Rectangle(float x, float y, float speed,DIRECTION direction) {

        this.x = x;
        this.y = y;
        this.speed = speed;
        this.direction = direction;


    }



    public void render(Graphics graphics) {


        graphics.drawRect(this.x, this.y, 100, 100);

    }


    public void update(GameContainer gameContainer, int delta) {


        if (this.direction == DIRECTION.RIGHT) {

            //System.out.println("Right");
            this.x += (float) delta / speed;

            if (this.x >= 500) {

                this.direction = DIRECTION.DOWN;


            }


        }

        if (this.direction == DIRECTION.DOWN) {

          //  System.out.println("DOWN");
            this.y += (float) delta / speed;

            if (this.y >= 500) {

                this.direction = DIRECTION.LEFT;

            }
        }

        if (this.direction == DIRECTION.LEFT) {

           // System.out.println("LEFT");
            this.x -= (float) delta / speed;

            if (this.x <= 50) {

                this.direction = DIRECTION.UP;

            }
        }

        if (this.direction == DIRECTION.UP) {

           // System.out.println("UP");
            this.y -= (float) delta / speed;

            if (this.y <= 50) {

                this.direction = DIRECTION.RIGHT;

            }
        }



    }


}
