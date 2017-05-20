package com.oceangamejam.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.oceangamejam.game.helper.AssetLoader;
import com.oceangamejam.game.screens.GameScreen;

public class FishOver extends Game {
	public SpriteBatch batch;
	public AssetLoader as;


	@Override
	public void create () {
		batch = new SpriteBatch();
		as = new AssetLoader();

		setScreen(new GameScreen(this));
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
