package game.treasure;

import base.GameObject;
import physic.BoxCollider;
import physic.HitObject;
import physic.PhysicBody;

public class Treasure extends GameObject implements PhysicBody, HitObject {

    public BoxCollider boxCollider;

    @Override
    public void run() {
        super.run();
        this.boxCollider.position.set(this.position);
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
