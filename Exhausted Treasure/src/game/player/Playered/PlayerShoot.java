package game.player.Playered;

import base.FrameCounter;
import game.player.bullet.BulletPlayer;
import game.player.bullet.Shoot;
import game.player.bullet.ShootTriple;

public class PlayerShoot {
    public boolean isPlayerShoot = false;
    private FrameCounter frameCounter;
    public boolean changShoot =false;
    public Shoot shoot;
    public ShootTriple shootTriple;
    public BulletPlayer.ShootSingle shootSingle;

    public PlayerShoot() {
        this.frameCounter = new FrameCounter(10);
        this.shootSingle= new BulletPlayer.ShootSingle();
        this.shootTriple = new ShootTriple();
        this.shoot = this.shootSingle;
    }

//    public void run(Playered playered) {
//        if (this.isPlayerShoot) {
//            if (this.frameCounter.run()) {
////             this.shootSingle.run(player);
//             //xét thêm boxclloder nữa để chuyển giữa 2 kiểu đạn
//             this.shootTriple.run(playered);
//                this.frameCounter.reset();
//            }
//        } else {
//            this.frameCounter.reset();
//        }
//    }
}
