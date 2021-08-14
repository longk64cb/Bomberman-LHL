package uet.oop.bomberman.entities;

import javafx.scene.canvas.GraphicsContext;
import uet.oop.bomberman.graphics.Render;

import java.util.ArrayList;
import java.util.List;

public class EntityList implements Render {
    private List<Entity> entities = new ArrayList<>();
    private List<Entity> stillObjects = new ArrayList<>();

    @Override
    public void update() {

    }

    @Override
    public void render(GraphicsContext gc) {

    }
}
