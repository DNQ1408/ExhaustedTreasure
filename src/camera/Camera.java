package camera;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.player.player.Player;
import physic.BoxCollider;
import physic.HitObject;
import physic.PhysicBody;

public class Camera extends GameObject {

    public int width, height;


    public Camera(Vector2D position) {
        this.position = position;
        this.width = 1024;
        this.height = 600;
    }

    @Override
    public void run() {
        super.run();
        Player player = GameObjectManager.instance.findPlayer();
    }

    public Vector2D getCameraPo() {
        return this.position;
    }
}

