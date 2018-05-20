package Scene;

import base.GameObjectManager;
import game.TextObject;
import game.background.Background;

//ham ve slice GameOver
public class GameOver implements Scene {
    @Override
    public void init() {
        GameObjectManager.instance.recycle(Background.class);
        GameObjectManager.instance.recycle(TextObject.class);
    }

    @Override
    public void deinit() {
        GameObjectManager.instance.clear();
    }
}
