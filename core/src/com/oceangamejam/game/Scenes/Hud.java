/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oceangamejam.game.Scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.oceangamejam.game.FishOver;

/**
 *
 * @author Myri
 */
public class Hud {
    public Stage stage;
    private Viewport viewPort;
    
    private Integer worldTimer;
    private float timeCount;
    private Integer score;
    
    Label countdownLabel;
    Label scoreLabel;
    Label timeLabel;
    Label levelLabel;
    Label worldLabel;
    Label fishLabel;
    
    public Hud(SpriteBatch sb,Camera ocam){
        worldTimer = 300;
        timeCount = 0;
        score = 0;
        
        viewPort = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), ocam);
        stage = new Stage(viewPort, sb);
        
        Table table = new Table();
        table.top();
        table.setFillParent(true);
        
        countdownLabel = new Label(String.format("%03d", worldTimer), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        scoreLabel = new Label(String.format("%03d", score), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        timeLabel = new Label("TIME", new Label.LabelStyle(new BitmapFont(), Color.WHITE));       
        fishLabel = new Label("FISHES", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        
        table.add(fishLabel).expandX().padTop(10);
        table.add(timeLabel).expandX().padTop(10);
        table.row();
        table.add(scoreLabel).expandX();
        table.add(countdownLabel).expand();
        
        stage.addActor(table);
    }   
        public void update(float dt){
        timeCount += dt;
        if(timeCount >= 1 ){
            worldTimer--;
            countdownLabel.setText(String.format("%03d", worldTimer));
            timeCount = 0;
        }
    }
}
