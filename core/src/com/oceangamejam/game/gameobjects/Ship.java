package com.oceangamejam.game.gameobjects;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.oceangamejam.game.FishOver;

/**
 * Created by norman on 5/20/17.
 */

public class Ship extends Objects {


	boolean leftMove, rightMove, upMove, downMove;
	static double threshhold = 6;
	double xVelocity, yVelocity;
    private FishOver fishOver;
	
	void updateMotion(){
		updateVelocity();
		x += xVelocity;
		y += yVelocity;
		
	}
	
	void updateVelocity(){
		float deltaTime = Gdx.graphics.getDeltaTime();
		if (leftMove && Math.abs(xVelocity) < threshhold) {
			if (xVelocity>0) xVelocity -= 4 * deltaTime;

			xVelocity -= 3 * deltaTime;
		}
		
		if (rightMove && Math.abs(xVelocity) < threshhold) { 
			if (xVelocity<0) xVelocity += 4 * deltaTime;

			xVelocity += 3 * deltaTime;
		}
		
		if (!rightMove && !leftMove && Math.abs(xVelocity) > 0) {
			
			if (xVelocity < 0.5)
				xVelocity += 5 * deltaTime;
			
			else if (xVelocity > 0.5)
				xVelocity -= 5 * deltaTime;
			
			else xVelocity = 0;
		}
			
		if (downMove && Math.abs(yVelocity) < threshhold) {
			if(yVelocity>0) yVelocity -= 4 * deltaTime;
			yVelocity -= 3 * deltaTime;
		}
		
		if (upMove && Math.abs(yVelocity) < threshhold) {
			if(yVelocity<0) yVelocity += 4 * deltaTime;
			yVelocity += 3 * deltaTime;
		}
		
		if (!upMove && !downMove && Math.abs(yVelocity) > 0) {
			
			if (yVelocity < 0.5) 
				yVelocity += 5 * deltaTime;
			
			else if (yVelocity>0.5) 
				yVelocity -= 5 * deltaTime;
			
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

    public Ship(int x, int y, Texture current, FishOver fishOver) {
        super(x, y);
        this.current = current;
        this.fishOver = fishOver;
    }

    @Override
    public void render() {
    	updateMotion();
    	updateShipAssets();
        fishOver.batch.draw(getCurrent(), getX(), getY());

    }
    
    public void updateShipAssets() {
    	if (upMove) {
    		if (rightMove) this.setCurrent(fishOver.as.duright);
    		else if (leftMove) this.setCurrent(fishOver.as.duleft);
    		else this.setCurrent(fishOver.as.up);
    	} else if (downMove) {
    		if (rightMove) this.setCurrent(fishOver.as.ddright);
    		else if (leftMove) this.setCurrent(fishOver.as.ddleft);
    		else this.setCurrent(fishOver.as.down);
    	} else if (rightMove) this.setCurrent(fishOver.as.right);
    	else if (leftMove) this.setCurrent(fishOver.as.left);
	}
}
