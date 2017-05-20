package com.oceangamejam.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.oceangamejam.game.FishOver;

/**
 * Created by norman on 5/20/17.
 */

public class MainMenuSceen implements Screen{

    FishOver game;
    
    Texture playButtonActive;
    Texture playButtonInactive;
    Texture exitButtonActive;
    Texture exitButtonInactive;

    private static final int EXIT_BUTTON_WIDTH = 150;
    private static final int EXIT_BUTTON_HEIGHT = 75;
    private static final int PLAY_BUTTON_WIDTH = 150;
    private static final int PLAY_BUTTON_HEIGHT = 75;
    
    public MainMenuSceen(FishOver game){
        this.game = game;
        
        playButtonActive = new Texture("play_button_active.png");
	playButtonInactive = new Texture("play_button_inactive.png");
	exitButtonActive = new Texture("exit_button_active.png");
	exitButtonInactive = new Texture("exit_button_inactive.png");
        
        
        
    }
    
    @Override
    public void show() {
     
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.15f, 0.15f, 0.3f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		game.batch.begin();
                
                
                int x = Gdx.graphics.getWidth() / 2 - PLAY_BUTTON_WIDTH / 2;
                int y = Gdx.graphics.getHeight() / 2 + PLAY_BUTTON_HEIGHT / 2 ;
                if(Gdx.input.getX() < x + PLAY_BUTTON_WIDTH && Gdx.input.getX() > x && 
                   Gdx.graphics.getHeight() - Gdx.input.getY() < y + PLAY_BUTTON_HEIGHT && Gdx.graphics.getHeight() - Gdx.input.getY() > y){
                    game.batch.draw(playButtonInactive, x, y, PLAY_BUTTON_WIDTH, PLAY_BUTTON_HEIGHT);
                    if(Gdx.input.isTouched()){
                        this.dispose();
                        game.setScreen(new GameScreen(game));
                    }
                }else{
                    game.batch.draw(playButtonActive, x, y, PLAY_BUTTON_WIDTH, PLAY_BUTTON_HEIGHT);
                }
                x = Gdx.graphics.getWidth() / 2 - EXIT_BUTTON_WIDTH / 2;
                y = Gdx.graphics.getHeight() / 2 - EXIT_BUTTON_HEIGHT / 2;
                if(Gdx.input.getX() < x + EXIT_BUTTON_WIDTH && Gdx.input.getX() > x && 
                   Gdx.graphics.getHeight() - Gdx.input.getY() < y + EXIT_BUTTON_HEIGHT && Gdx.graphics.getHeight() - Gdx.input.getY() > y){
                    game.batch.draw(exitButtonInactive, x, y, EXIT_BUTTON_WIDTH, EXIT_BUTTON_HEIGHT);
                    if(Gdx.input.isTouched()){
                        Gdx.app.exit();
                    }
                }else{
                    game.batch.draw(exitButtonActive, x, y, EXIT_BUTTON_WIDTH, EXIT_BUTTON_HEIGHT);
                }
                game.batch.end();
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
