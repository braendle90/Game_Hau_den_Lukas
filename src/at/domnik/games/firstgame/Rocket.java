package at.domnik.games.firstgame;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Rocket implements IActor {

    private float x, y;
    private double speed;
    private int size;
    private Image rocket;
    private Random random;





    private Shape collisionShape;


    public Rocket(int size) throws SlickException {

        random = new Random();
        this.speed = 6;

        Image img = new Image("testdata/rocket.png");
        //img.setRotation(90);

        Image flipped = img.getFlippedCopy(false, true);

        this.x = 100;
        this.y = 100;

        this.rocket = flipped.getScaledCopy(70, 70);

       // this.collisionShape = new Rectangle(this.x, this.y, 50, 70);


    }

    @Override

    public void render(Graphics graphics) {

        this.rocket.draw(this.x, this.y);
       // graphics.draw(this.collisionShape);

    }


    public void setRandomPosition() {
        this.x = this.random.nextInt(800);
        this.y = this.random.nextInt(800) - 800;
        this.size = this.random.nextInt(50);

    }


    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {


        if (gameContainer.getInput().isKeyDown(Input.KEY_LEFT)) {
            this.x -= 10;


        }


        if (gameContainer.getInput().isKeyDown(Input.KEY_RIGHT)) {
            this.x += 10;


        }


        if (gameContainer.getInput().isKeyDown(Input.KEY_UP)) {
            this.y -= 10;


        }


        if (gameContainer.getInput().isKeyDown(Input.KEY_DOWN)) {
            this.y += 10;


        }

     /*   this.collisionShape.setX(this.x + 10);
        this.collisionShape.setY(this.y);

*/
        if (this.y > 800) {
            this.y = 0;
        }


    }


}
