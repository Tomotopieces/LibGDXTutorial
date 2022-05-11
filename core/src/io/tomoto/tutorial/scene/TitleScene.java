package io.tomoto.tutorial.scene;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import io.tomoto.tutorial.BreakBricks;

/**
 * 标题场景
 *
 * @author Tomoto
 * @version 1.0
 * @since 1.0 2022/5/10 21:24
 */
public class TitleScene implements Screen {

    /**
     * game
     */
    private final BreakBricks game;

    /**
     * 渲染器
     */
    private final SpriteBatch batch;

    /**
     * 相机
     */
    private final OrthographicCamera camera;

    /**
     * 标题信息
     */
    private final String title;

    /**
     * 提示信息
     */
    private final String hint;

    /**
     * 构造初始化
     *
     * @param game  game
     * @param title 标题信息
     * @param hint  提示信息
     */
    public TitleScene(final BreakBricks game, String title, String hint) {
        this.game = game;
        batch = game.getBatch();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 540 / 2, 960 / 2);

        this.title = title;
        this.hint = hint;
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0.3f, 0.3f, 0.3f, 1);

        GlyphLayout titleLayout = new GlyphLayout(game.getFont(), title);
        GlyphLayout hintLayout = new GlyphLayout(game.getFont(), hint);
        float titleX = (Gdx.graphics.getWidth() - titleLayout.width) / 2;
        float hintX = (Gdx.graphics.getWidth() - hintLayout.width) / 2;
        batch.begin();
        game.getFont().draw(batch, titleLayout, titleX, 800);
        game.getFont().draw(batch, hintLayout, hintX, 400);
        batch.end();

        if (Gdx.input.isKeyPressed(Input.Keys.ANY_KEY)) {
            game.setScreen(new GameScene(game));
            dispose();
        }
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void dispose() {
    }
}
