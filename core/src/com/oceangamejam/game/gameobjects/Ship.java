package com.oceangamejam.game.gameobjects;

import com.badlogic.gdx.graphics.Texture;
import com.oceangamejam.game.FishOver;

/**
 * Created by norman on 5/20/17.
 */

public class Ship extends Objects {



    public Ship(int x, int y, Texture current) {
        super(x, y);
        this.current = current;
    }

    @Override
    public void render() {

    }
}
