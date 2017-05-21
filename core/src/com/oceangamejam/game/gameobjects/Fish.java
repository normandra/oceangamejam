package com.oceangamejam.game.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Circle;
import com.oceangamejam.game.FishOver;

/**
 * Created by norman on 5/20/17.
 */

public class Fish extends Objects {

    protected FishOver fishOver;
    protected TextureRegion curFrame;
    protected float stateTime;
    public Circle fishBound;

    public Fish(int x, int y, FishOver fo) {
        super(x, y);
        this.fishOver = fo;
        this.fishBound = new Circle(x+20,y+10,30);
        stateTime = 0f;
    }

    public TextureRegion getCurFrame() {
        return curFrame;
    }

    public void setCurFrame(TextureRegion curFrame) {
        this.curFrame = curFrame;
    }

    @Override
    public void render() {
        fishBound.setPosition(x+20,y+10);
        stateTime += Gdx.graphics.getDeltaTime();
        fishOver.batch.draw(curFrame,getX(),getY());
    }

    public boolean checkCollision(Circle net){
        return net.overlaps(fishBound);
    }


}
