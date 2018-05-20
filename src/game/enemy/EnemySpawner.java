package game.enemy;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;

public class EnemySpawner extends GameObject {

    @Override
    public void run() {
        super.run();
        Enemy enemy = GameObjectManager.instance.recycle(Enemy.class);
        enemy.position.set(new Vector2D(800, 400));

    }
}
