package Scene;

import base.GameObject;
import base.GameObjectManager;
import camera.Camera;
import game.background.Background;
import game.enemy.EnemySpawner;
import game.player.player.Player;
import game.skerry.Skerry;
import game.skerry.SkerryShow;
import game.treasure.Treasure;
import physic.BoxCollider;
import renderer.ImageRenderer;

public class GamePlayScene implements Scene {


    @Override
    public void init() {
        GameObjectManager.instance.recycle(Background.class);
//        Camera camera = GameObjectManager.instance.recycle(Camera.class);
//        camera.position.set(300,200);
        Player player = GameObjectManager.instance.recycle(Player.class);
        player.position.set(500,300);
        GameObjectManager.instance.recycle(EnemySpawner.class);
//        GameObjectManager.instance.recycle(PlayerLeft.class);
//        GameObjectManager.instance.recycle(PlayerDow.class);


        SkerryShow skerryShow = new SkerryShow();

        //show treasure
        Treasure treasure = GameObjectManager.instance.recycle(Treasure.class);
        treasure.position.set(1990, 1990);
        treasure.renderer = new ImageRenderer("resources/images/Treasure/Treasure.png", 50, 70);
        treasure.boxCollider = new BoxCollider(50, 70);



    }


    @Override
    public void deinit() {
        GameObjectManager.instance.clear();
    }
}
