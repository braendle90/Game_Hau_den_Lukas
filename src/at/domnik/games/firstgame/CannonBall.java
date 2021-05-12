package at.domnik.games.firstgame;

import at.domnik.games.firstgame.IActor;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class CannonBall implements IActor {

    Image hammer;

    private float x, y;


    public CannonBall(float x, float y) {
        this.x = x + 30;
        this.y = y;
    }

    @Override
    public void render(Graphics graphics) {


        graphics.fillOval(this.x, this.y, 10, 10);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {

        this.y++;

    }
}
