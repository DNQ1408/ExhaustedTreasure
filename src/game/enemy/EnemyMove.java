package game.enemy;
import base.GameObjectManager;
import base.Vector2D;
import game.player.player.Player;


public class EnemyMove {
    private Vector2D velocity;
    public BulletEnemy bulletEnemy;
    public EnemyMove() {
        this.velocity = new Vector2D();
        this.bulletEnemy = new BulletEnemy();
    }

    public void run(Enemy enemy) {
        Player player = GameObjectManager.instance.findPlayer();
            if (player != null) {
                    this.velocity.set(
                            player
                                    .position
                                    .subtract(enemy.position)
                                    .normalize()
                    ).multiply(1);
            } else {
                this.velocity = new Vector2D((int) 0.25, 0);
            }

            enemy.position.addUp(this.velocity);
        }
}
