package io.tomoto.tutorial;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import io.tomoto.tutorial.screen.TitleScreen;

/**
 * The game
 */
public class Tutorial extends Game {

    private BitmapFont font;
    private SpriteBatch batch;

    @Override
    public void create() {
        font = new BitmapFont();
        batch = new SpriteBatch();
        this.setScreen(new TitleScreen(this, "Break Bricks", "Press any key to start"));
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        font.dispose();
        batch.dispose();
    }

    public SpriteBatch getBatch() {
        return batch;
    }

    public BitmapFont getFont() {
        return font;
    }
}
