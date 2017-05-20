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

    public Texture playButtonActive,playButtonInactive,exitButtonActive,exitButtonInactive;
    
    public Texture mainMenuBackground;

    public AssetLoader(){

        //boat textureRegion
        left = new Texture("BoatySprites/west.png");
        right = new Texture("BoatySprites/ost.png");
        down = new Texture("BoatySprites/south.png");
        up = new Texture("BoatySprites/nord.png");

        duleft = new Texture("BoatySprites/nord-west.png");
        duright = new Texture("BoatySprites/nord-ost.png");
        ddright = new Texture("BoatySprites/south-east.png");
        ddleft = new Texture("BoatySprites/south-west.png");

        playButtonActive = new Texture("PlayNormal.png");
        playButtonInactive = new Texture("PlayHover.png");
        exitButtonActive = new Texture("ExitNormal.png");
        exitButtonInactive = new Texture("ExitHover.png");
        
        mainMenuBackground = new Texture("map01.png");

    }

    public void dispose() {
        left.dispose();
        right.dispose();
        down.dispose();
        up.dispose();

        duleft.dispose();
        duright.dispose();
        ddright.dispose();
        ddleft.dispose();

        playButtonActive.dispose();
        playButtonInactive.dispose();
        exitButtonActive.dispose();
        exitButtonInactive.dispose();
        
        mainMenuBackground.dispose();

    }

}
