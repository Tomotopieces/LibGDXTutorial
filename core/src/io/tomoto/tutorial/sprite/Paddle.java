package io.tomoto.tutorial.sprite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.awt.*;

/**
 * 板子
 *
 * @author Tomoto
 * @version 1.0
 * @since 1.0 2022/5/10 14:36
 */
public class Paddle extends Sprite {
    /**
     * 横向速度
     */
    private int xSpeed;

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
    public Paddle(String id, int x, int y, int width, int height, int xSpeed) {
        super(id, new Rectangle(x, y, width, height));

        this.xSpeed = xSpeed;
    }

    public void update() {
        // 输入与边界检测
        if (pressLeft() && box.x > 0) {
            box.x -= xSpeed;
        } else if (isPressRight() && box.x < Gdx.graphics.getWidth() - box.width) {
            box.x += xSpeed;
        }
    }

    /**
     * 是否按下右操作的按键
     *
     * @return 是否按下右操作的按键
     */
    private boolean isPressRight() {
        return Gdx.input.isKeyPressed(Input.Keys.RIGHT) || Gdx.input.isKeyPressed(Input.Keys.D);
    }

    /**
     * 是否按下左操作的按键
     *
     * @return 是否按下左操作的按键
     */
    private boolean pressLeft() {
        return Gdx.input.isKeyPressed(Input.Keys.LEFT) || Gdx.input.isKeyPressed(Input.Keys.A);
    }

    public void draw(ShapeRenderer renderer) {
        renderer.setColor(Color.BLACK);
        renderer.rect(box.x - 2, box.y - 2, box.width + 4, box.height + 4);
        renderer.setColor(0.8f, 0.8f, 0.8f, 1);
        renderer.rect(box.x, box.y, box.width, box.height);
    }

    public int getX() {
        return box.x;
    }

    public Paddle setX(int x) {
        this.box.x = x;
        return this;
    }

    public int getY() {
        return box.y;
    }

    public Paddle setY(int y) {
        this.box.y = y;
        return this;
    }

    public int getWidth() {
        return box.width;
    }

    public Paddle setWidth(int width) {
        this.box.width = width;
        return this;
    }

    public int getHeight() {
        return box.height;
    }

    public Paddle setHeight(int height) {
        this.box.height = height;
        return this;
    }

    public int getxSpeed() {
        return xSpeed;
    }

    public Paddle setxSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
        return this;
    }
}
