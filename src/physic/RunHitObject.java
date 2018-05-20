package physic;

import base.GameObject;
import base.GameObjectManager;

import java.util.Arrays;
import java.util.List;

public class RunHitObject<B extends GameObject & PhysicBody & HitObject> {

    private List<Class<B>> list;

    public RunHitObject(Class<B>... list) {
        this.list = Arrays.asList(list);
    }

    public <A extends GameObject & PhysicBody & HitObject> void run(A gameObject) {
        this.list
                .stream()
                .map(cls -> GameObjectManager.instance.checkCollision(gameObject.getBoxCollider(), cls))
                .filter(object -> object != null)
                .forEach(object -> {
                    object.getHit(gameObject);
                    gameObject.getHit(object);

                });
    }
}
