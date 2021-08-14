package uet.oop.bomberman.entities.staticobject;

import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.movable.Bomber;
import uet.oop.bomberman.entities.movable.Character;
import uet.oop.bomberman.graphics.Sprite;

public class Wall extends CollideEntity {

    public Wall(int x, int y, Sprite sprite) {
        super(x, y, sprite);
    }

    @Override
    public void update() {

    }

    @Override
    public boolean collide(Entity entity) {
        if (entity instanceof Bomber || entity instanceof Character) {
            return false;
        }
        return false;
    }
}
