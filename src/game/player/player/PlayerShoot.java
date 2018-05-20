package game.player.player;

import base.FrameCounter;
import base.GameObjectManager;
import game.player.bullet.BulletPlayer;
import input.KeyInput;

import java.awt.event.KeyEvent;

public class PlayerShoot {
    private FrameCounter frameCounter;



    public PlayerShoot() {
        this.frameCounter = new FrameCounter(10);
    }

    public void run(Player player){
        if (KeyInput.instance.getKeyPressed(KeyEvent.VK_SPACE)) {

            if (frameCounter.run()) {
                System.out.println("acc");
                BulletPlayer bulletPlayer1 = GameObjectManager.instance.recycle(BulletPlayer.class);
                bulletPlayer1.position.set(player.position);
                bulletPlayer1.velocity.set(5, 0);

                BulletPlayer bulletPlayer2 = GameObjectManager.instance.recycle(BulletPlayer.class);
                bulletPlayer2.position.set(player.position);
                bulletPlayer2.velocity.set(-5, 0);
                frameCounter.reset();
            }
        }

    }
}
