package com.oceangamejam.game.gameobjects;

import com.oceangamejam.game.FishOver;

/**
 * Created by norman on 5/21/17.
 */

public class Mackarel extends Fish {
    public Mackarel(int x, int y, FishOver fo) {
        super(x, y, fo);
    }

    @Override
    public void render() {
        curFrame = fishOver.as.mackarel.getKeyFrame(stateTime,true);
        super.render();
    }
}
