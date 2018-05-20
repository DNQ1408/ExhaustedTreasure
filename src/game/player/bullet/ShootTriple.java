package game.player.bullet;

import base.FrameCounter;
import base.GameObjectManager;
import base.Vector2D;
import game.player.Playered.Playered;
import game.player.bullet.BulletPlayer;
import game.player.bullet.Shoot;

public class ShootTriple implements Shoot {
    public BulletPlayer.ShootSingle shootSingle;
    public boolean isA = false;
    public FrameCounter frameCounter;
    public ShootTriple() {
        this.frameCounter = new FrameCounter(10);
        shootSingle = new BulletPlayer.ShootSingle();
    }

    public void run(Playered playered) {
        if (frameCounter.run()) {
            if (isA == true) {
                BulletPlayer bulletPlayer1 = GameObjectManager.instance.recycle(BulletPlayer.class);
                bulletPlayer1.position.set(playered.position);
                bulletPlayer1.velocity.set(5, 0);

                BulletPlayer bulletPlayer2 = GameObjectManager.instance.recycle(BulletPlayer.class);
                bulletPlayer2.position.set(playered.position);
                bulletPlayer2.velocity.set(-5,0);
            }
            frameCounter.reset();
        }



    }
}
