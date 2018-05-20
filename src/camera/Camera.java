package camera;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.player.player.Player;

public class Camera extends GameObject{

    public Vector2D CameraPosition;
    public int width, height;


    public Camera(int width, int height) {
        Player player = GameObjectManager.instance.findPlayer();
        CameraPosition = player.position;
        this.width = width;
        this.height = height;
    }

    @Override
    public void run() {
        super.run();

    }
}
