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

/**
 * Se co hai loai Animtion:
 * - Animation chay mot lan. tuc la chi ve lien tiep cac buc anh mot lan duy nhat
 * - Animation chay vo han. tuc la sau khi ve het cac buc anh thi lap lai*/
public class AnimationRenderer implements Renderer {

    private List<BufferedImage> images;// chứa một chuỗi các hình ảnh liên tiếp.-> Animation
    private boolean isRepeat; // neu true: animation chay vo han, false chi mot lan
    private FrameCounter frameCounter; // khoang delay giua hai lan buc anh.
    private int currentIndex; //dang ve o buc anh thu may trong list image
    private boolean disable = false;

    public AnimationRenderer(boolean isRepeat, int max, String... paths) {
        this.isRepeat = isRepeat;
        this.frameCounter = new FrameCounter(max);
        this.images = new ArrayList<>();
        Arrays.asList(paths).forEach(path -> images.add(loadImage(path)));
        this.currentIndex = 0;
    }

    public AnimationRenderer(int max, String... paths) { //animation chay vo han
        this(true, max, paths); //goi constructor phia tren
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
        if (this.disable) return;//nếu disable == false thì ko làm j cả;

        //đầu tiên get(this.curentIndex) trả về 1 vị trí của 1 bức ảnh trong list images sau đó this.images.get() sẽ lấy bức ảnh đó gán cho bufferedImage.
        BufferedImage bufferedImage = this.images.get(this.currentIndex);//trả về phần tử đã chỉ định trong danh sách Images
        if (bufferedImage != null) {
            // nếu trong bufferedImage có ảnh thì cho vẽ bức ảnh đó lên;
            graphics.drawImage(bufferedImage, (int)position.x - bufferedImage.getWidth() / 2, (int)position.y - bufferedImage.getHeight() / 2, null);
        }//(Image, Width ,Height, ImageObserver)
        if (this.currentIndex == this.images.size() - 1 && !this.isRepeat) {
            //nếu đang ở vị trí bức ảnh cuối cùng và đồng thời animation này ko cho chạy vô hạn thì thoát khỏi hàm vẽ render này
            this.disable = true;
        } else {
            // ngược lại thì cho  animation chạy vô hạn;
            if (this.frameCounter.run()) {
                if (this.currentIndex >= this.images.size() - 1) {
                    this.currentIndex = 0;
                } else {
                    this.currentIndex += 1;
                }
                this.frameCounter.reset();
            }
        }
    }
}
