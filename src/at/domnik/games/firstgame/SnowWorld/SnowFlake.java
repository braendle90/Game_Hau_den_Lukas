package at.domnik.games.firstgame.SnowWorld;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import java.util.Random;

public class SnowFlake implements Actor {


    private Image snowflake;

    public enum SIZE {BIG,SMALL,MEDIUM}
    private float x,y;
    private int speed;
    private int size;
    Random random;

    public SnowFlake(SIZE size) throws SlickException {

        Image tmp = new Image("testdata/snowflake slick.png");
        this.snowflake = tmp.getScaledCopy(20, 20);


        random = new Random();


        if (size == SIZE.BIG) {

            this.speed = 8;
            this.size = 2;
            this.snowflake = tmp.getScaledCopy(40, 40);

        }

        if (size == SIZE.MEDIUM) {

            this.speed = 5;
            this.size = 5;
            this.snowflake = tmp.getScaledCopy(20, 20);

        }
        if (size == SIZE.SMALL){


            this.speed = 3;
            this.size = 7;
            this.snowflake = tmp.getScaledCopy(10, 10);


        }

        setRandomPosition();


    }


    public void setRandomPosition(){
        this.x = this.random.nextInt(800);
        this.y = this.random.nextInt(800) - 800;

    }

    @Override

    public void render(Graphics graphics) {


        snowflake.draw(this.x,this.y);
        //graphics.drawOval(this.x, this.y, this.size, this.size);


    }

    @Override
    public void update(int delta) {

        this.y += (float) delta / speed;

        if (this.y > 800){

            setRandomPosition();


        }





    }
}
