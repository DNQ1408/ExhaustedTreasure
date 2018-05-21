package game.skerry;

import base.GameObjectManager;
import physic.BoxCollider;
import renderer.ImageRenderer;

public class SkerryShow {

    public SkerryShow() {

        // This code is creating only 1 skerry :v
        // We will create about 15 skerries at all
        Skerry skerry01 = GameObjectManager.instance.recycle(Skerry.class);
        skerry01.position.set(500, 200);
        skerry01.renderer = new ImageRenderer("resources/images/Skerry/Skerry1.png", 50, 50);
        skerry01.boxCollider = new BoxCollider(50, 50);


    }
}
