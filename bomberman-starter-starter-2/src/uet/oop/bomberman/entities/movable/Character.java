package uet.oop.bomberman.entities.movable;

import uet.oop.bomberman.graphics.Sprite;

public abstract class Character extends AnimationEntity {
    protected boolean isKilled = false;
    protected int vanishTime = 30;

    public Character(int xUnit, int yUnit, Sprite sprite) {
        super(xUnit, yUnit, sprite);
    }

    public abstract void die();

    protected abstract void afterkilled();

    public boolean isKilled() {
        return isKilled;
    }

    public void setKilled(boolean killed) {
        isKilled = killed;
    }
}
