package game.enemy;

import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;

import java.util.Random;

public class EnemySpawner extends GameObject {

    public Random random = new Random();
    private FrameCounter frameCounter = new FrameCounter(300);

    @Override
    public void run() {
        super.run();
        if (this.frameCounter.run()){
            Enemy enemy = GameObjectManager.instance.recycle(Enemy.class);
            enemy.position.set(new Vector2D(this.random.nextInt(1000), this.random.nextInt(400)));
            this.frameCounter.reset();
        }

    }
}
