package at.domnik.games.firstgame.HauDenLukas;

import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ObjectGame extends BasicGame {

    Image land;
    private List<Actor> actors;
    private List<Head> heads;
    Head head;
    Head actualHead;
    Hammer hammer;
    Holes hole;
    private int time = 100;



    public ObjectGame(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {

        land = new Image("/Users/dominik/IdeaProjects/Games/testdata/bg.jpg");

        actors = new ArrayList<>();
        heads = new ArrayList<>();


        Random random = new Random();

        Hammer hammer = new Hammer(400, 400);
        this.hammer = hammer;
        actors.add(hammer);




        for (int i = 100; i < 800; i += 200) {


            for (int j = 100; j < 450; j += 200) {


                hole = new Holes(i, j);
                actors.add(hole);



                Head htest = new Head(i, j);
                heads.add(htest);
                hammer.addCollisionPartner(htest);
                hammer.addHead(htest);




            }


        }

        for (Head h:heads) {

            h.addCollisionPartner(hammer);

        }



        actualHead = heads.get(0);





        // head.addCollisionPartner(hammer);

        // Collision Partner für den Hammer mit den collision "head"




    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {

        time += delta;

        if (time >= 2000) {
            System.out.println("TIme:"+time);
            changePositionHead();

            time = 0;

        }








        for (Actor actor : actors) {

            actor.update(gameContainer, delta);

        }

        actualHead.update(gameContainer,delta);


    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {

        graphics.drawImage(land, 0, 0);

        for (Actor actor : actors
        ) {

            actor.render(gameContainer, graphics);

        }

        actualHead.render(gameContainer,graphics);
    }


    @Override
    public void mouseReleased(int button, int x, int y) {
        super.mouseReleased(button, x, y);


        hammer.mouseClickedAndImage(x, y, false);
        //head.mouseClickedAndImage(x, y, false);



    }

    @Override
    public void mousePressed(int button, int x, int y) {
        super.mousePressed(button, x, y);


       hammer.mouseClickedAndImage(x, y, true );






       //head.mouseClickedAndImage(x, y, false);


    }

    public void changePositionHead()
    {
        Random ran = new Random();
        int number = ran.nextInt(8);
        System.out.println("Number rand: "+number);
        actualHead.showHead();
        actualHead = heads.get(number);




    }

    /**
     * Entry point to our test
     *
     * @param argv The arguments to pass into the test
     */
    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new at.domnik.games.firstgame.HauDenLukas.ObjectGame("Hau den Lukas"));
            container.setDisplayMode(800, 445, false);
            container.setTargetFrameRate(60);

            container.setVSync(true);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
