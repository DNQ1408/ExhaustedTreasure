import Scene.GamePlayScene;
import Scene.SceneManager;
import base.GameObjectManager;
import input.KeyInput;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

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



    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered, 0, 0, null);

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
