package uet.oop.bomberman.entities.movable;


import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Sprite;

public abstract class AnimationEntity extends Entity {

    protected int animate = 0;
    protected Direction direction;

    public AnimationEntity(int xUnit, int yUnit, Sprite sprite) {
        super(xUnit, yUnit, sprite);
    }

//    @Override
//    public void update() {
//        changeanimate();
//        this.img = sprite.getFxImage();
//    }

    protected void changeanimate() {
        if(animate < 7500) animate++; else animate = 0;
    }


}
