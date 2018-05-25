package game.treasure;

import base.GameObject;
import base.GameObjectManager;
import physic.BoxCollider;
import physic.HitObject;
import physic.PhysicBody;
import renderer.ImageRenderer;

public class Treasure extends GameObject implements HitObject, PhysicBody {

    public BoxCollider boxCollider;

    public Treasure() {
        this.boxCollider = new BoxCollider(10, 10);
    }

    @Override
    public void run() {
        super.run();
        if (this.boxCollider != null){
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
