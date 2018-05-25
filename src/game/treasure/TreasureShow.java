package game.treasure;

import base.GameObjectManager;
import renderer.ImageRenderer;

public class TreasureShow {

    public TreasureShow() {
        Treasure treasure = GameObjectManager.instance.recycle(Treasure.class);
        int TREASURE_X = 980;
        int TREASURE_Y = 550;
        treasure.position.set(TREASURE_X, TREASURE_Y);
        treasure.renderer = new ImageRenderer("resources/images/SkerryAndTreasure/treasure.png", 100, 70);
        treasure.boxCollider.width = 100;
        treasure.boxCollider.height = 70;
    }
}
