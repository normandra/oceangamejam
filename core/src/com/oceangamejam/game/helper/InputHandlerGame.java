package com.oceangamejam.game.helper;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.oceangamejam.game.gameobjects.Objects;

/**
 * Created by norman on 5/20/17.
 */

public class InputHandlerGame implements InputProcessor {

    private Objects player;

    public InputHandlerGame(Objects player){
        this.player = player;
    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode)
        {
            case Input.Keys.LEFT:
                player.setX(player.getX() - 10);
                break;

            case Input.Keys.RIGHT:
                player.setX(player.getX() + 10);
                break;

            case Input.Keys.UP:
                player.setY(player.getY() + 10);
                break;

            case Input.Keys.DOWN:
                player.setY(player.getY() - 10);
                break;
        }
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
