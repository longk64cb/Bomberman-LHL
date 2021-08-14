package uet.oop.bomberman.entities.staticobject.Bomb;

import javafx.scene.canvas.GraphicsContext;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.entities.movable.AnimationEntity;
import uet.oop.bomberman.entities.movable.Character;
import uet.oop.bomberman.entities.movable.Direction;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Sprite;

import java.util.ArrayList;

public class DirectionExplosion extends AnimationEntity {
    private int explosionLength;
    protected ArrayList<Explosion> explosions;
    private int vanishTime = 20;

    public DirectionExplosion(int xUnit, int yUnit, Sprite sprite, Direction direction, int length) {
        super(xUnit, yUnit, sprite);
        this.direction = direction;
        this.explosionLength = length;
        explosions = new ArrayList<>();
        setExplosions();

    }

    public void setExplosions() {
        boolean lastExplosion;
        int x = getxUnit();
        int y = getyUnit();
        for (int i = 0; i < explosionLength; i++) {
            if (i == explosionLength - 1) {
                lastExplosion = true;
            } else {
                lastExplosion = false;
            }
            switch (direction) {
                case LEFT:
                    x--;
                    break;
                case RIGHT:
                    x++;
                    break;
                case DOWN:
                    y++;
                    break;
                case UP:
                    y--;
                    break;
            }
            Entity s = BombermanGame.getStillObjects(x, y, this);
            if (s.collide(this)) {
                explosions.add(new Explosion(x, y, this.direction, lastExplosion, sprite));
            } else {
                break;
            }
        }
    }

    private void calculateExplosion() {
        int rad = 0;

    }

    @Override
    public void render(GraphicsContext gc) {
//        gc.drawImage(this.img, x, y);
        for (Explosion i : explosions) {
            i.render(gc);
        }
    }

    @Override
    public void update() {
//        setSprite(Sprite.movingSprite(Sprite.bomb_exploded, Sprite.bomb_exploded1, Sprite.bomb_exploded2, vanishTime));
        if (vanishTime > 0) {
            vanishTime--;
        } else {
            remove();
        }
        for (Explosion i : explosions) {
            i.update();
        }
    }

    @Override
    public boolean collide(Entity entity) {
        if (entity instanceof Character) {
            ((Character) entity).die();
        }
        return true;
    }
}
