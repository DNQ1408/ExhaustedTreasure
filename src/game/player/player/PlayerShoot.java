package game.player.player;

import base.FrameCounter;
import base.GameObjectManager;
import base.Vector2D;
import game.player.bullet.BulletPlayer;
import input.KeyInput;

import java.awt.event.KeyEvent;

public class PlayerShoot {
    private FrameCounter frameCounter;
    public BulletPlayer bulletPlayer;
    public Vector2D velocitirotate = new Vector2D(0,0);
    public PlayerShoot() {
        this.frameCounter = new FrameCounter(3);
        this.bulletPlayer = new BulletPlayer();
        this.bulletPlayer.velocity = new Vector2D();
    }

    public void run(Player player) {
        if (KeyInput.instance.aPressed) {
            if (frameCounter.run()) {
                System.out.println("acc");
                BulletPlayer bulletPlayer1 = GameObjectManager.instance.recycle(BulletPlayer.class);
                bulletPlayer1.position.set(player.position.x + 50,player.position.y);
                bulletPlayer1.velocity.set(7, 0);
                frameCounter.reset();
            }

        }
        if (KeyInput.instance.aReleased) {
                BulletPlayer bulletPlayer1 = GameObjectManager.instance.recycle(BulletPlayer.class);
                bulletPlayer1.position.set(player.position.x + 50,player.position.y);
                bulletPlayer1.velocity.set(7, 0);
        }

        if (KeyInput.instance.dPressed){
            if (frameCounter.run()) {
                System.out.println("acc");
                BulletPlayer bulletPlayer2 = GameObjectManager.instance.recycle(BulletPlayer.class);
                bulletPlayer2.position.set(player.position.x - 50,player.position.y);
                bulletPlayer2.velocity.set(-7, 0);
                frameCounter.reset();
            }

        }
        if (KeyInput.instance.dReleased){
                System.out.println("acc");
                BulletPlayer bulletPlayer2 = GameObjectManager.instance.recycle(BulletPlayer.class);
                bulletPlayer2.position.set(player.position.x - 50,player.position.y);
                bulletPlayer2.velocity.set(-7, 0);

        }
        if (KeyInput.instance.spacePressed){
            if (frameCounter.run()){
                BulletPlayer bulletPlayer1 = GameObjectManager.instance.recycle(BulletPlayer.class);
                bulletPlayer1.position.set(player.position.x + 50,player.position.y);
               this.velocitirotate.set(0,7);

                BulletPlayer bulletPlayer2 = GameObjectManager.instance.recycle(BulletPlayer.class);
                bulletPlayer2.position.set(player.position.x - 50,player.position.y);
                this.velocitirotate.set(0,-7);
                frameCounter.reset();
            }
        }
        if (KeyInput.instance.spaceReleased){
            this.velocitirotate.set(0,7);
        }
        this.bulletPlayer.velocity.set(this.velocitirotate);

    }
}
