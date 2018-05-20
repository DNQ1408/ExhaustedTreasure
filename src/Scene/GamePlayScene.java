package Scene;

import base.GameObjectManager;
import game.background.Background;
import game.enemy.EnemySpawner;
import game.player.Playered.Playered;

public class GamePlayScene implements Scene {


    @Override
    public void init() {
        GameObjectManager.instance.recycle(Background.class);
        GameObjectManager.instance.recycle(Playered.class);
        GameObjectManager.instance.recycle(EnemySpawner.class);
//        GameObjectManager.instance.recycle(PlayerLeft.class);
//        GameObjectManager.instance.recycle(PlayerDow.class);


    }


    @Override
    public void deinit() {
        GameObjectManager.instance.clear();
    }
}
