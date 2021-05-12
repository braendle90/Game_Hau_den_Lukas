package at.domnik.games.firstgame;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;
import java.util.ArrayList;
import java.util.List;

public class Hammer implements IActor{


    private float x, y;
    private int rotaion = 0;
    Image hammer;
    Image hammer2;
    private boolean visibility = false;

    private List<Rocket> rockets;

    Shape collisionShape;


    public Hammer(float x, float y) throws SlickException {
        this.x = x;
        this.y = y;

        Image img = new Image("testdata/hammer.png");


        this.hammer = img.getScaledCopy(70, 70);
        this.hammer2 = img.getScaledCopy(70, 70);

        this.hammer2.rotate(45);

        this.collisionShape = new Circle(this.x, this.y-5, 45);

        this.rockets = new ArrayList<>();


    }

    public void mouseClickedAndImage(int x, int y, boolean visibility) {

        this.x = x;
        this.y = y;
        this.visibility = visibility;


    }


    public void render(Graphics graphics) {



       // graphics.draw(this.collisionShape);

        if (visibility == false) {
            hammer.drawCentered(this.x, this.y);

        }
        if (visibility == true) {
            //hammer2.draw(this.x, this.y);

            hammer2.drawCentered(this.x, this.y);

        }

    }


    public void update(GameContainer gameContainer, int delta) {

        this.y = y;
        this.x = x;
/*

        this.collisionShape.setCenterX(this.x);
        this.collisionShape.setCenterY(this.y);
*/


    }


    public void addCollisionPartner(Rocket rocket){

        this.rockets.add(rocket);

    }
}
