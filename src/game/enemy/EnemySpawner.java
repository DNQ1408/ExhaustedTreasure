package game.enemy;

import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;

public class EnemySpawner extends GameObject {
    private FrameCounter frameCounter;
    public EnemySpawner() {
        this.frameCounter = new FrameCounter(100);
    }

    @Override
    public void run() {
        super.run();
        if (frameCounter.run()) {
//            Enemy enemy = GameObjectManager.instance.recycle(Enemy.class);
//            enemy.position.set(new Vector2D(500, 400));
            frameCounter.reset();
        }

    }
}
