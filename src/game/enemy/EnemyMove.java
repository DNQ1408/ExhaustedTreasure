package game.enemy;
import base.GameObjectManager;
import base.Vector2D;
import game.player.player.Player;


public class EnemyMove {

    private Vector2D velocity;

    public EnemyMove() {
        this.velocity = new Vector2D();
    }


    public void run(Enemy enemy){
        Player player = GameObjectManager.instance.findPlayer();
        if (player != null) {
            this.velocity.set(
                    player
                            .position
                            .subtract(enemy.position)
                            .normalize()
                            .multiply(2)
            );
        } else {
            this.velocity = new Vector2D(2, 3);
        }
        enemy.position.addUp(this.velocity);
    }
}
