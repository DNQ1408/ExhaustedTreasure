package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class KeyInput implements KeyListener {

    public static final KeyInput instance = new KeyInput();//dung de truy cap o bat cu dau thuong dung de quan ly chung 1 cv nao do

//    private List<Boolean> KeyPressed;
//    private List<Boolean> KeyReleased;
//    private List<Boolean> keyTyped;

//    private int Number_Key = 256;
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
    public boolean aPressed = false;
    public boolean aReleased = false;
    public boolean dPressed = false;
    public boolean dReleased = false;

//    private KeyInput() {
//        this.KeyPressed = new ArrayList<>();
//        this.KeyReleased = new ArrayList<>();
//        this.keyTyped = new ArrayList<>();
//        for (int i = 0 ; i < Number_Key; i++){
//            this.KeyReleased.add(false);
//            this.KeyPressed.add(false);
//            this.keyTyped.add(false);
//        }
//    }

//    public boolean getKeyPressed(int code){
//        return this.KeyPressed.get(code);
//    }
//
//    public boolean getKeyReleased(int code){
//        return this.KeyReleased.get(code);
//    }
//
//    public boolean getKeyTyped(int code){ return this.keyTyped.get(code);
//    }

//    public void update(){
//        for (int i = 0;i < Number_Key;i++){
//            this.KeyReleased.set(i,false);
//            this.KeyPressed.set(i,false);
//            this.keyTyped.set(i,false);
//        }
//    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
//        this.KeyPressed.set(e.getKeyCode(),true);
//    }
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
        if (e.getKeyCode() == KeyEvent.VK_A){
            this.aPressed = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_D){
            this.dPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
//        this.KeyReleased.set(e.getKeyCode(),true);
//    }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            this.spaceReleased = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            this.upReleased = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            this.downReleased = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            this.leftReleased = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            this.rightReleased = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_A){
            this.aReleased = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_D){
            this.dReleased       = true;
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
        this.aPressed = false;
        this.aReleased = false;
        this.dPressed = false;
        this.dReleased = false;
    }
}
