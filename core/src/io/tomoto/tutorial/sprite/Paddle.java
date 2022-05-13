package io.tomoto.tutorial.sprite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import io.tomoto.tutorial.utils.InputManager;

/**
 * 板子
 *
 * @author Tomoto
 * @version 1.0
 * @since 1.0 2022/5/10 14:36
 */
public class Paddle extends GeometricSprite {
    /**
     * 横向速度
     */
    private float xSpeed;

    /**
     * 构造初始化
     *
     * @param id     id
     * @param x      横轴坐标
     * @param y      纵轴坐标
     * @param width  宽度
     * @param height 高度
     * @param xSpeed 横向速度
     */
    public Paddle(String id, float x, float y, float width, float height, float xSpeed) {
        super(id, new Rectangle(x, y, width, height));

        this.xSpeed = xSpeed;
    }

    public void update() {
        // 输入与边界检测
        if (InputManager.isPressLeft() && box.x > 0) {
            box.x -= xSpeed;
        } else if (InputManager.isPressRight() && box.x < Gdx.graphics.getWidth() - box.width) {
            box.x += xSpeed;
        }
    }

    public void draw(ShapeRenderer renderer) {
        renderer.setColor(Color.BLACK);
        renderer.rect(box.x - 2, box.y - 2, box.width + 4, box.height + 4);
        renderer.setColor(0.8f, 0.8f, 0.8f, 1);
        renderer.rect(box.x, box.y, box.width, box.height);
    }

    public float getX() {
        return box.x;
    }

    public Paddle setX(float x) {
        this.box.x = x;
        return this;
    }

    public float getY() {
        return box.y;
    }

    public Paddle setY(float y) {
        this.box.y = y;
        return this;
    }

    public float getWidth() {
        return box.width;
    }

    public Paddle setWidth(float width) {
        this.box.width = width;
        return this;
    }

    public float getHeight() {
        return box.height;
    }

    public Paddle setHeight(float height) {
        this.box.height = height;
        return this;
    }

    public float getxSpeed() {
        return xSpeed;
    }

    public Paddle setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
        return this;
    }
}
