package Scene;

import base.GameObjectManager;
import game.background.Background;
import game.enemy.BulletEnemy;
import game.enemy.Enemy;
import game.enemy.EnemySpawner;
import game.player.player.Player;
import game.skerry.SkerryShow;

public class GamePlayScene implements Scene {

    @Override
    public void init() {
        GameObjectManager.instance.recycle(Background.class);
        Player player = GameObjectManager.instance.recycle(Player.class);
        player.position.set(500,300);
        GameObjectManager.instance.recycle(EnemySpawner.class);
        GameObjectManager.instance.recycle(Enemy.class);
        SkerryShow skerryShow = new SkerryShow();
    }


    @Override
    public void deinit() {
        GameObjectManager.instance.clear();
    }
}
