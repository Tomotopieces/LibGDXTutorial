package io.tomoto.tutorial.sprite;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.awt.*;

/**
 * Brick
 *
 * @author Tomoto
 * @version 1.0
 * @since 1.0 2022/5/10 20:14
 */
public class Brick extends Sprite {
    public Brick(String id, int x, int y, int width, int height) {
        super(id, new Rectangle(x, y, width, height));
    }

    @Override
    public void draw(ShapeRenderer renderer) {
        renderer.setColor(Color.BLACK);
        renderer.rect(box.x - 1, box.y - 1, box.width + 2, box.height + 2);
        renderer.setColor(0.8f, 0.8f, 0.8f, 1);
        renderer.rect(box.x, box.y, box.width, box.height);
    }

    @Override
    public void update() {
    }
}
