package io.tomoto.tutorial.sprite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

/**
 * 球
 *
 * @author Tomoto
 * @version 1.0
 * @since 1.0 2022/5/10 9:27
 */
public class Ball extends GeometricSprite {
    /**
     * 半径
     */
    private float radius;
    /**
     * 横向速度
     */
    private float xSpeed;
    /**
     * 纵向速度
     */
    private float ySpeed;

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
    public Ball(String id, float x, float y, float radius, float xSpeed, float ySpeed, Paddle paddle) {
        super(id, new Rectangle(x, y, radius * 2, radius * 2));

        this.radius = radius;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.paddle = paddle;
    }

    public void update() {
        box.x += xSpeed;
        box.y += ySpeed;
        if (box.x < 0 || box.x > Gdx.graphics.getWidth() - radius * 2) {
            xSpeed *= -1;
        }
        if (box.y > Gdx.graphics.getHeight() - radius * 2) {
            ySpeed *= -1;
        }
        if (box.y < radius) {
            setEnabled(false);
        }
    }

    public void draw(ShapeRenderer shape) {
        shape.setColor(Color.BLACK);
        shape.circle(box.x + radius, box.y + radius, radius + 2);
        shape.setColor(0.8f, 0.8f, 0.8f, 1);
        shape.circle(box.x + radius, box.y + radius, radius);
    }

    /**
     * 是否与板子发生碰撞
     *
     * @return 是否与板子发生碰撞
     */
    public boolean collidesWithPaddle() {
        return paddle.box.overlaps(box);
    }

    public boolean collidesWithBrick(Brick brick) {
        return brick.box.overlaps(box);
    }

    public float getX() {
        return box.x;
    }

    public Ball setX(float x) {
        this.box.x = x;
        return this;
    }

    public float getY() {
        return box.y;
    }

    public Ball setY(float y) {
        this.box.y = y;
        return this;
    }

    public float getRadius() {
        return radius;
    }

    public Ball setRadius(float radius) {
        this.radius = radius;
        return this;
    }

    public float getxSpeed() {
        return xSpeed;
    }

    public Ball setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
        return this;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public Ball setySpeed(float ySpeed) {
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
