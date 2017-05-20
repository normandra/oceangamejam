package com.oceangamejam.game.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.oceangamejam.game.FishOver;

/**
 * Created by norman on 5/20/17.
 */

public class Ship extends Objects {


	boolean leftMove, rightMove, upMove, downMove;
	static double threshhold = 15;
	double xVelocity, yVelocity;
	
	void updateMotion(){
		updateVelocity();
		x += xVelocity;
		y += yVelocity;
		
	}
	
	void updateVelocity(){
		
		if (leftMove && Math.abs(xVelocity) < threshhold)
		{
		    xVelocity -= 5 * Gdx.graphics.getDeltaTime();
		}
		if (rightMove && Math.abs(xVelocity) < threshhold)
		{
		    xVelocity += 5 * Gdx.graphics.getDeltaTime(); 
		}
		if (!rightMove && !leftMove && Math.abs(xVelocity) > 0){
			if (xVelocity<0.5)
				xVelocity += 6 * Gdx.graphics.getDeltaTime();
			else if (xVelocity>0.5)
				xVelocity -= 6 * Gdx.graphics.getDeltaTime();
			else xVelocity = 0;
		}
			
		if (downMove && Math.abs(yVelocity) < threshhold)
		{
		    yVelocity -= 5 * Gdx.graphics.getDeltaTime();
		}
		if (upMove && Math.abs(yVelocity) < threshhold)
		{
		    yVelocity += 5 * Gdx.graphics.getDeltaTime(); 
		}
		if (!upMove && !downMove && Math.abs(yVelocity) > 0){
			if (yVelocity<0.5)
				yVelocity += 6 * Gdx.graphics.getDeltaTime();
			else if (yVelocity>0.5)
				yVelocity -= 6 * Gdx.graphics.getDeltaTime();
			else yVelocity = 0;
		}
		 
	}
	
	public void setLeftMove(boolean t){
		if (rightMove && t)
			rightMove = false;
		leftMove = t;
	}
	public void setRightMove(boolean t){
		if (leftMove && t)
			leftMove = false;
		rightMove = t;
	}
	public void setUpMove(boolean t){
		if (downMove && t)
			downMove = false;
		upMove = t;
	}
	public void setDownMove(boolean t){
		if (upMove && t)
			upMove = false;
		downMove = t;
	}

    public Ship(int x, int y, Texture current) {
        super(x, y);
        this.current = current;
    }

    @Override
    public void render() {
    	updateMotion();
    }
}
