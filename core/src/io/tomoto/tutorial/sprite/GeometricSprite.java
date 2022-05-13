package io.tomoto.tutorial.sprite;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

/**
 * 几何Sprite
 *
 * @author Tomoto
 * @version 1.0
 * @since 1.0 2022/5/10 14:56
 */
public abstract class GeometricSprite {
    /**
     * id
     */
    private String id;

    /**
     * 是否启用
     */
    private boolean enabled;

    /**
     * 坐标与尺寸
     */
    protected Rectangle box;

    /**
     * 构造初始化
     *
     * @param id  id
     * @param box 坐标与尺寸
     */
    public GeometricSprite(String id, Rectangle box) {
        this.box = box;
        this.id = id;
        this.enabled = true;
    }

    /**
     * 绘制
     *
     * @param renderer 几何渲染器
     */
    public abstract void draw(ShapeRenderer renderer);

    /**
     * 更新
     */
    public abstract void update();

    public String getId() {
        return id;
    }

    public GeometricSprite setId(String id) {
        this.id = id;
        return this;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public GeometricSprite setEnabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }
}
