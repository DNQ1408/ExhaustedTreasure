package game.player.Playered;

import Scene.GamePlayScene;
import Scene.SceneManager;
import base.GameObject;
import base.Vector2D;

import game.player.bullet.ShootTriple;
import input.KeyInput;
import physic.BoxCollider;
import physic.HitObject;
import physic.PhysicBody;
import renderer.ImageRenderer;

public class PlayerRight extends GameObject implements HitObject, PhysicBody{
    public Vector2D velocity;
    public Playered playered;
    private Vector2D defaultVelocity = new Vector2D(0, 0);
    public ShootTriple shootTriple;

    public PlayerRight() {
        this.shootTriple = new ShootTriple();
        this.playered = new Playered();
        this.velocity = new Vector2D();
        this.position.set(playered.position);
        this.renderer = new ImageRenderer("resources/images/Player/playerMY.png",50,70);
    }
    @Override
    public void run(){
        super.run();
        this.handleEventKeyboard();
        this.position.addUp(this.defaultVelocity);
    }

    public void handleEventKeyboard(){
        if (KeyInput.instance.upPressed){
            this.defaultVelocity.set(0, 1);
        }
        if (KeyInput.instance.upReleased){
            this.defaultVelocity.set(0, 0);
        }
        if (KeyInput.instance.downPressed){
            this.defaultVelocity.set(0, -1);
        }
        if (KeyInput.instance.downReleased){
            this.defaultVelocity.set(0, 0);
        }

        if (KeyInput.instance.rightPressed){
            this.defaultVelocity.set(1, 0);
            SceneManager.instance.changScene(new GamePlayScene());
        }
        if (KeyInput.instance.rightReleased){
            this.defaultVelocity.set(0, 0);
        }
        if (KeyInput.instance.leftPressed){
            this.defaultVelocity.set(-1, 0);
        }
        if (KeyInput.instance.leftReleased){
            this.defaultVelocity.set(0, 0);
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
