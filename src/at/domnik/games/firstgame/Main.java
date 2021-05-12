package at.domnik.games.firstgame;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tests.AnimationTest;

public class Main {


    /**
     * Entry point to our test
     *
     * @param argv The arguments to pass into the test
     */
    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new AnimationTest());
            container.setDisplayMode(800,600,false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
