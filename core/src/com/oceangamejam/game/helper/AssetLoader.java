package com.oceangamejam.game.helper;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by norman on 5/20/17.
 */

public class AssetLoader {

    public AssetManager assets;


    // Assets

    public Texture img;
    public Texture left, duleft, up, duright,right,ddright,down,ddleft;

    public AssetLoader(){
        assets = new AssetManager();
        img = new Texture("badlogic.jpg");

        //boat textureRegion
        left = new Texture("BoatySprites/west.png");
        right = new Texture("BoatySprites/ost.png");
        down = new Texture("BoatySprites/south.png");
        up = new Texture("BoatySprites/nord.png");

        duleft = new Texture("BoatySprites/nord-west.png");
        duright = new Texture("BoatySprites/nord-ost.png");
        ddright = new Texture("BoatySprites/south-east.png");
        ddleft = new Texture("BoatySprites/south-west.png");
    }

    public void dispose() {
        img.dispose();
    }

}
