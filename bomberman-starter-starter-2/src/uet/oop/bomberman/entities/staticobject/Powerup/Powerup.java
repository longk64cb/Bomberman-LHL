package uet.oop.bomberman.entities.staticobject.Powerup;

import uet.oop.bomberman.entities.staticobject.CollideEntity;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Sprite;

public class Powerup extends CollideEntity {
    public Powerup(int xUnit, int yUnit, Sprite sprite) {
        super(xUnit, yUnit, sprite);
    }

    @Override
    public boolean collide(Entity entity) {
        return false;
    }
}
