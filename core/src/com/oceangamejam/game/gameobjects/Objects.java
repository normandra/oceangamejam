package com.oceangamejam.game.gameobjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by norman on 5/20/17.
 */

public abstract class Objects {
    protected int x;
    protected int y;
    protected Texture current;


    public Objects(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Texture getCurrent() {
        return current;
    }

    public void setCurrent(Texture current) {
        this.current = current;
    }

    public abstract void render();


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
