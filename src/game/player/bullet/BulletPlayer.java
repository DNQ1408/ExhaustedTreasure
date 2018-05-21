package game.player.bullet;

import base.GameObject;
import base.Vector2D;
import physic.BoxCollider;
import physic.HitObject;
import physic.PhysicBody;
import physic.RunHitObject;
import renderer.CurrentAnimationRenderer;
import renderer.ImageRenderer;

import java.awt.*;

public class BulletPlayer extends GameObject implements PhysicBody, HitObject {

    public Vector2D velocity;
    public BoxCollider boxCollider;
    private RunHitObject runHitObject;
    public CurrentAnimationRenderer currentAnimationRenderer;

    // constructor
    public BulletPlayer() {
        this.velocity = new Vector2D();
        this.currentAnimationRenderer = new CurrentAnimationRenderer(3,"resources/images/Bullet/BulletEnerMy.png",
                "resources/images/Bullet/BulletWhile.png",
                "resources/images/Bullet/BulletEnerMy.png",
                "resources/images/Bullet/BulletWhile.png");
        this.renderer = this.currentAnimationRenderer;
//        this.renderer = new ImageRenderer("resources/images/Bullet/BulletEnerMy.png", 10, 10);
        this.boxCollider = new BoxCollider(10, 10);
        this.runHitObject = new RunHitObject(
//                Enemy.class
        );
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        this.boxCollider.position.set(this.position);
        this.runHitObject.run(this);
    }

    @Override
    public void getHit(GameObject gameObject) {
        this.isAlive = false;
    }


    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

}
