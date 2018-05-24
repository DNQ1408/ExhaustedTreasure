import Scene.GamePlayScene;
import Scene.SceneManager;
import base.GameObjectManager;
import input.KeyInput;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameCanvas extends JPanel {

    private BufferedImage backBuffered;
    private Graphics graphics;

    public GameCanvas() {
        this.setSize(1024, 600);
        this.setupBackBuffered();
       SceneManager.instance.changScene(new GamePlayScene());
        this.setVisible(true);
    }

    private void setupBackBuffered() {
        this.backBuffered = new BufferedImage(1024, 600, BufferedImage.TYPE_4BYTE_ABGR); //khoi tao object
        this.graphics = this.backBuffered.getGraphics();
    }

    int i = 0;
    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered, 0, 0, null);
        BufferedImage image = LoadImage("resources/images/Enemy/ship_(2).png");
        AffineTransform at = AffineTransform.getTranslateInstance(800, 200);
        at.rotate(Math.toRadians(i++), image.getWidth() / 2, image.getHeight() / 2);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(image, at, null);
        repaint();
    }
    BufferedImage LoadImage(String path) {
        BufferedImage image = null;

        try {
            image = ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }
    public void renderAll() {
        GameObjectManager.instance.renderAll(this.graphics);
        this.repaint();
    }

    public void runAll() {
        GameObjectManager.instance.runAll();
        SceneManager.instance.performChangSceneIfNeeded();
        KeyInput.instance.reset();
    }

}
