package game;

import base.GameObject;
import renderer.TextRenderer;

import java.awt.*;

public class TextObject extends GameObject {
//        private TextRenderer renderer;
    public TextObject() {
        this.renderer = new TextRenderer("Game Over!", Color.RED, "resources/FiraMono-Bold.ttf", 50);
        this.position.set(300, 300);
    }
}
