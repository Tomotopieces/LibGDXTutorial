package io.tomoto.tutorial.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import io.tomoto.tutorial.Tutorial;

/**
 * 标题场景
 *
 * @author Tomoto
 * @version 1.0
 * @since 1.0 2022/5/10 21:24
 */
public class TitleScreen implements Screen {

    private final Tutorial game;

    private final SpriteBatch batch;

    private final OrthographicCamera camera;

    private final String title;

    private final String hint;

    public TitleScreen(final Tutorial game, String title, String hint) {
        this.game = game;
        batch = game.getBatch();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 540, 960);

        this.title = title;
        this.hint = hint;
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0.3f, 0.3f, 0.3f, 1);

        batch.begin();
        game.getFont().draw(batch, title, 200, 800);
        game.getFont().draw(batch, hint, 200, 400);
        batch.end();

        if (Gdx.input.isKeyPressed(Input.Keys.ANY_KEY)) {
            game.setScreen(new GameScreen(game));
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
