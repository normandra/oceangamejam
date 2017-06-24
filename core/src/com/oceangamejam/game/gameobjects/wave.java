package com.oceangamejam.game.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.oceangamejam.game.FishOver;

/**
 * Created by norman on 6/24/17.
 */

public class wave extends Objects {

    public float stateTime;
    FishOver fo;
    TextureRegion cur;

    public wave(int x, int y, FishOver fo){
        super(x, y);
        this.fo = fo;
        stateTime = 0f;
    }

    @Override
    public void render() {
        cur = fo.as.wave.getKeyFrame(stateTime,true);
        stateTime += Gdx.graphics.getDeltaTime();
        fo.batch.draw(cur,x,y);
    }
}
