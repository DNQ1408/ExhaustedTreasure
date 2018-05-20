package Scene;

import base.GameObject;
import base.GameObjectManager;
import game.background.Background;
import game.player.Playered.PlayerRight;

public class GamePlayerRight implements Scene {
    @Override
    public void init() {
        GameObjectManager.instance.recycle(Background.class);
        GameObjectManager.instance.recycle(PlayerRight.class);

    }

    @Override
    public void deinit() {
        GameObjectManager.instance.clear();
    }
}
