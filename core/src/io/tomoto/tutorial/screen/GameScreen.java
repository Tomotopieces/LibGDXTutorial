package io.tomoto.tutorial.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import io.tomoto.tutorial.Tutorial;
import io.tomoto.tutorial.sprite.Ball;
import io.tomoto.tutorial.sprite.Brick;
import io.tomoto.tutorial.sprite.Paddle;
import io.tomoto.tutorial.sprite.Sprite;

import java.util.*;

/**
 * 游戏场景
 *
 * @author Tomoto
 * @version 1.0
 * @since 1.0 2022/5/10 21:30
 */
public class GameScreen implements Screen {
    private final Tutorial game;

    private final OrthographicCamera camera;

    private final ShapeRenderer shapeRenderer;

    private final Map<String, Sprite> spriteMap = new HashMap<>();

    private final Set<String> removeSet = new HashSet<>();

    private final Paddle paddle;

    private final Ball ball;

    private final List<Brick> bricks = new ArrayList<>();

    public GameScreen(Tutorial game) {
        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 540, 960);
        shapeRenderer = new ShapeRenderer();

        paddle = new Paddle("paddle", (Gdx.graphics.getWidth() - 120) / 2, 20, 120, 15, 10);
        ball = new Ball("ball", Gdx.graphics.getWidth() / 2, 100, 20, 5, 5, paddle);

        int brickWidth = 60;
        int brickHeight = 10;
        for (int y = Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 4; y < Gdx.graphics.getHeight(); y += brickHeight + 10) {
            for (int x = 0; x < Gdx.graphics.getWidth(); x += brickWidth + 10) {
                bricks.add(new Brick("brick-" + x + y, x, y, brickWidth, brickHeight));
            }
        }

        addRenderSprite(paddle);
        addRenderSprite(ball);
        for (Brick brick : bricks) {
            addRenderSprite(brick);
        }
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0.3f, 0.3f, 0.3f, 1);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        for (String id : removeSet) {
            spriteMap.remove(id);
        }
        for (Sprite sprite : spriteMap.values()) {
            if (!sprite.isEnabled()) {
                continue;
            }
            sprite.update();
            sprite.draw(shapeRenderer);
        }
        shapeRenderer.end();

        ball.collidesWithBrick(bricks);
        if (bricks.stream().noneMatch(Sprite::isEnabled)) {
            game.setScreen(new TitleScreen(game, "You win", "Press any key to restart"));
            dispose();
        }
        if (!ball.isEnabled()) {
            game.setScreen(new TitleScreen(game, "Game over", "Press any key to restart"));
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

    public void addRenderSprite(Sprite sprite) {
        spriteMap.put(sprite.getId(), sprite);
    }

    public void removeRenderSprite(String id) {
        removeSet.add(id);
    }
}
