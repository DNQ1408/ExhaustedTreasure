package game.player.player;

import base.GameObject;
import base.Vector2D;
import input.KeyInput;
import physic.BoxCollider;
import physic.HitObject;
import physic.PhysicBody;
import renderer.CurrentAnimationRenderer;
import renderer.ImageRenderer;

import java.awt.event.KeyEvent;

public class Player extends GameObject implements PhysicBody, HitObject {
    public PlayerShoot playerShoot;
    public Vector2D defaulvelocity = new Vector2D();
    public CurrentAnimationRenderer currentAnimationRendererLeft,currentAnimationRendererRight;
    public Vector2D velocity;
    public ImageRenderer imageRenderer;

    public Player() {
        this.imageRenderer = new ImageRenderer("resources/images/Player/playerMY.png");
        this.velocity = new Vector2D();
        this.playerShoot = new PlayerShoot();
        this.renderer = this.imageRenderer;
        this.currentAnimationRendererLeft = new CurrentAnimationRenderer(5,"resources/images/Player/playerMY.png",
                "resources/playerMy1.png",
                "resources/playerMy2.png",
                "resources/playerMy3.png",
                "resources/playerMy4.png",
                "resources/playerMy5.png",
                "resources/playerMy6.png",
                "resources/playerMy7.png",
                "resources/playerMy8.png",
                "resources/playerMy9.png",
                "resources/playerMy10.png",
                "resources/playerMy12.png",
                "resources/playerMy13.png",
                "resources/playerMy14.png",
                "resources/playerMy15.png",
                "resources/playerMy16.png",
                "resources/playerMy17.png",
                "resources/playerMy18.png",
                "resources/playerMy19.png"
               );

        this.currentAnimationRendererRight = new CurrentAnimationRenderer(5,"resources/images/Player/playerMY.png"
        ,"resources/playerMy19.png"
        ,"resources/playerMy18.png"
        ,"resources/playerMy17.png"
        , "resources/playerMy16.png"
        ,"resources/playerMy15.png"
        ,"resources/playerMy14.png"
        ,"resources/playerMy13.png"
        ,"resources/playerMy12.png"
        ,"resources/playerMy11.png"
        ,"resources/playerMy10.png"
        ,"resources/playerMy9.png"
        ,"resources/playerMy8.png"
        ,"resources/playerMy7.png"
        ,"resources/playerMy6.png"
        ,"resources/playerMy5.png"
        ,"resources/playerMy4.png"
        ,"resources/playerMy3.png"
        ,"resources/playerMy2.png"
        ,"resources/playerMy1.png"
        );

    }


    @Override
    public void run(){
        super.run();
       this.playerShoot.run(this);
        if (KeyInput.instance.getKeyPressed(KeyEvent.VK_LEFT)){
            this.currentAnimationRendererLeft.isLeftRight = 5;
            this.currentAnimationRendererLeft.isAnimation = true;
            this.renderer = this.currentAnimationRendererLeft;

        }
        if (KeyInput.instance.getKeyReleased(KeyEvent.VK_LEFT)){
            this.currentAnimationRendererLeft.isLeftRight = 0;
            this.currentAnimationRendererLeft.isAnimation = false;
        }
        if (KeyInput.instance.getKeyPressed(KeyEvent.VK_RIGHT)){
            this.currentAnimationRendererLeft.isLeftRight = 10;
            this.currentAnimationRendererRight.isAnimation=true;
            this.renderer = this.currentAnimationRendererRight;
        }
        if (KeyInput.instance.getKeyReleased(KeyEvent.VK_RIGHT)){
            this.currentAnimationRendererRight.isLeftRight = 0;
            this.currentAnimationRendererRight.isAnimation=false;
        }
        if (KeyInput.instance.getKeyPressed(KeyEvent.VK_UP)){
            this.defaulvelocity.set(0,5);
        }
        if (KeyInput.instance.getKeyReleased(KeyEvent.VK_UP)){
            this.defaulvelocity.set(0,0);
        }
        if (KeyInput.instance.getKeyPressed(KeyEvent.VK_DOWN)){
            this.defaulvelocity.set(0,-5);
        }
        if (KeyInput.instance.getKeyReleased(KeyEvent.VK_DOWN)){
            this.defaulvelocity.set(0,0);
        }
        this.velocity.set(this.defaulvelocity.rotate(this.currentAnimationRendererLeft.angle));
        this.position.addUp(this.velocity);

    }




    @Override
    public void getHit(GameObject gameObject) {
        this.isAlive = false;
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.getBoxCollider();
    }
}
