package at.domnik.games.firstgame.HauDenLukas;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class Holes implements Actor {


    int x, y;

    public Holes(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {

    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) {

        graphics.setColor(Color.black);
        graphics.fillOval(this.x,this.y,100,100);



    }
}
