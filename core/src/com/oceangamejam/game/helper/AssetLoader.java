package com.oceangamejam.game.helper;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
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


    private Texture sardineTexture;
    public Animation<TextureRegion> sardines;



    public AssetLoader(){

        //fish
        sardineTexture = new Texture("fish/TinyFishAnimation4Frames.png");
        TextureRegion[][] tmp = TextureRegion.split(sardineTexture, sardineTexture.getWidth()/4,sardineTexture.getHeight());
        TextureRegion[] sardineFrames = new TextureRegion[4];
        int index = 0;
        for (int i = 0; i < 4; i++) {
            sardineFrames[index++] = tmp[0][i];

        }
        sardines = new Animation<TextureRegion>(0.3f,sardineFrames);

        //boat textureRegion
        left = new Texture("BoatySprites/west.png");
        right = new Texture("BoatySprites/ost.png");
        down = new Texture("BoatySprites/south.png");
        up = new Texture("BoatySprites/nord.png");

        duleft = new Texture("BoatySprites/nord-west.png");
        duright = new Texture("BoatySprites/nord-ost.png");
        ddright = new Texture("BoatySprites/south-east.png");
        ddleft = new Texture("BoatySprites/south-west.png");


        playButtonActive = new Texture("menuUi/PlayHover.png");
        playButtonInactive = new Texture("menuUi/PlayNormal.png");
        exitButtonActive = new Texture("menuUi/ExitHover.png");
        exitButtonInactive = new Texture("menuUi/ExitNormal.png");

        mainMenuBackground = new Texture("menuUi/Map01.png");

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

        mainMenuBackground.dispose();

    }

}
