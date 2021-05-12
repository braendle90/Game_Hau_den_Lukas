package at.domnik.games.firstgame.HauDenLukas;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

import java.util.ArrayList;
import java.util.List;

public class Hammer implements Actor, CollisonShape{


    private int points = 0;



    private Head head;
    private List<CollisonShape> collisonShapes;
    private List<Head> headList;
    private boolean visibility = false;
    Image hammer;
    Image hammer2;
    private float x, y;

    Shape collisonShape;

    public Hammer(float x, float y) throws SlickException {
        this.x = x;
        this.y = y;

        this.collisonShapes = new ArrayList<CollisonShape>();
        this.headList = new ArrayList<>();


        this.collisonShape = new Rectangle(this.x, this.y, 40, 60);

        Image img = new Image("/Users/dominik/IdeaProjects/Games/testdata/hammerB.png");

        this.hammer = img.getScaledCopy(70, 70);
        this.hammer2 = img.getScaledCopy(70, 70);
        this.hammer2.rotate(45);


    }




    public void mouseClickedAndImage(int x, int y, boolean visibility) {

        this.x = x;
        this.y = y;
        this.visibility = visibility;
        int indexOfHead = 0;

        for (CollisonShape shape : collisonShapes) {


            if (this.collisonShape.intersects(shape.getShape())) {
                System.out.println("Zusammenstoss");

                points++;
                System.out.println("Points: "+points);
                headList.get(indexOfHead).deleteHead();

            }
            indexOfHead++;

            
        }


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

        this.collisonShape.setCenterX(this.x);
        this.collisonShape.setCenterY(this.y);




    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) {


        if (visibility == false) {
            hammer.drawCentered(this.x, this.y);

        }
        if (visibility == true) {
            //hammer2.draw(this.x, this.y);

            hammer2.drawCentered(this.x, this.y);

        }


        graphics.setColor(Color.red);
        graphics.draw(this.collisonShape);
        graphics.setColor(Color.white);

    }

    public void addCollisionPartner(Head head) {
        collisonShapes.add(head);

    }
    public void addHead(Head head) {
        this.headList.add(head);

    }

    public Shape getCollisonShape() {
        return collisonShape;
    }


    @Override
    public Shape getShape() {
        return collisonShape;
    }


}
