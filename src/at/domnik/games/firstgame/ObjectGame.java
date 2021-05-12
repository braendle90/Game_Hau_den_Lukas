package at.domnik.games.firstgame;

import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ObjectGame extends BasicGame {


    Rectangle rectangle;



    Hammer hammer;

    List<IActor> actors;

    Rocket rocket;

    enum DIRECTION {UP, DOWN, LEFT, RIGHT}


    private float recY;
    private float recX;

    private float ovalY;
    private float ovalX;

    private float circleX;
    private float circleY;

    private float speed;


    String changeDirectionOval = "RIGHT";
    String changeDirectionCircle = "DOWN";


    DIRECTION directionRectangle = DIRECTION.RIGHT;


    public ObjectGame(String title) {


        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {

        this.actors = new ArrayList<>();

        Hammer hammer = new Hammer(400,400);
        //this.rocket = rocket;
        actors.add(hammer);

        Random random = new Random();


      /*  for (int i = 0 ; i < 5; i++) {

            Rocket rocket = new Rocket(random.nextInt(200));
            this.actors.add(rocket);
            this.hammer.addCollisionPartner(rocket);

        }*/

    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {

        for (IActor actor : actors) {

            actor.update(gameContainer, delta);

        }

        hammer.update(gameContainer,delta);


    }


    //region RENDER METHODE
    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {


        for (IActor actor : actors) {

            actor.render(graphics);

        }

        hammer.render(graphics);





    }
    //endregion


    @Override
    public void keyPressed(int key, char c) {
        if (key == Input.KEY_SPACE) {
            System.out.println("shoot");



        }
    }

 /*   @Override
    public void mouseClicked(int button, int x, int y, int clickCount) {
        super.mouseClicked(button, x, y, clickCount);

        System.out.println("X: " + x + "Y: " + y);
        hammer.setX(x);
        hammer.setY(y);
        hammer.setRotation(45);

    }*/

    @Override
    public void mouseReleased(int button, int x, int y) {
        super.mouseReleased(button, x, y);
        System.out.println("Relesed");

        hammer.mouseClickedAndImage(x,y,false);
    }

    @Override
    public void mousePressed(int button, int x, int y) {
        super.mousePressed(button, x, y);
        System.out.println("Pressed");


        hammer.mouseClickedAndImage(x,y,true);



    }


    /**
     * Entry point to our test
     *
     * @param argv The arguments to pass into the test
     */
    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new ObjectGame("My First Game"));
            container.setDisplayMode(800, 800, false);
            container.setTargetFrameRate(60);

            container.setVSync(true);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }


    /*    public void ChangeDirectionOval ( int delta){

            if (changeDirectionOval.contains("LEFT")) {

                this.ovalX -= (float) delta / speed;
                System.out.println("LINKS");

                if (this.ovalX <= 50) {
                    changeDirectionOval = "RIGHT";

                }

            }

            if (changeDirectionOval.contains("RIGHT")) {
                this.ovalX += (float) delta / speed;

                System.out.println("RECHTS");
                if (this.ovalX >= 600) {
                    changeDirectionOval = "LEFT";


                }
            }

        }*/

       /* public void ChangeDirectionCircle ( int delta){
            if (changeDirectionCircle.contains("DOWN")) {

                System.out.println("DOWN");
                this.circleY += (float) delta / speed;

                if (this.circleY >= 600) {

                    System.out.println("changedirecton");
                    changeDirectionCircle = "UP";

                }
            }



            if (changeDirectionCircle.contains("UP")) {

                System.out.println("UP");
                this.circleY -= (float) delta / speed;

                if (this.circleY <= 00) {

                    System.out.println("changedirecton");
                    changeDirectionCircle = "DOWN";

                }
            }


        }*/


}
