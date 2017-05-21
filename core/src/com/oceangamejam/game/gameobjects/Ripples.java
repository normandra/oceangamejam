package com.oceangamejam.game.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.oceangamejam.game.FishOver;

/**
 * Created by max on 21.05.17.
 */
public class Ripples extends Objects {

    float stateTime;
    FishOver fo;
    TextureRegion cur;

    public Ripples(int x, int y, FishOver fo){
        super(x, y);
        this.fo = fo;
        stateTime = 0f;
    }

    @Override
    public void render() {
        cur = fo.as.ripples.getKeyFrame(stateTime,true);
        stateTime += Gdx.graphics.getDeltaTime();
        fo.batch.draw(cur,x,y);
    }
}
