package renderer;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class RotateRenderer extends JPanel {

            public static void main(String args[]){
            JFrame F = new JFrame();
            F.add(new RotateRenderer());
            F.setSize(1024,600);
            F.setVisible(true);
            F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    public int width;
    public int height;
    int i = 0;

    public void paintComponent(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0,0,1024,600);
        BufferedImage image = LoadImage("resources/images/Player/ship (4)-1.png");
        AffineTransform at = AffineTransform.getTranslateInstance(300, 200);
        at.rotate(Math.toRadians(i++), image.getWidth() / 2, image.getHeight() / 2);
            at.scale(1,1);
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

}
