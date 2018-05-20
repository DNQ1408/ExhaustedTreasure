package renderer;

import base.FrameCounter;
import base.Vector2D;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CurrentAnimationRenderer implements Renderer {
    private List<BufferedImage> images;// chứa một chuỗi các hình ảnh liên tiếp.-> CurrentAnimationRenderer
    private FrameCounter frameCounter; // khoang delay giua hai lan buc anh.
    public int currentIndex; //dang ve o buc anh thu may trong list image
    public boolean isAnimation = true;
    public int isLeftRight;
    public double angle;

    public CurrentAnimationRenderer( int max, String... paths) {
        this.frameCounter = new FrameCounter(max);
        this.images = new ArrayList<>();
        Arrays.asList(paths).forEach(path -> images.add(loadImage(path)));
        this.currentIndex = 0;
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

        //đầu tiên get(this.curentIndex) trả về 1 vị trí của 1 bức ảnh trong list images sau đó this.images.get() sẽ lấy bức ảnh đó gán cho bufferedImage.
        BufferedImage bufferedImage = this.images.get(this.currentIndex);//trả về phần tử đã chỉ định trong danh sách Images
        if (bufferedImage != null) {
            // nếu trong bufferedImage có ảnh thì cho vẽ bức ảnh đó lên;
            graphics.drawImage(bufferedImage, (int)position.x - bufferedImage.getWidth() / 2, (int)position.y - bufferedImage.getHeight() / 2, null);
        }//(Image, Width ,Height, ImageObserver)
        if (!isAnimation) return;
        if (this.frameCounter.run()) {
            this.angle += 18;
            if (this.currentIndex >= this.images.size() - 1) {
                this.currentIndex = 0;
            } else {
                this.currentIndex += 1;
            }
            this.frameCounter.reset();
        }
    }
}
