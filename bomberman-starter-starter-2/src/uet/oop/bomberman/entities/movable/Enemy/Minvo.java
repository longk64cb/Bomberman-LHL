package uet.oop.bomberman.entities.movable.Enemy;

import uet.oop.bomberman.entities.movable.Direction;
import uet.oop.bomberman.graphics.Sprite;

import java.io.FileNotFoundException;

public class Minvo extends Enemy{
    public Minvo(int xUnit, int yUnit, Sprite sprite) {
        super(xUnit, yUnit, sprite);
        direction = Direction.LEFT;
        speed = 2;
        time_navigation = 160;
    }

    @Override
    protected void afterkilled() {
        setSprite(Sprite.finalMovingSprite(Sprite.minvo_dead, Sprite.mob_dead1, Sprite.mob_dead2, Sprite.mob_dead3, vanishTime, 40));
    }

    @Override
    public void update(){
        if (!isKilled) {
            changeanimate();
            try {
                value_navigation += 1;
                if (value_navigation / time_navigation == 1) {
                    Ramdom_navigation("minvo");
                    value_navigation = 0;
                    return;
                }
                if (!move(direction, true,"minvo")) {
                    Ramdom_navigation("minvo");
                }
            } catch (FileNotFoundException e) {
                System.out.println("alfjakfajlkfa");
            }
        } else {
            afterkilled();
            if (vanishTime > 0) {
                vanishTime--;
            } else {
                remove();
            }
        }
    }
}
