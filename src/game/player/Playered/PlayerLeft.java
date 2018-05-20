package game.player.Playered;

import base.GameObject;
import base.Vector2D;
import renderer.ImageRenderer;

public class PlayerLeft extends GameObject {
    public Vector2D velocity;
    public PlayerLeft() {
        this.velocity = new Vector2D();
        this.position.set(500,500);
        this.renderer = new ImageRenderer("resources/images/Player/playL.png",100,50);
    }
    @Override
    public void run(){
        super.run();
        this.position.addUp(this.velocity);
        this.velocity.set(-1,0);
    }

}
