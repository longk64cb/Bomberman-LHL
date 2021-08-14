package uet.oop.bomberman.entities.movable.Enemy;

import uet.oop.bomberman.entities.movable.Direction;
import uet.oop.bomberman.graphics.Sprite;

import java.io.FileNotFoundException;
import java.util.Random;

public class Doll extends Enemy {
    public Doll(int xUnit, int yUnit, Sprite sprite) {
        super(xUnit, yUnit, sprite);
        Random rd = new Random();
        int n = rd.nextInt(2);
        speed = 4;
        if(n == 0) direction = Direction.RIGHT;
        else{
            direction = Direction.RIGHT;
        }
    }

    @Override
    protected void afterkilled() {
        setSprite(Sprite.finalMovingSprite(Sprite.doll_dead, Sprite.mob_dead1, Sprite.mob_dead2, Sprite.mob_dead3, vanishTime, 40));
    }

    @Override
    public void update(){
        if (!isKilled) {
            changeanimate();
            try {
                switch (direction){
                    case UP:
                        if(!move(Direction.UP,true,"doll")){
                            boolean f = move(Direction.DOWN,true,"doll");
                            direction = Direction.DOWN;
                        }
                        break;
                    case DOWN:
                        if(!move(Direction.DOWN,true,"doll")){
                            boolean f = move(Direction.UP,true,"doll");
                            direction = Direction.UP;
                        }
                        break;
                    case RIGHT:
                        if(!move(Direction.RIGHT,true,"doll")){
                            boolean f = move(Direction.LEFT,true,"doll");
                            direction = Direction.LEFT;
                        }
                        break;
                    case LEFT:
                        if(!move(Direction.LEFT,true,"doll")){
                            boolean f = move(Direction.RIGHT,true,"doll");
                            direction = Direction.RIGHT;
                        }
                        break;
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
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
