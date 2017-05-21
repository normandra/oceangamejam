package com.oceangamejam.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.oceangamejam.game.helper.AssetLoader;
import com.oceangamejam.game.screens.GameScreen;
import com.oceangamejam.game.screens.MainMenuScreen;

public class FishOver extends Game {
	public SpriteBatch batch;
	public AssetLoader as;

	public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;

	@Override
	public void create () {
		batch = new SpriteBatch();
		as = new AssetLoader();


		setScreen(new MainMenuScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		as.dispose();
	}
}
