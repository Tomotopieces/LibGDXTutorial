package io.tomoto.tutorial.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

/**
 * 玩家输入管理器
 *
 * @author Tomoto
 * @version 1.0
 * @since 1.0 2022/5/11 11:10
 */
public class InputManager {
    /**
     * 是否按下右操作的按键
     *
     * @return 是否按下右操作的按键
     */
    public static boolean isPressRight() {
        return Gdx.input.isKeyPressed(Input.Keys.RIGHT) || Gdx.input.isKeyPressed(Input.Keys.D);
    }

    /**
     * 是否按下左操作的按键
     *
     * @return 是否按下左操作的按键
     */
    public static boolean isPressLeft() {
        return Gdx.input.isKeyPressed(Input.Keys.LEFT) || Gdx.input.isKeyPressed(Input.Keys.A);
    }
}
