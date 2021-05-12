package at.domnik.games.firstgame.SnowWorld;
import org.newdawn.slick.Image;
import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;




public class SnowWorld extends BasicGame {



    List<Actor> actors;





    public SnowWorld(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {



        actors = new ArrayList<>();


        Random random = new Random();
        for (int i = 0; i < 20; i++) {

            actors.add( new SnowFlake(SnowFlake.SIZE.BIG));
            actors.add( new SnowFlake(SnowFlake.SIZE.MEDIUM));
            actors.add( new SnowFlake(SnowFlake.SIZE.SMALL));

        }

    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {

        for (Actor actor: actors) {
            actor.update(delta);

        }

    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {


        for (Actor actor:actors) {
            actor.render(graphics);

        }

    }


    public static void main (String[]argv){
        try {
            AppGameContainer container = new AppGameContainer(new SnowWorld("Snow World"));
            container.setDisplayMode(800, 800, false);
            container.setTargetFrameRate(60);
            container.setVSync(true);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }


}
