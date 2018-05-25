package game.player.player;

import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.player.bullet.BulletPlayer;
import game.skerry.Skerry;
import game.treasure.Treasure;
import input.KeyInput;
import physic.BoxCollider;
import physic.HitObject;
import physic.PhysicBody;
import physic.RunHitObject;
import renderer.*;

import java.awt.event.KeyEvent;

public class Player extends GameObject implements PhysicBody, HitObject {
    public Vector2D defaulvelocity = new Vector2D();
    public Vector2D velocitirotateL = new Vector2D(7,0);
    public Vector2D velocitirotateR = new Vector2D(-7,0);
    public CurrentAnimationRenderer currentAnimationRenderer;
    public Vector2D velocity;
    public ImageRenderer imageRenderer;
    public BulletPlayer bulletPlayer;
    public FrameCounter frameCounter;
    public BoxCollider boxCollider;
    public RunHitObject runHitObject;

    public Player() {
        this.imageRenderer = new ImageRenderer("resources/images/Player/ship (4)-1.png");
        this.renderer = this.imageRenderer;
        this.frameCounter = new FrameCounter(3);
        this.bulletPlayer = new BulletPlayer();
        this.velocity = new Vector2D();
        this.currentAnimationRenderer = new CurrentAnimationRenderer(0, "resources/images/Player/ship (4)-1.png"
                , "resources/images/Player/ship (4)-20.png"
                , "resources/images/Player/ship (4)-19.png"
                , "resources/images/Player/ship (4)-18.png"
                , "resources/images/Player/ship (4)-17.png"
                , "resources/images/Player/ship (4)-16.png"
                , "resources/images/Player/ship (4)-15.png"
                , "resources/images/Player/ship (4)-14.png"
                , "resources/images/Player/ship (4)-13.png"
                , "resources/images/Player/ship (4)-12.png"
                , "resources/images/Player/ship (4)-11.png"
                , "resources/images/Player/ship (4)-10.png"
                , "resources/images/Player/ship (4)-9.png"
                , "resources/images/Player/ship (4)-8.png"
                , "resources/images/Player/ship (4)-7.png"
                , "resources/images/Player/ship (4)-6.png"
                , "resources/images/Player/ship (4)-5.png"
                , "resources/images/Player/ship (4)-4.png"
                , "resources/images/Player/ship (4)-3.png"
                , "resources/images/Player/ship (4)-2.png"

        );
        this.renderer = this.currentAnimationRenderer;
        this.runHitObject = new RunHitObject(
                Skerry.class,
                Treasure.class
        );
        this.boxCollider = new BoxCollider(50, 50);
    }


    @Override
    public void run() {
        super.run();
        if (KeyInput.instance.leftPressed) {
            this.currentAnimationRenderer.checkLeft(true);

        }
        if (KeyInput.instance.leftReleased) {
            System.out.println("left: " + this.currentAnimationRenderer.angle);
            this.currentAnimationRenderer.checkLeft(false);
        }
        if (KeyInput.instance.rightPressed) {
            this.currentAnimationRenderer.checkRight(true);
        }
        if (KeyInput.instance.rightReleased) {
            System.out.println("right: " + this.currentAnimationRenderer.angle);
            this.currentAnimationRenderer.checkRight(false);
        }
        if (KeyInput.instance.upPressed) {
            this.defaulvelocity.y += 0.25;
            if (this.defaulvelocity.y == 5){
                this.defaulvelocity.y = 4;
            }else this.defaulvelocity.y +=0.25;
            this.defaulvelocity.set(0, this.defaulvelocity.y);
        }
        if (KeyInput.instance.upReleased) {
            this.defaulvelocity.set(0, this.defaulvelocity.y);
        }
        if (KeyInput.instance.downPressed) {
            this.defaulvelocity.y -= 0.25;
            if (this.defaulvelocity.y < 0){
                this.defaulvelocity.y = 0;
            }else this.defaulvelocity.y -=0.25;
            this.defaulvelocity.set(0, this.defaulvelocity.y);
        }
        if (KeyInput.instance.downReleased) {

        }



        if (KeyInput.instance.aPressed) {
            if (this.currentAnimationRenderer.angle <= 90) {
                if (frameCounter.run()) {
                    System.out.println("acc");
                    BulletPlayer bulletPlayer1 = GameObjectManager.instance.recycle(BulletPlayer.class);
                    bulletPlayer1.position.set(position.x + 50, position.y);
                    bulletPlayer1.velocity.set(this.velocitirotateL.rotate(this.currentAnimationRenderer.angle));
                    frameCounter.reset();
                }
            }else if (this.currentAnimationRenderer.angle > 90){
                if (frameCounter.run()) {
                    System.out.println("acc");
                    BulletPlayer bulletPlayer1 = GameObjectManager.instance.recycle(BulletPlayer.class);
                    bulletPlayer1.position.set(position.x - 50, position.y);
                    bulletPlayer1.velocity.set(this.velocitirotateL.rotate(this.currentAnimationRenderer.angle));
                    frameCounter.reset();
                }
            }
            if (this.currentAnimationRenderer.angle >= 270){
                if (frameCounter.run()) {
                    System.out.println("acc");
                    BulletPlayer bulletPlayer1 = GameObjectManager.instance.recycle(BulletPlayer.class);
                    bulletPlayer1.position.set(position.x + 50, position.y);
                    bulletPlayer1.velocity.set(this.velocitirotateL.rotate(this.currentAnimationRenderer.angle));
                    frameCounter.reset();
                }
            }

        }
        if (KeyInput.instance.aReleased) {

        }

        if (KeyInput.instance.dPressed){
            if (this.currentAnimationRenderer.angle <= 90) {
                if (frameCounter.run()) {
                    System.out.println("acc");
                    BulletPlayer bulletPlayer1 = GameObjectManager.instance.recycle(BulletPlayer.class);
                    bulletPlayer1.position.set(position.x - 50, position.y);
                    bulletPlayer1.velocity.set(this.velocitirotateR.rotate(this.currentAnimationRenderer.angle));
                    frameCounter.reset();
                }
            }else if (this.currentAnimationRenderer.angle > 90){
                if (frameCounter.run()) {
                    System.out.println("acc");
                    BulletPlayer bulletPlayer1 = GameObjectManager.instance.recycle(BulletPlayer.class);
                    bulletPlayer1.position.set(position.x + 50, position.y);
                    bulletPlayer1.velocity.set(this.velocitirotateR.rotate(this.currentAnimationRenderer.angle));
                    frameCounter.reset();
                }
            }
            if (this.currentAnimationRenderer.angle >= 270){
                if (frameCounter.run()) {
                    System.out.println("acc");
                    BulletPlayer bulletPlayer1 = GameObjectManager.instance.recycle(BulletPlayer.class);
                    bulletPlayer1.position.set(position.x - 50, position.y);
                    bulletPlayer1.velocity.set(this.velocitirotateR.rotate(this.currentAnimationRenderer.angle));
                    frameCounter.reset();
                }
            }

        }
        if (KeyInput.instance.dReleased){
        }
        if (KeyInput.instance.spacePressed){
            if (frameCounter.run()){
                BulletPlayer bulletPlayer1 = GameObjectManager.instance.recycle(BulletPlayer.class);
                bulletPlayer1.position.set(position.x + 50,position.y);
                bulletPlayer1.velocity.set(this.velocitirotateL.rotate(this.currentAnimationRenderer.angle));

                BulletPlayer bulletPlayer2 = GameObjectManager.instance.recycle(BulletPlayer.class);
                bulletPlayer2.position.set(position.x - 50,position.y);
               bulletPlayer2.velocity.set(this.velocitirotateR.rotate(this.currentAnimationRenderer.angle));
                frameCounter.reset();

            }
        }
        if (KeyInput.instance.spaceReleased){

        }
        this.bulletPlayer.velocity.set(this.defaulvelocity.rotate(this.currentAnimationRenderer.angle));
        this.velocity.set(this.defaulvelocity.rotate(this.currentAnimationRenderer.angle));
        this.position.addUp(this.velocity);
        this.boxCollider.position.set(this.position.x - 25, this.position.y - 25);
        this.runHitObject.run(this);


    }


    @Override
    public void getHit(GameObject gameObject) {
        this.isAlive = false;
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
