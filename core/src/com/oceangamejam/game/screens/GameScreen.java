package com.oceangamejam.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.oceangamejam.game.FishOver;
import com.oceangamejam.game.Scenes.Hud;
import com.oceangamejam.game.gameobjects.Fish;
import com.oceangamejam.game.gameobjects.Sardines;
import com.oceangamejam.game.gameobjects.Ship;
import com.oceangamejam.game.helper.InputHandlerGame;

import java.util.ArrayList;

/**
 * Created by norman on 5/20/17.
 */




public class GameScreen implements Screen {
    private FishOver fishOver;
    private InputHandlerGame ip;

    private Ship player;

    //fishes
    private Sardines one,two,three;
    private ArrayList<Fish> fishCollection;


    private Camera ocam;
    
    private Hud hud;



    public GameScreen(FishOver fishOver) {
        this.fishOver = fishOver;


        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();


        ocam = new OrthographicCamera(600, 600 * (h/w));
        
        hud = new Hud(fishOver.batch, ocam);

        player = new Ship(10,10, fishOver.as.right, fishOver);
        ip = new InputHandlerGame(player,fishOver);
        Gdx.input.setInputProcessor(ip);


        //fish init

        fishCollection = new ArrayList<Fish>();
        for (int i = 0; i < 20; i++){
            Sardines tmp =  new Sardines(((int) (Math.random() * Gdx.graphics.getWidth())), ((int) (Math.random() * Gdx.graphics.getHeight())),fishOver);
            fishCollection.add(tmp);
        }

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        fishOver.batch.setProjectionMatrix(ocam.combined);
        ocam.position.set(player.getX(),player.getY(),0);
        ocam.update();

        //update hud
        hud.update(delta);



        Gdx.gl.glClearColor(10/255f, 152/255f, 172/255f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
                           

        
        fishOver.batch.begin();

        for (Fish n : fishCollection){
            n.render();
        }
        
        player.render();
 

        fishOver.batch.end();
               hud.stage.draw();

    }


    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
