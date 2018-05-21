package Scene;

import base.GameObject;
import base.GameObjectManager;
import camera.Camera;
import game.background.Background;
import game.enemy.EnemySpawner;
import game.player.player.Player;

public class GamePlayScene implements Scene {


    @Override
    public void init() {
        GameObjectManager.instance.recycle(Background.class);
//        Camera camera = GameObjectManager.instance.recycle(Camera.class);
//        camera.position.set(300,200);
        Player player = GameObjectManager.instance.recycle(Player.class);
        player.position.set(500,300);
        GameObjectManager.instance.recycle(EnemySpawner.class);
//        GameObjectManager.instance.recycle(PlayerLeft.class);
//        GameObjectManager.instance.recycle(PlayerDow.class);


    }


    @Override
    public void deinit() {
        GameObjectManager.instance.clear();
    }
}
