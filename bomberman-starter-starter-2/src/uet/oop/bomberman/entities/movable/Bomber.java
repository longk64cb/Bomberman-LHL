package uet.oop.bomberman.entities.movable;

import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.Controller.Controller;
import uet.oop.bomberman.entities.movable.Enemy.Enemy;
import uet.oop.bomberman.entities.staticobject.Bomb.Bomb;
import uet.oop.bomberman.entities.staticobject.Bomb.DirectionExplosion;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Sprite;

import java.io.FileNotFoundException;
import java.util.List;

public class Bomber extends Character {
    public static String index = "-100 -100";
    public double speed = 2;
    public double maxBomb = 1;
    public double explosionRange = 1;
    private int timebetweenplacebomb = 0;

    public Bomber(int xUnit, int yUnit, Sprite sprite) {
        super(xUnit, yUnit, sprite);
        direction = Direction.DOWN;
    }

    @Override
    public void die() {
        isKilled = true;
        playSound("bomberman-starter-starter-2/res/sound/die.wav");
    }

    @Override
    protected void afterkilled() {
        setSprite(Sprite.finalMovingSprite(Sprite.player_dead1, Sprite.player_dead2, Sprite.player_dead3, vanishTime, 30 ));
    }

//    @Override
//    protected void afterkilled() {
//        setSprite(Sprite.movingSprite(Sprite.player_dead1, Sprite.player_dead2, Sprite.player_dead3, vanishTime));
//    }

    @Override
    public void update() {
        setTimebetweenplacebomb();
        if (!isKilled) {
            changeanimate();
            this.img = this.sprite.getFxImage();
        } else {
            afterkilled();
            if (vanishTime > 0) {
                vanishTime--;
            } else {
//                remove();
                try {
                    BombermanGame.loadMap(BombermanGame.level);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void render(GraphicsContext gc) {
        gc.drawImage(img, x, y);
    }

    @Override
    public boolean collide(Entity entity) {
        if (entity instanceof DirectionExplosion || entity instanceof Enemy) {
            die();
        }
        return true;
    }
    /*
        Hàm xử lí sự kiện bấm nút của Bomber.
     */
    public void movePlayer(Scene s) throws FileNotFoundException {
        List keyboardInputs = Controller.getInputList();
        if(keyboardInputs.contains(KeyCode.UP)){
            move(Direction.UP, true);
            direction = Direction.UP;
        }
        if(keyboardInputs.contains(KeyCode.DOWN)){
            move(Direction.DOWN, true);
            direction = Direction.DOWN;
        }
        if(keyboardInputs.contains(KeyCode.LEFT)){
            move(Direction.LEFT, true);
            direction = Direction.LEFT;
        }
        if(keyboardInputs.contains(KeyCode.RIGHT)){
            move(Direction.RIGHT, true);
            direction = Direction.RIGHT;
        }
        if( !keyboardInputs.contains(KeyCode.LEFT) &&
                !keyboardInputs.contains(KeyCode.RIGHT) &&
                !keyboardInputs.contains(KeyCode.UP) &&
                !keyboardInputs.contains(KeyCode.DOWN) &&
                !keyboardInputs.contains(KeyCode.W) &&
                !keyboardInputs.contains(KeyCode.A) &&
                !keyboardInputs.contains(KeyCode.S) &&
                !keyboardInputs.contains(KeyCode.D)
        )
        {
            move(direction, false);
        }
        if(keyboardInputs.contains(KeyCode.SPACE)) {
            if (maxBomb > 0 && checkBombposition() && timebetweenplacebomb < 0) {
                placeBomb();
                maxBomb--;
            }
        }
    }
    /*
        Hàm xử lí di chuyển. Ở đây sẽ kiểm tra vị trí entity bên cạnh Bomber có cho phép bomber đi xuyên qua được không.
        Ở đây sẽ tạo 2 biến _x và _y là vị trí mới của bomber nếu bấm nút di chuyển. Ở đây sẽ gọi hàm kiểm tra xem
        Bomber có di chuyển đến vị trí _x và _y đc ko.
     */
    public void move(Direction direction, boolean moving) throws FileNotFoundException {
//        sound = new Media
        int _x = x, _y = y;
        switch (direction) {
            case UP:
                img = Sprite.player_up.getFxImage();
                if (moving) {
//                    playSound("bomberman-starter-starter-2/res/sound/move.wav");
                    _y -= speed;
                    setSprite(Sprite.movingSprite(Sprite.player_up, Sprite.player_up_1, Sprite.player_up_2, animate, 20));
                    if (moveThrough(_x, _y + 3)
                            && moveThrough(_x + 20, _y + 3)) {
                        y = _y;
                    }
                }
                break;
            case RIGHT:
                img = Sprite.player_right.getFxImage();
                if (moving) {
//                    playSound("bomberman-starter-starter-2/res/sound/move.wav");
                    _x += speed;
                    setSprite(Sprite.movingSprite(Sprite.player_right, Sprite.player_right_1, Sprite.player_right_2, animate, 20));
                    if (moveThrough(_x + 20, _y + 3)
                            && moveThrough(_x + 20, _y + 30)) {
                        x = _x;
                    }
                }
                break;
            case DOWN:
                img = Sprite.player_down.getFxImage();
                if (moving) {
//                    playSound("bomberman-starter-starter-2/res/sound/move.wav");
                    _y = (int) (y + speed);
                    setSprite(Sprite.movingSprite(Sprite.player_down, Sprite.player_down_1, Sprite.player_down_2, animate, 20));
                    if (moveThrough(_x, _y + 30)
                            && moveThrough(_x + 20, _y + 30)) {
                        y = _y;
                    }
                }
                break;
            case LEFT:
                img = Sprite.player_left.getFxImage();
                if (moving) {
//                    playSound("bomberman-starter-starter-2/res/sound/move.wav");
                    _x = (int) (x - speed);
                    setSprite(Sprite.movingSprite(Sprite.player_left, Sprite.player_left_1, Sprite.player_left_2, animate, 20));
                    if (moveThrough(_x, _y + 3)
                            && moveThrough(_x, _y + 30)) {
                        x = _x;
                    }
                }
                break;
        }
    }
    /*
        Hàm kiểm tra bomber có di chuyển đến _x và _y đc ko.
        GetStillObject sẽ kiểm tra ở vị trí _x và _y sẽ có entity nào, và kiểm tra hàm Collide của Entity đó
        có cho phép nhân vật đi qua được không.
     */
    public boolean moveThrough(int x, int y) {
        int _x = x / Sprite.SCALED_SIZE;
        int _y = y / Sprite.SCALED_SIZE;
        Entity s = BombermanGame.getStillObjects(_x, _y, this);
        int a = this.getX() / Sprite.SCALED_SIZE;
        int b = this.getY() / Sprite.SCALED_SIZE;
        index = String.format("%s %s", a, b);
        if(!s.collide(this)) {
            return false;
        }
        return true;
    }
    /*
        Đặt bom.
     */
    public void placeBomb() {
        Entity bomb = new Bomb((this.x + 16) / Sprite.SCALED_SIZE, (this.y + 16) / Sprite.SCALED_SIZE, Sprite.bomb, (int) explosionRange);
        BombermanGame.bombs.add(bomb);
        timebetweenplacebomb = 15;
        playSound("bomberman-starter-starter-2/res/sound/placebomb.wav");
    }
    /*
        Hàm kiểm tra xem ở vị trí Bomber đã có bom chưa, nếu đã có Bomber không thể đặt bom được.
     */
    public boolean checkBombposition() {
        int _x = (x + 16) / Sprite.SCALED_SIZE;
        int _y = (y + 19) / Sprite.SCALED_SIZE;
        Entity s = BombermanGame.getStillObjects(_x, _y, this);
        if (s instanceof Bomb) {
            return false;
        }
        return true;
    }

    /*
        Set thời gian cho phép đặt bom 2 lần liên tiếp.
     */
    private void setTimebetweenplacebomb() {
        if(timebetweenplacebomb < -7500) {
            timebetweenplacebomb = 0;
        } else {
            timebetweenplacebomb--;
        }
    }
}
