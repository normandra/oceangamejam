package com.oceangamejam.game.gameobjects;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Circle;
import com.oceangamejam.game.FishOver;

/**
 * Created by norman on 5/20/17.
 */

public class Ship extends Objects {


	private boolean leftMove, rightMove, upMove, downMove;
	private double xVelocity, yVelocity;
    private FishOver fishOver;
    private ShipTrail trail;
    private float time;
	public Circle net;

	private ArrayList<Ripples> ripples;

	private void updateMotion(){
		updateVelocity();
		x += xVelocity;
		y += yVelocity;
		if (x<0) {
			x = 0;
		}else if (x>FishOver.WIDTH-20){
			x = FishOver.WIDTH-20;
		}
		if (y<0) {
			y = 0;
		}else if (y>FishOver.HEIGHT-30){
			y = FishOver.HEIGHT-30;
		}
		
	}
	
	private void updateVelocity(){
		float deltaTime = Gdx.graphics.getDeltaTime();
		double threshold = 5;
		if (Math.abs(xVelocity) < threshold) {
            if (leftMove) {
                if (xVelocity > 0) {
                    xVelocity -= 4 * deltaTime;
                }

                xVelocity -= 3 * deltaTime;
            }

            if (rightMove) {
                if (xVelocity < 0) {
                    xVelocity += 4 * deltaTime;
                }

                xVelocity += 3 * deltaTime;
            }
        }else if (Math.abs(xVelocity)> threshold) {
            if (xVelocity > 0) {
                xVelocity = threshold - 1;
            } else {
                xVelocity = -threshold + 1;
            }
        }

		if (!rightMove && !leftMove && Math.abs(xVelocity) != 0) {
			
			if (xVelocity < -0.5)
				xVelocity += 5 * deltaTime;
			
			else if (xVelocity > 0.5)
				xVelocity -= 5 * deltaTime;
			
			else xVelocity = 0;
		}
			

		
		if ( Math.abs(yVelocity) < threshold) {
			if (upMove) {
				if (yVelocity < 0) {
					yVelocity += 4 * deltaTime;
				}
				yVelocity += 3 * deltaTime;
			}
			if (downMove) {
				if(yVelocity>0){
					yVelocity -= 4 * deltaTime;
				}
				yVelocity -= 3 * deltaTime;
			}
		}else if (Math.abs(yVelocity)> threshold){
			if (yVelocity>0){
				yVelocity = threshold -1;
			}else{
				yVelocity = -threshold +1;
			}
		}
		
		if (!upMove && !downMove && Math.abs(yVelocity) != 0) {
			
			if (yVelocity < -0.5)
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
        trail = new ShipTrail();
		ripples = new ArrayList<Ripples>();
		net = new Circle(x+2,y+2,4);
    }

    @Override
    public void render() {
    	updateMotion();
    	updateShipAssets();
        time += Gdx.graphics.getDeltaTime();
        if (xVelocity!=0 || yVelocity != 0){
        	trail.addNewPoint(getX(), getY());
			if(time > 0.1f){
        		time = 0;
        		ripples.add(new Ripples(getX()+7,getY(),fishOver));
        	}
        }

		for (int i = 0; i < ripples.size(); i++) {
			Ripples rp = ripples.get(i);

			if (rp.stateTime > 0.9f){
				ripples.remove(i);
			}else{
				rp.render();
			}
		}

		for (Integer[] i : trail.trail){
        	fishOver.batch.draw(fishOver.as.trail,i[0],i[1]);
        }

        Integer[] i = {getX(),getY()};
        Integer[] j = i;
        if (trail.trail.size()>0) {
        	i = trail.trail.get(0);
        	
        	if (trail.trail.size()>1) {
            	j = trail.trail.get(1);
            	
            	int diffX = j[0] - i[0];
                int diffY = j[1] - i[1];
                
                if (diffX != 0) { // left and right
                	if (diffY < 0) {
                		fishOver.batch.draw(fishOver.as.netRightUpLeftDown, i[0] - 5, i[1],20,20);
                	} else fishOver.batch.draw(fishOver.as.netLeftRight, i[0] - 5, i[1],20,20);
                } else if (diffY != 0) { // up and down
                	if (diffX < 0) {
                		fishOver.batch.draw(fishOver.as.netRightDownLeftUp, i[0] - 5, i[1],20,20);
                	} else fishOver.batch.draw(fishOver.as.netUpDown, i[0] - 5, i[1],20,20); 
                }
            } else fishOver.batch.draw(fishOver.as.netLeftRight, i[0] - 5, i[1],20,20);
        }

        fishOver.batch.draw(getCurrent(), getX(), getY());
        net.setPosition(i[0],i[1]);
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
