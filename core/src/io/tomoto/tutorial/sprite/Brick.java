package io.tomoto.tutorial.sprite;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

/**
 * 砖块
 *
 * @author Tomoto
 * @version 1.0
 * @since 1.0 2022/5/10 20:14
 */
public class Brick extends GeometricSprite {
    /**
     * 构造初始化
     *
     * @param id     id
     * @param x      横轴坐标
     * @param y      纵轴坐标
     * @param width  宽度
     * @param height 高度
     */
    public Brick(String id, float x, float y, float width, float height) {
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
