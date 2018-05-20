package game.player.bullet;

import base.FrameCounter;
import base.GameObjectManager;
import game.player.player.Player;

public class ShootTriple implements Shoot {
    public BulletPlayer.ShootSingle shootSingle;
    public boolean isA = false;
    public FrameCounter frameCounter;
    public ShootTriple() {
        this.frameCounter = new FrameCounter(10);
        shootSingle = new BulletPlayer.ShootSingle();
    }

    public void run(Player player) {
        if (frameCounter.run()) {
            if (isA == true) {
                BulletPlayer bulletPlayer1 = GameObjectManager.instance.recycle(BulletPlayer.class);
                bulletPlayer1.position.set(player.position);
                bulletPlayer1.velocity.set(5, 0);

                BulletPlayer bulletPlayer2 = GameObjectManager.instance.recycle(BulletPlayer.class);
                bulletPlayer2.position.set(player.position);
                bulletPlayer2.velocity.set(-5,0);
            }
            frameCounter.reset();
        }



    }
}
