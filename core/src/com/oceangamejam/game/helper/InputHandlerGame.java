package com.oceangamejam.game.helper;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.oceangamejam.game.FishOver;
import com.oceangamejam.game.gameobjects.Objects;
import com.oceangamejam.game.gameobjects.Ship;

/**
 * Created by norman on 5/20/17.
 */

public class InputHandlerGame implements InputProcessor {

    private Ship player;
    private FishOver fo;

    public InputHandlerGame(Ship player, FishOver fishOver){
        this.player = player;
        this.fo = fishOver;
    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode)
        {
            case Input.Keys.LEFT:
                player.setLeftMove(true);
                break;

            case Input.Keys.RIGHT:
                player.setRightMove(true);
                break;

            case Input.Keys.UP:
                player.setUpMove(true);
                break;

            case Input.Keys.DOWN:
                player.setDownMove(true);
                break;
        }
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
    	switch (keycode)
        {
            case Input.Keys.LEFT:
                player.setLeftMove(false);
                break;

            case Input.Keys.RIGHT:
                player.setRightMove(false);
                break;

            case Input.Keys.UP:
                player.setUpMove(false);
                break;

            case Input.Keys.DOWN:
                player.setDownMove(false);
                break;
        }
        return true;
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
