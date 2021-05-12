package at.domnik.games.firstgame;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public interface IActor {

        void render(Graphics graphics);
        void update(GameContainer gameContainer,   int delta);


}
