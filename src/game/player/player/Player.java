package game.player.player;

import base.FrameCounter;
import base.GameObject;
import base.Vector2D;
import input.KeyInput;
import physic.BoxCollider;
import physic.HitObject;
import physic.PhysicBody;
import renderer.AnimationRenderer;
import renderer.CurrentAnimationRenderer;
import renderer.ImageRenderer;
import renderer.Renderer;

import java.awt.event.KeyEvent;

public class Player extends GameObject implements PhysicBody, HitObject {
    public PlayerShoot playerShoot;
    public Vector2D defaulvelocity = new Vector2D();
    public CurrentAnimationRenderer currentAnimationRendererLeft, currentAnimationRendererRight;
    public Vector2D velocity;
    public ImageRenderer imageRenderer;
    private boolean is = true;
    public Player() {
        this.imageRenderer = new ImageRenderer("resources/images/Player/ship (4)-1.png");
        this.renderer = this.imageRenderer;
        this.velocity = new Vector2D();
        this.playerShoot = new PlayerShoot();
        this.currentAnimationRendererLeft = new CurrentAnimationRenderer(0, "resources/images/Player/ship (4)-1.png",
                "resources/images/Player/ship (4)-2.png",
                "resources/images/Player/ship (4)-3.png",
                "resources/images/Player/ship (4)-4.png",
                "resources/images/Player/ship (4)-5.png",
                "resources/images/Player/ship (4)-6.png",
                "resources/images/Player/ship (4)-7.png",
                "resources/images/Player/ship (4)-8.png",
                "resources/images/Player/ship (4)-9.png",
                "resources/images/Player/ship (4)-10.png",
                "resources/images/Player/ship (4)-11.png",
                "resources/images/Player/ship (4)-12.png",
                "resources/images/Player/ship (4)-13.png",
                "resources/images/Player/ship (4)-14.png",
                "resources/images/Player/ship (4)-15.png",
                "resources/images/Player/ship (4)-16.png",
                "resources/images/Player/ship (4)-17.png",
                "resources/images/Player/ship (4)-18.png",
                "resources/images/Player/ship (4)-19.png",
                "resources/images/Player/ship (4)-20.png"
        );
        this.currentAnimationRendererRight = new CurrentAnimationRenderer(0, "resources/images/Player/ship (4)-1.png"
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

    }


    @Override
    public void run() {
        super.run();

        this.playerShoot.run(this);
        if (KeyInput.instance.leftPressed) {
            this.is = true;
            this.currentAnimationRendererLeft.isAnimation = true;
            this.renderer = this.currentAnimationRendererLeft;
            this.currentAnimationRendererLeft.checkLeft(true);

        }
        if (KeyInput.instance.leftPressed) {
            this.is = true;
            System.out.println(currentAnimationRendererLeft.angle);
            this.currentAnimationRendererLeft.isAnimation = false;
        }
        if (KeyInput.instance.rightPressed) {
            this.is = false;
            this.currentAnimationRendererRight.isAnimation = true;
            this.renderer = this.currentAnimationRendererRight;
            this.currentAnimationRendererRight.checkRight(true);
        }
        if (KeyInput.instance.rightReleased) {
            this.is = false;
            System.out.println(currentAnimationRendererLeft.angle);
            this.currentAnimationRendererRight.isAnimation = false;
        }
        if (KeyInput.instance.upPressed) {
            this.defaulvelocity.set(0, 5);
        }
        if (KeyInput.instance.upReleased) {
            this.defaulvelocity.set(0, 0);
        }
        if (KeyInput.instance.downPressed) {
            this.defaulvelocity.set(0, -5);
        }
        if (KeyInput.instance.downReleased) {
            this.defaulvelocity.set(0, 0);
        }


        if (this.is == true){
            this.velocity.set(this.defaulvelocity.rotate(this.currentAnimationRendererLeft.angle));
        }
        if (this.is == false){
            this.velocity.set(this.defaulvelocity.rotate(this.currentAnimationRendererRight.angle));
        }
        this.position.addUp(this.velocity);
    }


    @Override
    public void getHit(GameObject gameObject) {

    }

    @Override
    public BoxCollider getBoxCollider() {
        return null;
    }
}
