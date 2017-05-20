package com.oceangamejam.game.helper;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by norman on 5/20/17.
 */

public class AssetLoader {

    public AssetManager assets;


    // Assets

    public Texture img;

    public AssetLoader(){
        assets = new AssetManager();
        img = new Texture("badlogic.jpg");
    }

    public void dispose() {
        img.dispose();
    }

}
