package uet.oop.bomberman.entities.staticobject;

import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Sprite;

public abstract class CollideEntity extends Entity {
    public CollideEntity(int xUnit, int yUnit, Sprite sprite) {
        super(xUnit, yUnit, sprite);
    }

    @Override
    public void update() {

    }

    @Override
    public abstract boolean collide(Entity entity);
}
