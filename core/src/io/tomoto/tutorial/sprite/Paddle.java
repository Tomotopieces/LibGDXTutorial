package io.tomoto.tutorial.sprite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.awt.*;

/**
 * Paddle
 *
 * @author Tomoto
 * @version 1.0
 * @since 1.0 2022/5/10 14:36
 */
public class Paddle extends Sprite {
    private int xSpeed;

    public Paddle(String id, int x, int y, int width, int height, int xSpeed) {
        super(id, new Rectangle(x, y, width, height));

        this.xSpeed = xSpeed;
    }

    public void update() {
        if (pressLeft() && box.x > 0) {
            box.x -= xSpeed;
        } else if (pressRight() && box.x < Gdx.graphics.getWidth() - box.width) {
            box.x += xSpeed;
        }
    }

    private boolean pressRight() {
        return Gdx.input.isKeyPressed(Input.Keys.RIGHT) || Gdx.input.isKeyPressed(Input.Keys.D);
    }

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
