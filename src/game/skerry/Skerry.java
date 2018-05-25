package game.skerry;

import base.GameObject;
import physic.BoxCollider;
import physic.HitObject;
import physic.PhysicBody;

public class Skerry extends GameObject implements HitObject, PhysicBody {

    public BoxCollider boxCollider;

    public Skerry() {
        this.boxCollider = new BoxCollider(10, 10);
    }

    @Override
    public void run() {
        super.run();
        if (this.boxCollider != null ) {
            this.boxCollider.position.set(this.position);
        }
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
