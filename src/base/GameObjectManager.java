package base;

import game.player.player.Player;
import physic.BoxCollider;
import physic.PhysicBody;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameObjectManager {

    public static GameObjectManager instance = new GameObjectManager();//o dau cx co the goi dk de quan ly chung

    private List<GameObject> list;
    private List<GameObject> tempList;

    private GameObjectManager() {
        this.list = new ArrayList<>();
        this.tempList = new ArrayList<>();
    }

    public void add(GameObject gameObject) {
        this.tempList.add(gameObject);
    }

    public void runAll() {
        this.list.stream()
                .filter(gameObject -> gameObject.isAlive)//loc lay nhung con player con song
                .forEach(gameObject -> gameObject.run());
        this.list.addAll(this.tempList);
        this.tempList.clear();
    }

    public void renderAll(Graphics graphics) {
        this.list
                .stream()
                .filter(gameObject -> gameObject.isAlive)
                .forEach(gameObject -> gameObject.render(graphics));
    }



    public <T extends GameObject> T recycle(Class<T> cls) {
        T gameObject = (T) this.list
                .stream()
                .filter(object -> !object.isAlive)
                .filter(object -> cls.isInstance(object))
                .findFirst()
                .orElse(null);
        if (gameObject != null) {
            gameObject.isAlive = true;
        } else {
            try {
                gameObject = cls.newInstance();
                this.add(gameObject);
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
                return null;
            }
        }
        return gameObject;
    }


    public <T extends GameObject> T checkCollision(BoxCollider boxCollide, Class<T> cls) {
        return (T) this.list
                .stream()
                .filter(gameObject -> cls.isInstance(gameObject))
                .filter(gameObject -> gameObject.isAlive)
                .filter(gameObject -> gameObject instanceof PhysicBody)
                .filter(gameObject -> {

                    BoxCollider other = ((PhysicBody) gameObject).getBoxCollider();
                    if (other == null) {

                        System.out.println("not found box");
                        return false;
                    }
                    return boxCollide.checkCollider(other);
                })
                .findFirst()
                .orElse(null);
    }

    public Player findPlayer() {
        return (Player) this.list
                .stream()
                .filter(gameObject -> gameObject instanceof Player)
                .filter(gameObject -> gameObject.isAlive)
                .findFirst()
                .orElse(null);
    }

    public void clear(){
        this.list.clear();
        this.tempList.clear();
    }

}
