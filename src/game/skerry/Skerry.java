package game.skerry;

import base.GameObject;
import physic.BoxCollider;
import physic.HitObject;
import physic.PhysicBody;

public class Skerry extends GameObject implements PhysicBody, HitObject {

    public BoxCollider boxCollider;

    @Override
    public void run() {
        super.run();
        this.boxCollider.position.set(this.position);
    }

    @Override
    public void getHit(GameObject gameObject) {

    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
