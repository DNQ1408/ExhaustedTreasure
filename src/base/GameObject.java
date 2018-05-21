package base;

//import action.Action;
import renderer.AnimationRenderer;
import renderer.Renderer;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameObject {
    public Vector2D position;
    public Renderer renderer;

    public boolean isAlive = true;
//    private List<Action> actions;

    public GameObject() {
        this.position = new Vector2D();
//        this.actions = new ArrayList<>();
    }

  public void run() {
//        this.actions.removeIf(action -> action.run(this));
    }

    public void render(Graphics graphics) {
        if (this.renderer == null) return;
        this.renderer.render(graphics, this.position);
    }

//    public void addAction(Action action) {
//        this.actions.add(action);
//    }
}
