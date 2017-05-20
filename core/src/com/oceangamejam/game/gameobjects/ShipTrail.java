package com.oceangamejam.game.gameobjects;

import java.util.ArrayList;

public class ShipTrail {
	public ArrayList<Integer[]> trail;
	
	public ShipTrail(){
		trail = new ArrayList<Integer[]>();
	}
	
	public void addNewPoint(int x, int y){
		if (trail.size()>=20)
			trail.remove(0);
		trail.add(new Integer []{x+15, y+10});
	}
}
