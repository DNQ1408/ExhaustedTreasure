package game.enemy;

import base.GameObject;
import base.Vector2D;
import physic.BoxCollider;
import physic.PhysicBody;
import renderer.ImageRenderer;

public class Enemy extends GameObject implements PhysicBody{

    private Vector2D velocity;
    public BoxCollider boxCollider;

    public Enemy() {
        this.renderer = new ImageRenderer("resources/images/Enemy/ship_(2).png", 50,70);
        this.velocity = new Vector2D(0,0);
        this.boxCollider = new BoxCollider(50,70);
    }

    @Override
    public void run() {
        super.run();
        this.boxCollider.position.set(this.position);
//        System.out.println("Enemy running");
    }

    @Override
    public BoxCollider getBoxCollider() {
        return null;
    }
}
