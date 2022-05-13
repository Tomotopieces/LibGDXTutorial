package io.tomoto.tutorial.scene;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import io.tomoto.tutorial.BreakBricks;
import io.tomoto.tutorial.sprite.Ball;
import io.tomoto.tutorial.sprite.Brick;
import io.tomoto.tutorial.sprite.GeometricSprite;
import io.tomoto.tutorial.sprite.Paddle;
import io.tomoto.tutorial.utils.InputManager;

import java.util.*;

/**
 * 游戏场景
 *
 * @author Tomoto
 * @version 1.0
 * @since 1.0 2022/5/10 21:30
 */
public class GameScene implements Screen {
    /**
     * game
     */
    private final BreakBricks game;

    /**
     * 相机
     */
    private final OrthographicCamera camera;

    /**
     * 集合渲染器
     */
    private final ShapeRenderer shapeRenderer;

    /**
     * 渲染元素map
     */
    private final Map<String, GeometricSprite> renderSpriteMap = new HashMap<>();

    /**
     * 待移除元素id集合
     */
    private final Set<String> removeSet = new HashSet<>();

    /**
     * 板子
     */
    private final Paddle paddle;

    /**
     * 球
     */
    private final Ball ball;

    /**
     * 砖块
     */
    private final List<Brick> bricks = new ArrayList<>();

    /**
     * 构造初始化
     *
     * @param game game
     */
    public GameScene(BreakBricks game) {
        // 游戏基本数据
        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 540, 960);
        shapeRenderer = new ShapeRenderer();

        // 游戏内容数据
        paddle = new Paddle("paddle", (Gdx.graphics.getWidth() - 120) / 2, 20, 120, 15, 10);
        ball = new Ball("ball", Gdx.graphics.getWidth() / 2, 100, 20, 5, 5, paddle);
        int brickWidth = 60;
        int brickHeight = 10;
        for (int y = Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 4; y < Gdx.graphics.getHeight() - 50; y += brickHeight + 10) {
            for (int x = 0; x < Gdx.graphics.getWidth(); x += brickWidth + 10) {
                bricks.add(new Brick("brick-" + x + y, x, y, brickWidth, brickHeight));
            }
        }

        // 将渲染元素添加至渲染map中
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
        // 画面渲染与输入逻辑
        ScreenUtils.clear(0.3f, 0.3f, 0.3f, 1);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        for (String id : removeSet) { // 渲染前移除待移除元素
            renderSpriteMap.remove(id);
        }
        for (GeometricSprite sprite : renderSpriteMap.values()) {
            if (!sprite.isEnabled()) {
                continue;
            }
            sprite.update(); // 包含输入逻辑
            sprite.draw(shapeRenderer);
        }
        shapeRenderer.end();

        // 逻辑检查
        // 球与砖块碰撞检查
        for (Brick brick : bricks) {
            if (!brick.isEnabled()) {
                continue;
            }
            if (ball.collidesWithBrick(brick)) {
                brick.setEnabled(false);
                ball.setySpeed(-ball.getySpeed());
                break;
            }
        }
        // 球与板子碰撞检查
        if (ball.collidesWithPaddle()) {
            ball.setySpeed(-ball.getySpeed());
            if (InputManager.isPressRight()) {
                ball.setxSpeed(ball.getxSpeed() + 1);
            } else if (InputManager.isPressLeft()) {
                ball.setxSpeed(ball.getxSpeed() - 1);
            }
        }
        // 胜利检查
        if (bricks.stream().noneMatch(GeometricSprite::isEnabled)) {
            game.setScreen(new TitleScene(game, "YOU WIN!", "PRESS ANY KEY TO RESTART"));
            dispose();
        }
        // 失败检查
        if (!ball.isEnabled()) {
            game.setScreen(new TitleScene(game, "GAME OVER!", "PRESS ANY KEY TO RESTART"));
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

    /**
     * 添加渲染元素
     *
     * @param sprite 元素
     */
    public void addRenderSprite(GeometricSprite sprite) {
        renderSpriteMap.put(sprite.getId(), sprite);
    }

    /**
     * 移除渲染元素
     *
     * @param id 元素id
     */
    public void removeRenderSprite(String id) {
        removeSet.add(id);
    }
}
