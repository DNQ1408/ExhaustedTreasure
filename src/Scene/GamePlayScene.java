package Scene;

import base.GameObjectManager;
import game.background.Background;
import game.enemy.BulletEnemy;
import game.enemy.Enemy;
import game.enemy.EnemySpawner;
import game.player.player.Player;
import game.skerry.SkerryShow;
import game.treasure.Treasure;
import game.treasure.TreasureShow;
import renderer.ImageRenderer;

public class GamePlayScene implements Scene {

    @Override
    public void init() {
        GameObjectManager.instance.recycle(Background.class);
        Player player = GameObjectManager.instance.recycle(Player.class);
        player.position.set(500,300);
        GameObjectManager.instance.recycle(EnemySpawner.class);
        GameObjectManager.instance.recycle(Enemy.class);

        SkerryShow skerryShow = new SkerryShow();
        TreasureShow treasureShow = new TreasureShow();

    }


    @Override
    public void deinit() {
        GameObjectManager.instance.clear();
    }
}
