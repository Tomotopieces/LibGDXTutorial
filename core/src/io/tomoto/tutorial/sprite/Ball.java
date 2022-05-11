package io.tomoto.tutorial.sprite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.awt.*;
import java.util.List;

/**
 * 球
 *
 * @author Tomoto
 * @version 1.0
 * @since 1.0 2022/5/10 9:27
 */
public class Ball extends Sprite {
    /**
     * 半径
     */
    private int radius;
    /**
     * 横向速度
     */
    private int xSpeed;
    /**
     * 纵向速度
     */
    private int ySpeed;

    /**
     * 板子
     */
    private Paddle paddle;

    /**
     * @param id     id
     * @param x      横轴坐标
     * @param y      纵轴坐标
     * @param radius 半径
     * @param xSpeed 横向速度
     * @param ySpeed 纵向速度
     * @param paddle 板子
     */
    public Ball(String id, int x, int y, int radius, int xSpeed, int ySpeed, Paddle paddle) {
        super(id, new Rectangle(x, y, radius * 2, radius * 2));

        this.radius = radius;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.paddle = paddle;
    }

    public void update() {
        box.x += xSpeed;
        box.y += ySpeed;
        if (box.x < radius || box.x > Gdx.graphics.getWidth() - radius) {
            xSpeed *= -1;
        }
        if (box.y > Gdx.graphics.getHeight() - radius || collidesWithPaddle()) {
            ySpeed *= -1;
        }
        if (box.y < radius) {
            setEnabled(false);
        }
    }

    public void draw(ShapeRenderer shape) {
        shape.setColor(Color.BLACK);
        shape.circle(box.x, box.y, radius + 2);
        shape.setColor(0.8f, 0.8f, 0.8f, 1);
        shape.circle(box.x, box.y, radius);
    }

    /**
     * 是否与板子发生碰撞
     *
     * @return 是否与板子发生碰撞
     */
    private boolean collidesWithPaddle() {
        return box.y - radius < paddle.getY() + paddle.getHeight() && box.y > paddle.getY() &&
                box.x >= paddle.getX() && box.x <= paddle.getX() + paddle.getWidth();
    }

    /**
     * 处理与砖块发生的碰撞
     *
     * @param bricks 砖块数组
     */
    public void handleCollidesWithBrick(List<Brick> bricks) {
        for (Brick brick : bricks) {
            if (!brick.isEnabled()) { // 忽略未启用的砖块
                continue;
            }
            if (box.x + radius >= brick.box.x && box.x - radius <= brick.box.x + brick.box.width &&
                    box.y + radius >= brick.box.y && box.y - radius <= brick.box.y + brick.box.height) {
                brick.setEnabled(false);
                ySpeed *= -1;
                break;
            }
        }
    }

    public int getX() {
        return box.x;
    }

    public Ball setX(int x) {
        this.box.x = x;
        return this;
    }

    public int getY() {
        return box.y;
    }

    public Ball setY(int y) {
        this.box.y = y;
        return this;
    }

    public int getRadius() {
        return radius;
    }

    public Ball setRadius(int radius) {
        this.radius = radius;
        return this;
    }

    public int getxSpeed() {
        return xSpeed;
    }

    public Ball setxSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
        return this;
    }

    public int getySpeed() {
        return ySpeed;
    }

    public Ball setySpeed(int ySpeed) {
        this.ySpeed = ySpeed;
        return this;
    }

    public Paddle getPaddle() {
        return paddle;
    }

    public Ball setPaddle(Paddle paddle) {
        this.paddle = paddle;
        return this;
    }
}
