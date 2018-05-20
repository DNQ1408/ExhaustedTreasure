package game.player.player;

import renderer.ImageRenderer;

import java.util.ArrayList;

public class PlayerAnimation {
    private String name;

    private boolean isRepeated;

    private ArrayList<ImageRenderer> imageRenderers;
    private int currentFrame;//chỉ bức ảnh hiện tại đang được vẽ;


    private ArrayList<Double> delayFrame;//độ chễ giữa 2 bức hình;
    private long beginTime;

    private boolean drawRectFrame;//dùng đẻ vẽ ô bao quanh hình;

    public PlayerAnimation() {
        delayFrame = new ArrayList<Double>();
        beginTime = 0;
        currentFrame = 0;

        imageRenderers = new ArrayList<ImageRenderer>();

        isRepeated = true;//cho lap lai
        drawRectFrame = false;//ko cho ve
    }

    public PlayerAnimation(PlayerAnimation playerAnimation){
        beginTime = playerAnimation.beginTime;
        currentFrame = playerAnimation.currentFrame;
        drawRectFrame = playerAnimation.drawRectFrame;
        isRepeated = playerAnimation.isRepeated;

        delayFrame = new ArrayList<Double>();
        for (Double d : playerAnimation.delayFrame){
            delayFrame.add(d);
        }
        imageRenderers = new ArrayList<ImageRenderer>();
        for (ImageRenderer i : playerAnimation.imageRenderers){
            i.loadImage("");
        }
    }
}








