package game.player.Playered;

import base.GameObject;
import base.Vector2D;
import renderer.ImageRenderer;

public class PlayerDow extends GameObject {
    public Vector2D velocity;
    public PlayerDow() {
        this.velocity = new Vector2D();
        this.position.set(10,60);
        this.renderer = new ImageRenderer("resources/images/Player/playDow.png",50,100);
    }
    @Override
    public void run(){
        super.run();
        this.position.addUp(this.velocity);
        this.velocity.set(0,-1);
    }
}
