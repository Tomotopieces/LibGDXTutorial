package io.tomoto.tutorial;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import io.tomoto.tutorial.scene.TitleScene;

/**
 * 打砖块
 */
public class BreakBricks extends Game {

    /**
     * 字体
     */
    private BitmapFont font;

    /**
     * 渲染器
     */
    private SpriteBatch batch;

    @Override
    public void create() {
        FreeTypeFontGenerator fontGenerator = new FreeTypeFontGenerator(Gdx.files.internal("font.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter fontParameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        fontParameter.size = 25;
        fontParameter.color = Color.WHITE;
        fontParameter.borderWidth = 2;
        fontParameter.borderColor = Color.BLACK;
        font = fontGenerator.generateFont(fontParameter);
        fontGenerator.dispose();

        batch = new SpriteBatch();
        this.setScreen(new TitleScene(this, "BREAK BRICKS", "PRESS ANY KEY TO START"));
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
