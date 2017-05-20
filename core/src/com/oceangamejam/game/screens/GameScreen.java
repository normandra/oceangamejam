package com.oceangamejam.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.oceangamejam.game.FishOver;
import com.oceangamejam.game.gameobjects.Ship;
import com.oceangamejam.game.helper.InputHandlerGame;

/**
 * Created by norman on 5/20/17.
 */




public class GameScreen implements Screen {
    private FishOver fishOver;
    private InputHandlerGame ip;

    private Ship player;

    int x,y;

    public GameScreen(FishOver fishOver) {
        this.fishOver = fishOver;

        player = new Ship(10,10, fishOver.as.img);

        ip = new InputHandlerGame(player);

        Gdx.input.setInputProcessor(ip);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        fishOver.batch.begin();
        fishOver.batch.draw(player.getCurrent(), player.getX(), player.getY());
        fishOver.batch.end();

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
