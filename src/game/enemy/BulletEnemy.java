package game.enemy;

import base.GameObject;
import base.Vector2D;
import renderer.ImageRenderer;

import javax.swing.*;


public class BulletEnemy extends GameObject {
    public Vector2D velociti;
    public BulletEnemy() {
        this.velociti = new Vector2D(3,0);
        this.renderer = new ImageRenderer("resources/images/Bullet/BulletEnerMy.png",10,10);

    }
    @Override
    public void run(){
        this.position.addUp(this.velociti);
    }

}
