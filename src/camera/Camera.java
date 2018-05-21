package camera;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.player.player.Player;

public class Camera extends GameObject{

//    public int width, height;
    public Vector2D position;

    public Camera(Vector2D position) {
        this.position = position;
    }

    @Override
    public void run() {
        super.run();
        Player player = GameObjectManager.instance.findPlayer();
    }

    public Vector2D getAfterCameraPosition(Vector2D position) {
        Vector2D afterCameraPosition = new Vector2D();
        afterCameraPosition.x = position.x - this.position.x;
        afterCameraPosition.y = position.y - this.position.y;
        return afterCameraPosition;
    }
}

