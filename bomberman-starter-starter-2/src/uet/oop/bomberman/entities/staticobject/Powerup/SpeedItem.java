package uet.oop.bomberman.entities.staticobject.Powerup;

import uet.oop.bomberman.entities.movable.Bomber;
import uet.oop.bomberman.entities.staticobject.CollideEntity;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Sprite;

public class SpeedItem extends CollideEntity {

    public SpeedItem(int x, int y, Sprite sprite) {
        super(x, y, sprite);
    }

    @Override
    public void update() {

    }

    @Override
    public boolean collide(Entity entity) {
        if (entity instanceof Bomber) {
            remove();
            ((Bomber) entity).speed += 0.5;
            playSound("bomberman-starter-starter-2/res/sound/powerup.wav");
        }
        return true;
    }
}
