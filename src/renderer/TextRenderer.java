package renderer;

import base.Vector2D;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class TextRenderer implements Renderer {

    public String text;
    private Color color;
    private Font font;

    public TextRenderer(String text, Color color, String fontName, int textSize) {
        this.text = text;
        this.color = color;
        try {
            this.font = Font.createFont(Font.TRUETYPE_FONT, new File(fontName));
            this.font = this.font.deriveFont(Font.PLAIN, textSize);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void render(Graphics graphics, Vector2D position) {
        //if (this.font == null) return;
        graphics.setFont(this.font);
        graphics.setColor(this.color);
        graphics.drawString(this.text, (int) position.x, (int) position.y);
    }

}
