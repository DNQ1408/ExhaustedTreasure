package Scene;

import base.GameObjectManager;
import game.background.Background;
import game.enemy.EnemySpawner;
import game.player.player.Player;

public class GamePlayScene implements Scene {


    @Override
    public void init() {
        GameObjectManager.instance.recycle(Background.class);
        Player player = GameObjectManager.instance.recycle(Player.class);
        player.position.set(500,300);
        GameObjectManager.instance.recycle(EnemySpawner.class);
    }


    @Override
    public void deinit() {
        GameObjectManager.instance.clear();
    }
}
