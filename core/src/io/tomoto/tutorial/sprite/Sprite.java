package io.tomoto.tutorial.sprite;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.awt.*;

/**
 * Sprite
 *
 * @author Tomoto
 * @version 1.0
 * @since 1.0 2022/5/10 14:56
 */
public abstract class Sprite {
    private String id;

    private boolean enabled;

    protected Rectangle box;

    public Sprite(String id, Rectangle box) {
        this.box = box;
        this.id = id;
        this.enabled = true;
    }

    public abstract void draw(ShapeRenderer renderer);

    public abstract void update();

    public String getId() {
        return id;
    }

    public Sprite setId(String id) {
        this.id = id;
        return this;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public Sprite setEnabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }
}
