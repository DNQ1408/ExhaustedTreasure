package game.player.Playered;

import renderer.AnimationRenderer;
import renderer.ImageRenderer;

import java.util.ArrayList;

public class PlayeredAnimation {
    private String name;

    private boolean isRepeated;

    private ArrayList<ImageRenderer> imageRenderers;
    private int currentFrame;//chỉ bức ảnh hiện tại đang được vẽ;


    private ArrayList<Double> delayFrame;//độ chễ giữa 2 bức hình;
    private long beginTime;

    private boolean drawRectFrame;//dùng đẻ vẽ ô bao quanh hình;

    public PlayeredAnimation() {
        delayFrame = new ArrayList<Double>();
        beginTime = 0;
        currentFrame = 0;

        imageRenderers = new ArrayList<ImageRenderer>();

        isRepeated = true;//cho lap lai
        drawRectFrame = false;//ko cho ve
    }

    public PlayeredAnimation (PlayeredAnimation playeredAnimation){
        beginTime = playeredAnimation.beginTime;
        currentFrame = playeredAnimation.currentFrame;
        drawRectFrame = playeredAnimation.drawRectFrame;
        isRepeated = playeredAnimation.isRepeated;

        delayFrame = new ArrayList<Double>();
        for (Double d : playeredAnimation.delayFrame){
            delayFrame.add(d);
        }
        imageRenderers = new ArrayList<ImageRenderer>();
        for (ImageRenderer i : playeredAnimation.imageRenderers){
            i.loadImage("");
        }
    }
}








