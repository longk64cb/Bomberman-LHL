package uet.oop.bomberman.entities.staticobject;

import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.movable.Enemy.Kondoria;
import uet.oop.bomberman.entities.staticobject.Bomb.DirectionExplosion;
import uet.oop.bomberman.graphics.Sprite;

public class Brick extends Entity {
    private boolean destroyed = false;
    private int vanishTime = 20;

    public Brick(int x, int y, Sprite sprite) {
        super(x, y, sprite);
    }

    @Override
    public void update() {
        if (destroyed) {
            setSprite(Sprite.finalMovingSprite(Sprite.brick_exploded, Sprite.brick_exploded1, Sprite.brick_exploded2, vanishTime, 20 ));
            if (vanishTime > 0) {
                vanishTime--;
            } else {
                remove();
            }
        }
    }

    @Override
    public boolean collide(Entity entity) {
//        if (entity instanceof Bomber || entity instanceof AnimationEntity) {
//            return false;
//        }
        if (entity instanceof DirectionExplosion) {
            destroyed = true;
//            remove();
        }
        if (entity instanceof Kondoria) {
            return true;
        }
        return false;
    }
}
