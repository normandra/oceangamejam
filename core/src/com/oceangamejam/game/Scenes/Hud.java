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
import com.oceangamejam.game.gameobjects.Mackarel;
import com.oceangamejam.game.gameobjects.Sardines;
import com.oceangamejam.game.gameobjects.Ship;

import java.util.ArrayList;

/**
 *
 * @author Myri
 */
public class Hud {
    public Stage stage;
    private Viewport viewPort;
    
    public Integer worldTimer;
    private float timeCount;
    public Integer score;

    private BitmapFont font;
    
    Label countdownLabel;
    Label scoreLabel;
    Label timeLabel;
    Label levelLabel;
    Label worldLabel;
    Label fishLabel;

    ArrayList<Sardines> sardines;
    ArrayList<Mackarel> mackarels;
    Ship player;

    Camera map;
    public Hud(SpriteBatch sb,Camera ocam){
        worldTimer = 20;
        timeCount = 0;
        score = 0;

        map = new OrthographicCamera(Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/2);


        viewPort = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), new OrthographicCamera());
        stage = new Stage(viewPort, sb);
        
        Table table = new Table();
        table.top();
        table.setFillParent(true);

        font = new BitmapFont();
        font.getData().setScale(2.5f,2.5f);
        
        countdownLabel = new Label(String.format("%02d:%02d", worldTimer / 60, worldTimer % 60), new Label.LabelStyle(font, Color.WHITE));
        scoreLabel = new Label(String.format("%03d", score), new Label.LabelStyle(font, Color.WHITE));
        timeLabel = new Label("TIME", new Label.LabelStyle(font, Color.WHITE));
        fishLabel = new Label("FISHES", new Label.LabelStyle(font, Color.WHITE));
        
        table.add(fishLabel).expandX().padTop(10);
        table.add(timeLabel).expandX().padTop(10);
        table.row();
        table.add(scoreLabel).expandX();
        table.add(countdownLabel).expandX();

        
        stage.addActor(table);
    }   
        public Integer update(float dt, ArrayList<Sardines> sardines, ArrayList<Mackarel> mackarels, Ship player){
            this.sardines = sardines;
            this.mackarels = mackarels;
            this.player = player;
            timeCount += dt;
            if(timeCount >= 1 ){
                worldTimer--;
                countdownLabel.setText(String.format("%02d:%02d", worldTimer / 60, worldTimer % 60));
                scoreLabel.setText(String.format("%03d", score));
                timeCount = 0;
            }
            return worldTimer;
    }

        public void drawMap(FishOver fo){
            fo.batch.begin();

            fo.batch.draw(fo.as.sardineUi,10,500,38*2,13*2);
            font.draw(fo.batch, " "+ sardines.size(),130,540);

            fo.batch.draw(fo.as.mackarelUi,10,420, 56 *2 , 28*2);
            font.draw(fo.batch, " "+ mackarels.size(),130,450);

            for (Sardines s : sardines) {
                fo.batch.draw(fo.as.mapFish,s.getX()/3.5f,s.getY()/4);
            }

            for (Mackarel m : mackarels){
                fo.batch.draw(fo.as.mapFish,m.getX()/3.5f,m.getY()/4);
            }

            fo.batch.draw(fo.as.mapPlayer,player.getX()/3.5f,player.getY()/4);


            fo.batch.end();
        }
}
