package game.particle;

import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import renderer.ImageRenderer;

import java.awt.*;
import java.util.Random;
//vẽ khói cho player.(có thể dùng để vẽ sóng chạy sau con tàu)
public class Particle extends GameObject {

    public Vector2D velocity;

    public Particle() {
        this.velocity = new Vector2D();
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        if (this.renderer instanceof ImageRenderer) {
            int width = ((ImageRenderer)this.renderer).width;
            int height = ((ImageRenderer)this.renderer).height;
            if (width == 0 || height == 0) {
                this.isAlive = false;
            }
        }
    }

    private static FrameCounter frameCounter;

    public static void effectSmoke(Vector2D position, Vector2D velocity, int width, int height, Color color, int timeIntervalCreate, int timeIntervalChangeSize) {
        if (frameCounter == null) {
            frameCounter = new FrameCounter(timeIntervalCreate);
        }
        if (frameCounter.run()) {
            Particle particle = GameObjectManager.instance.recycle(Particle.class);
            ImageRenderer imageRenderer = new ImageRenderer("resources/images/circle.png", width, height, color, true, timeIntervalChangeSize);
            imageRenderer.deltaSize = 1;
            particle.renderer = imageRenderer;
            particle.position.set(position);
            particle.velocity.set(velocity);
            frameCounter.reset();
        }
    }
}
