package com.oceangamejam.game.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.oceangamejam.game.FishOver;

/**
 * Created by norman on 5/20/17.
 */

public class Sardines extends Fish {



    public Sardines(int x, int y, FishOver fo) {
        super(x, y, fo);
    }

    @Override
    public void render() {
        curFrame = fishOver.as.sardines.getKeyFrame(stateTime,true);
        super.render();
        moveAround();
    }

    private void moveAround(){
        int x = ((int) (Math.random() * 5 * Gdx.graphics.getDeltaTime()));
        int y = ((int) (Math.random() * 5 * Gdx.graphics.getDeltaTime()));

        x *= Math.floor(Math.random()*2) == 1 ? 1 : -1;
        y *= Math.floor(Math.random()*2) == 1 ? 1 : -1;

        setX(getX() + x);
        setY(getY() + y);
    }
}
