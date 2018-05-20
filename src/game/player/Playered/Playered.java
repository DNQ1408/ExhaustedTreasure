package game.player.Playered;

import base.FrameCounter;
import base.GameObject;
import base.Vector2D;
import game.player.bullet.BulletPlayer;
import game.player.bullet.ShootTriple;
import input.KeyInput;
import physic.BoxCollider;
import physic.HitObject;
import physic.PhysicBody;
import renderer.AnimationRenderer;
import renderer.ImageRenderer;
import renderer.Renderer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.security.Key;
import java.util.List;

public class Playered extends GameObject implements PhysicBody, HitObject {
    Vector2D velocity;
    private Vector2D defaultVelocity = new Vector2D(0, 0);
    public BulletPlayer bulletPlayer;
    public ShootTriple shootTriple;
    private Renderer imageRenderer;
    private AnimationRenderer animationRenderer;
//    private Renderer animationRenderer;
    private boolean isAnimation;
    private FrameCounter frameCounter;
    ImageRenderer imageRenderer1;
    private boolean isvelocity = false;
    private int isVelocityX = 0;
    public Playered() {
        this.frameCounter = new FrameCounter(50);
        this.bulletPlayer = new BulletPlayer();
        this.shootTriple = new ShootTriple();
        this.velocity = new Vector2D(0, 0);
        this.position = new Vector2D(500,300);
       imageRenderer = new ImageRenderer("resources/images/Player/playerMY.png",50,70);
       this.animationRenderer = new AnimationRenderer(20,
                    "resources/images/Player/playerMY.png",// quay xuống
                    "resources/images/Player/playerMy3.png");// quay trái


        if (isvelocity == true){
            this.defaultVelocity.y +=1;
        }

    }


    @Override
    public void run(){
        super.run();
        this.handleEventKeyboard(this);
        this.position.addUp(this.defaultVelocity);
        this.shootTriple.run(this);
        this.renderer = this.imageRenderer;
        if (this.isAnimation == true){
            this.isAnimation = false;
            this.renderer = this.imageRenderer;
        }
    }

    public void handleEventKeyboard(Playered playered){

            if (KeyInput.instance.upPressed){
                this.isvelocity = true;
                this.defaultVelocity.set(0,2);
            }
            if (KeyInput.instance.upReleased){
                this.defaultVelocity.set(0, isVelocityX);
                this.isvelocity = false;
            }
            if (KeyInput.instance.downPressed){
                this.defaultVelocity.set(0, -1);
            }
            if (KeyInput.instance.downReleased){
                this.defaultVelocity.set(0, 0);
            }

            if (KeyInput.instance.rightPressed){
//                this.defaultVelocity.set(2, 0);
            }
            if (KeyInput.instance.rightReleased){
//                this.defaultVelocity.set(0, 0);
            }
            if (KeyInput.instance.leftPressed){
//                this.defaultVelocity.set(-2, 0);
//                this.renderer = this.animationRenderer;

//                this.isAnimation = true;
            }
            if (KeyInput.instance.leftReleased){
                this.defaultVelocity.set(0, 0);
//                this.isAnimation = false;
//                this.renderer = this.imageRenderer1;
//                this.animationRenderer.currentIndex = 1;
            }
            if (KeyInput.instance.spacePressed){

                this.shootTriple.isA = true;

            }
            if (KeyInput.instance.spaceReleased){

                this.shootTriple.isA = false;

            }
            this.velocity.set(this.defaultVelocity);
    }


    @Override
    public void getHit(GameObject gameObject) {

    }

    @Override
    public BoxCollider getBoxCollider() {
        return null;
    }
}
