package game.player.bullet;

import base.GameObject;
import base.Vector2D;
import physic.BoxCollider;
import physic.HitObject;
import physic.PhysicBody;
import physic.RunHitObject;
import renderer.ImageRenderer;

import java.awt.*;

public class BulletPlayer extends GameObject implements PhysicBody, HitObject {

    public Vector2D velocity;
    public BoxCollider boxCollider;
    private RunHitObject runHitObject;

    // constructor
    public BulletPlayer() {
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/images/Bullet/BulletEnerMy.png", 10, 10);
        this.boxCollider = new BoxCollider(5, 5);
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

    public static class ShootSingle implements Shoot {
    //    @Override
    //    public void run(Player player) {
    //        BulletPlayer bulletPlayer = GameObjectManager.instance.recycle(BulletPlayer.class);
    //        bulletPlayer.position.set(player.position);
    //        Vector2D vector2D = new Vector2D(7, 0);
    //        Vector2D rotate = vector2D.rotate(player.playerMove.angle);
    //        bulletPlayer.velocity.set(rotate);
    //    }
    }
}
