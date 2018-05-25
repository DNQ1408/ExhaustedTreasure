package game.skerry;

import base.GameObject;
import base.GameObjectManager;
import physic.BoxCollider;
import renderer.ImageRenderer;

public class SkerryShow {

    public SkerryShow() {

        Skerry skerry01 = GameObjectManager.instance.recycle(Skerry.class);
        skerry01.position.set(200, 200);
        skerry01.renderer = new ImageRenderer("resources/images/SkerryAndTreasure/skerry3.png", 50, 50);
        skerry01.boxCollider.width = 50;
        skerry01.boxCollider.height = 50;

        Skerry skerry02 = GameObjectManager.instance.recycle(Skerry.class);
        skerry02.position.set(600, 400);
        skerry02.renderer = new ImageRenderer("resources/images/SkerryAndTreasure/skerry2.png", 55, 55);
        skerry01.boxCollider.width = 55;
        skerry02.boxCollider.height = 55;

        Skerry skerry03 = GameObjectManager.instance.recycle(Skerry.class);
        skerry03.position.set(800, 600);
        skerry03.renderer = new ImageRenderer("resources/images/SkerryAndTreasure/skerry1.png", 40, 40);
        skerry03.boxCollider.width = 40;
        skerry03.boxCollider.height = 40;

        Skerry skerry04 = GameObjectManager.instance.recycle(Skerry.class);
        skerry04.position.set(1000, 500);
        skerry04.renderer = new ImageRenderer("resources/images/SkerryAndTreasure/skerry3.png", 70, 70);
        skerry04.boxCollider.width = 70;
        skerry04.boxCollider.height = 70;

        Skerry skerry05 = GameObjectManager.instance.recycle(Skerry.class);
        skerry05.position.set(600, 40);
        skerry05.renderer = new ImageRenderer("resources/images/SkerryAndTreasure/skerry2.png", 50, 50);
        skerry05.boxCollider.width = 50;
        skerry05.boxCollider.height = 50;
    }
}
