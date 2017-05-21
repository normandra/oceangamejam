package com.oceangamejam.game.helper;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by norman on 5/20/17.
 */

public class AssetLoader {


    // Assets

    public Texture left, duleft, up, duright,right,ddright,down,ddleft;

    public Texture playButtonActive,playButtonInactive,exitButtonActive,exitButtonInactive;

    public Texture mainMenuBackground;

    public Texture trail, netLeftRight, netUpDown, netRightDownLeftUp, netRightUpLeftDown;

    private Texture rippleTexture;

    public Texture barrierDownR, barrierUp;

    public Texture mapFish,mapPlayer;

    private Texture sardineTexture;
    public Animation<TextureRegion> sardines;
    public Animation<TextureRegion> ripples;

    private Texture mackarelTexture;
    public Animation<TextureRegion> mackarel;



    public AssetLoader(){

        //fishT
        sardineTexture = new Texture("fish/TinyFishAnimation4Frames.png");
        TextureRegion[][] tmp = TextureRegion.split(sardineTexture, sardineTexture.getWidth()/4,sardineTexture.getHeight());
        TextureRegion[] sardineFrames = new TextureRegion[4];
        int index = 0;
        for (int i = 0; i < 4; i++) {
            sardineFrames[index++] = tmp[0][i];

        }
        sardines = new Animation<TextureRegion>(0.3f,sardineFrames);

        //ripple
        rippleTexture = new Texture("WatterRippleNew.png"); // nice watter meme
        tmp = TextureRegion.split(rippleTexture, rippleTexture.getWidth()/9,rippleTexture.getHeight());
        TextureRegion[] rippleFrames = new TextureRegion[9];
        index = 0;
        for (int i = 0; i < 9; i++) {
            rippleFrames[index++] = tmp[0][i];

        }
        ripples = new Animation<TextureRegion>(0.3f,rippleFrames);

        mackarelTexture = new Texture("fish/BigFishAnimation4Frames.png");
        tmp = TextureRegion.split(mackarelTexture,mackarelTexture.getWidth()/4,mackarelTexture.getHeight());
        TextureRegion[] mackarelFrames = new TextureRegion[4];
        index = 0;
        for (int i = 0; i < 4; i++) {
            mackarelFrames[index++] = tmp[0][i];
        }
        mackarel = new Animation<TextureRegion>(0.3f,mackarelFrames);

        //barrier
        barrierDownR = new Texture("GrenzeDown.png");
        barrierUp = new Texture("GrenzeUp.png");

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
        
        trail = new Texture("Trail01.png");
        netLeftRight = new Texture("net-left-right.png");
        netUpDown = new Texture("net-up-down.png");
        
        netRightDownLeftUp = new Texture("net-rightdown-leftup.png");
        netRightUpLeftDown = new Texture("net-rightup-leftdown.png");

        mapFish = new Texture("OverViewFish.png");
        mapPlayer = new Texture("OverViewPlayer.png");

        mainMenuBackground = new Texture("menuUi/Map01.png");

    }

    public void dispose() {
        mapFish.dispose();
        mapPlayer.dispose();

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
        
        trail.dispose();
        
        netLeftRight.dispose();
        netUpDown.dispose();
        netRightDownLeftUp.dispose();
        netRightUpLeftDown.dispose();

        barrierDownR.dispose();
        barrierUp.dispose();

        sardineTexture.dispose();
        mackarelTexture.dispose();


        mainMenuBackground.dispose();

    }

}
