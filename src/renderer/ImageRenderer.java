package renderer;

import base.FrameCounter;
import base.Vector2D;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageRenderer implements Renderer {

    private BufferedImage image;
    public int width;
    public int height;
    private Color color;
    private boolean isChangeSize = false;
    public int deltaSize = 0;
    private FrameCounter frameCounter;

    public ImageRenderer(String path, int width, int height, Color color) {
        this.image = this.loadImage(path);
        this.width = width;
        this.height = height;
        this.color = color;
        this.fillColorImage();
    }

    public ImageRenderer(String path){
        this.height = this.loadImage(path).getHeight();
        this.width = this.loadImage(path).getWidth();
        this.image = this.loadImage(path);
    }

    public ImageRenderer(String path, int width, int height, Color color, boolean isChangeSize, int timeInterval) {
        this.image = this.loadImage(path);
        this.width = width;
        this.height = height;
        this.color = color;
        this.fillColorImage();
        this.isChangeSize = isChangeSize;
        this.frameCounter = new FrameCounter(timeInterval);
    }

    public ImageRenderer(String path, int width, int height) {
        this.image = this.loadImage(path);
        this.width = width;
        this.height = height;
    }

    public ImageRenderer(String path, int width, int height, boolean isChangeSize, int timeInterval) {
        this.image = this.loadImage(path);
        this.width = width;
        this.height = height;
        this.isChangeSize = isChangeSize;
        this.frameCounter = new FrameCounter(timeInterval);
    }

    private void fillColorImage() {
        for (int i = 0; i < this.image.getWidth(); i++) {
            for (int j = 0; j < this.image.getHeight(); j++) {
                if (this.image.getRGB(i, j) == Color.WHITE.getRGB())
                    this.image.setRGB(i, j, this.color.getRGB());
            }
        }
    }

    public BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public void render(Graphics graphics, Vector2D position) {
        this.update();
//        this.rotateRenderer = new RotateRenderer(graphics);
        graphics.drawImage(this.image, (int) position.x - this.width / 2, (int) position.y - this.height / 2, this.width, this.height, null);

    }
    public void update() {
        if (!this.isChangeSize) return;
        if (this.frameCounter.run()) {
            this.width -= this.deltaSize;
            this.height -= this.deltaSize;
        }
    }


}
