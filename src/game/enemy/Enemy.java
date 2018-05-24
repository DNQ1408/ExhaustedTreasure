package game.enemy;

import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import physic.BoxCollider;
import physic.PhysicBody;
import renderer.ImageRenderer;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Enemy extends GameObject implements PhysicBody{
    private EnemyMove enemyMove;
    public BoxCollider boxCollider;
    public FrameCounter frameCounter;
    public Enemy() {
        this.frameCounter = new FrameCounter(30);
        this.enemyMove = new EnemyMove();
        this.renderer = new ImageRenderer("resources/images/Enemy/ship_(2).png", 25,35);
        this.position.set(30,20);
        this.boxCollider = new BoxCollider(25,35);

    }

    @Override
    public void run() {
        super.run();
        this.boxCollider.position.set(this.position);
//        System.out.println("Enemy running");
        this.enemyMove.run(this);
        if (frameCounter.run()){
            BulletEnemy bulletEnemy = GameObjectManager.instance.recycle(BulletEnemy.class);
            bulletEnemy.position.set(this.position);
            frameCounter.reset();
        }
    }

    @Override
    public BoxCollider getBoxCollider() {
        return null;
    }
}
