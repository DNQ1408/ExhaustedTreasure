package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput implements KeyListener {

    public static final KeyInput instance = new KeyInput();//dung de truy cap o bat cu dau thuong dung de quan ly chung 1 cv nao do

    public boolean upPressed = false;
    public boolean upReleased = false;
    public boolean downPressed = false;
    public boolean downReleased = false;
    public boolean leftPressed = false;
    public boolean leftReleased = false;
    public boolean rightPressed = false;
    public boolean rightReleased = false;
    public boolean spacePressed = false;
    public boolean spaceReleased = false;

    private KeyInput() {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            this.spacePressed = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            this.upPressed = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN){
            this.downPressed = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            this.leftPressed = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            this.rightPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            this.spaceReleased = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            this.upReleased = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN){
            this.downReleased = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            this.leftReleased = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            this.rightReleased = true;
        }
    }

    public void reset() {
        this.upPressed = false;
        this.upReleased = false;
        this.downPressed = false;
        this.downReleased = false;
        this.leftPressed = false;
        this.leftReleased = false;
        this.rightPressed = false;
        this.rightReleased = false;
        this.spacePressed = false;
        this.spaceReleased = false;
    }
}
