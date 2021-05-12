package at.domnik.games.firstgame.HauDenLukas;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public interface Actor {


    public void update(GameContainer gameContainer, int delta);

    public void render(GameContainer gameContainer, Graphics graphics);
}
