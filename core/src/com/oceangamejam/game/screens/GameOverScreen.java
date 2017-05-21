/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oceangamejam.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.oceangamejam.game.FishOver;

/**
 *
 * @author Myri
 */
public class GameOverScreen implements Screen{
    private Viewport viewport;
    private Stage stage;
    
    private FishOver game;
    
    private BitmapFont font;
    private SpriteBatch batch;
    
    public GameOverScreen(FishOver game){
        this.game = game;
        batch = new SpriteBatch();
        viewport = new FitViewport(Gdx.graphics.getWidth(),Gdx.graphics.getHeight(), new OrthographicCamera());
        stage = new Stage(viewport, ((FishOver)game).batch);
        
        font = new BitmapFont();
        font.getData().setScale(3,3);
        
        Label.LabelStyle fontx = new Label.LabelStyle(font,Color.WHITE);
        Table table = new Table();
        table.center();
        table.setFillParent(true);
        
        Label gameOverLabel = new Label("GAME OVER. "+ GameScreen.endMessage, fontx);
        Label playAgainLabel = new Label("Press Space to Play Again", fontx);
        
        
        table.add(gameOverLabel).expandX();
        table.row();
        table.add(playAgainLabel).expandX().padTop(10f);
        
        stage.addActor(table);
    }
    
    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        if(Gdx.input.isKeyPressed(Keys.SPACE)){
            game.setScreen(new GameScreen((FishOver) game));
            dispose();
        }
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        game.batch.draw(game.as.endbg,0,0,game.WIDTH,game.HEIGHT);
        game.batch.end();

        stage.draw();


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
