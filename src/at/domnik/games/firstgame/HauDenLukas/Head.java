package at.domnik.games.firstgame.HauDenLukas;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class Head implements Actor,CollisonShape {

    private int leben = 1;


    Shape collisonShape;
    Image head;
    Hammer hammer;
    private float x, y;
    private boolean visibility = true;
    private int time = 100;


    public Head(float x, float y) throws SlickException {


        Image img = new Image("/Users/dominik/IdeaProjects/Games/testdata/head Kopie.png");
        this.head = img;


        this.x = x;
        this.y = y;
        this.collisonShape = new Rectangle(this.x, this.y, 100, 90);
    }

    public void deleteHead() {

        this.x -= 1200;
        this.y -= 1200;

    }

    public void showHead() {

        if (this.x < 0) {
            System.out.println("SHOW HEAAAAAD:" + time);

            this.x += 1200;
            this.y += 1200;

        }

    }

    @Override
    public void update(GameContainer gameContainer, int delta) {

        time += delta;


        this.collisonShape.setCenterX(this.x);
        this.collisonShape.setCenterY(this.y);

        if (this.y > 800) {

            this.y = 0;
        }


    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) {


        if (visibility == true) {

            graphics.draw(this.collisonShape);
            this.head.drawCentered(this.x, this.y);


        }


        //graphics.setColor(Color.red);
        //this.head.drawCentered(this.x, this.y);


        graphics.setColor(Color.white);

    }




    public void addCollisionPartner(Hammer hammer) {
        this.hammer = hammer;
    }


    @Override
    public Shape getShape() {
        return collisonShape;
    }

}
