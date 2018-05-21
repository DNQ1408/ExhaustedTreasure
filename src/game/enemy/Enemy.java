package game.enemy;

import base.GameObject;
import base.Vector2D;
import physic.BoxCollider;
import physic.HitObject;
import physic.PhysicBody;
import renderer.ImageRenderer;

public class Enemy extends GameObject implements PhysicBody, HitObject {

    public EnemyMove enemyMove;
    public BoxCollider boxCollider;

    public Enemy() {
        this.enemyMove = new EnemyMove();
        this.renderer = new ImageRenderer("resources/images/Enemy/ship_(2).png", 50,70);
        this.boxCollider = new BoxCollider(50,70);
    }

    @Override
    public void run() {
        super.run();
        this.enemyMove.run(this);
        this.boxCollider.position.set(this.position);
//        System.out.println("Enemy running");
    }

    @Override
    public BoxCollider getBoxCollider() {
        return null;
    }

    @Override
    public void getHit(GameObject gameObject) {
        this.isAlive = false;
    }
}
