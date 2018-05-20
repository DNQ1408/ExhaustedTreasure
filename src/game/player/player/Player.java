package game.player.player;

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

import java.util.List;

public class Player extends GameObject implements PhysicBody, HitObject {
    Vector2D velocity;
    private Vector2D defaultVelocity = new Vector2D(0, 0);
    public BulletPlayer bulletPlayer;
    public ShootTriple shootTriple;
    private Renderer imageRenderer;
    private List<Renderer> AnimationRendererList;
    private Renderer animationRenderer;
    private boolean isAnimation;
    private FrameCounter frameCounter;
    ImageRenderer imageRenderer1;
    public AnimationRenderer upAnimation = new AnimationRenderer(6,"resources/images/Player/playerMY.png",
            "resources/playerMy1.png",
            "resources/playerMy2.png",
            "resources/playerMy3.png",
            "resources/playerMy4.png",
            "resources/playerMy5.png",
            "resources/playerMy6.png",
            "resources/playerMy7.png",
            "resources/playerMy8.png",
            "resources/playerMy9.png",
            "resources/playerMy10.png");
    public AnimationRenderer downAnimation = new AnimationRenderer(6,"resources/playerMy10.png",
            "resources/playerMy12.png",
            "resources/playerMy13.png",
            "resources/playerMy14.png",
            "resources/playerMy15.png",
            "resources/playerMy16.png",
            "resources/playerMy17.png",
            "resources/playerMy18.png",
            "resources/playerMy19.png",
            "resources/images/Player/playerMY.png");
    public AnimationRenderer rightAnimation = new AnimationRenderer(6,"resources/images/Player/playerMY.png",
            "resources/playerMy1.png",
            "resources/playerMy2.png",
            "resources/playerMy3.png",
            "resources/playerMy4.png",
            "resources/playerMy5.png");
    public AnimationRenderer leftAnimation = new AnimationRenderer(false,30,"resources/playerMy10.png",
            "resources/playerMy12.png",
            "resources/playerMy13.png",
            "resources/playerMy14.png",
            "resources/playerMy15.png",
            "resources/playerMy16.png"
    );
//    public AnimationRenderer leftAnimation1 = new AnimationRenderer(true,10, "resources/playerMy16.png");


    public Player() {
        this.frameCounter = new FrameCounter(50);
        this.bulletPlayer = new BulletPlayer();
        this.shootTriple = new ShootTriple();
        this.velocity = new Vector2D(0, 0);
        this.position = new Vector2D(500,300);
        imageRenderer1 = new ImageRenderer("resources/images/Player/playerMY.png",50,70);
//        this.animationRenderer = new AnimationRenderer(2,
//                "resources/images/Player/playerMY.png",// quay xuống
//                "resources/images/Player/playerMy3.png");// quay trái
        this.renderer = this.imageRenderer1;


    }


    @Override
    public void run(){
        super.run();
        this.handleEventKeyboard(this);
        this.position.addUp(this.defaultVelocity);
        this.shootTriple.run(this);
        if (this.isAnimation == true){
            this.isAnimation = false;
            this.renderer = this.imageRenderer;
        }
    }

    public void handleEventKeyboard(Player player){

        if (KeyInput.instance.upPressed){
            this.velocity.y += 1;
            this.defaultVelocity.set(0,this.velocity.y);
        }
        if (KeyInput.instance.upReleased){
            this.defaultVelocity.set(0, this.velocity.y);
        }
        if (KeyInput.instance.downPressed){
            this.velocity.y += -1;
            this.defaultVelocity.set(0,this.velocity.y);
            if (this.velocity.y <= 0){
                this.defaultVelocity.set(0, 0);
            }
        }
        if (KeyInput.instance.downReleased){


        }

        if (KeyInput.instance.rightPressed){

            player.renderer = this.rightAnimation;
        }
        if (KeyInput.instance.rightReleased){
            this.defaultVelocity.set(0, 0);
        }
        if (KeyInput.instance.leftPressed){
            player.renderer = this.leftAnimation;
//            player.renderer = this.leftAnimation1;
//                this.renderer = this.animationRenderer;
//                this.isAnimation = true;
        }
        if (KeyInput.instance.leftReleased){
//                this.defaultVelocity.set(0, 0);
//            this.isAnimation = false;
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