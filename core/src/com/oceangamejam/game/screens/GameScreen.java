package com.oceangamejam.game.screens;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.oceangamejam.game.FishOver;
import com.oceangamejam.game.Scenes.Hud;
import com.oceangamejam.game.gameobjects.Mackarel;
import com.oceangamejam.game.gameobjects.Ripples;
import com.oceangamejam.game.gameobjects.Sardines;
import com.oceangamejam.game.gameobjects.Ship;
import com.oceangamejam.game.gameobjects.wave;
import com.oceangamejam.game.helper.InputHandlerGame;

import java.util.ArrayList;

/**
 * Created by norman on 5/20/17.
 */




public class GameScreen implements Screen {
    private FishOver fishOver;
    private InputHandlerGame ip;

    private Ship player;
    private float mTimer = 0, sTimer = 0;

    //fishes
    private ArrayList<Sardines> fishCollection;
    private ArrayList<Mackarel> fishmCollection;

    //waves
    private ArrayList<wave> waveCollection;

    public static String endMessage;

    private Camera ocam;
    
    private Hud hud;
    
    private Integer over;


    public GameScreen(FishOver fishOver) {
        this.fishOver = fishOver;


        float w = fishOver.WIDTH;
        float h = fishOver.HEIGHT;

        ocam = new OrthographicCamera(400, 400 * (h/w));
        
        hud = new Hud(fishOver.batch, ocam);

        player = new Ship(10,10, fishOver.as.right, fishOver);
        ip = new InputHandlerGame(player,fishOver);
        Gdx.input.setInputProcessor(ip);

        //init the border



        //init the waves
        waveCollection = new ArrayList<wave>();


        //fish init

        fishCollection = new ArrayList<Sardines>();
        for (int i = 0; i < 6; i++){
            int x = (int) (Math.random() * fishOver.WIDTH);
            int y = (int) (Math.random() * fishOver.HEIGHT);
            Sardines tmp1 =  new Sardines(x+10,y+6,fishOver);
            Sardines tmp2 =  new Sardines(x,y+4,fishOver);
            Sardines tmp3 =  new Sardines(x+4,y+12,fishOver);

            fishCollection.add(tmp1);
            fishCollection.add(tmp2);
            fishCollection.add(tmp3);
        }

        fishmCollection = new ArrayList<Mackarel>();
        for (int i = 0; i < 20; i++){
            int x = (int) (Math.random() * fishOver.WIDTH);
            int y = (int) (Math.random() * fishOver.HEIGHT);
            Mackarel tmp1 =  new Mackarel(x+10,y+6,fishOver);

            fishmCollection.add(tmp1);
        }

    }

    @Override
    public void show() {

    }
    public void FlowersAndBees(){
        int fishMax = 300;
        sTimer+=Gdx.graphics.getDeltaTime();
        mTimer+=Gdx.graphics.getDeltaTime();
        if(fishCollection.size()<3||fishmCollection.size()<3){
            endMessage = "YOU KILLED AN ENTIRE SPECIES";
            fishOver.setScreen(new GameOverScreen(fishOver));
        }
        if(sTimer>50/fishCollection.size() && fishCollection.size()<fishMax) {
            int x = (int) (Math.random() * FishOver.WIDTH);
            int y = (int) (Math.random() * FishOver.HEIGHT);
            Sardines tmp1 = new Sardines(x + 10, y + 6, fishOver);


            fishCollection.add(tmp1);
            sTimer=0;
        }
        if(mTimer>70/fishmCollection.size() && fishmCollection.size()<fishMax) {
            int x = (int) (Math.random() * FishOver.WIDTH);
            int y = (int) (Math.random() * FishOver.HEIGHT);
            Mackarel tmp1 = new Mackarel(x + 10, y + 6, fishOver);
            fishmCollection.add(tmp1);
            mTimer=0;
        }
    }
    @Override
    public void render(float delta) {
        fishOver.batch.setProjectionMatrix(ocam.combined);
        ocam.position.set(player.getX(),player.getY(),0);
        ocam.update();

        //update hud
        over = hud.update(delta,fishCollection,fishmCollection,player);

        //create random waves

        if(waveCollection.size() < 15){

            int x = (int) (Math.random() * fishOver.WIDTH);
            int y = (int) (Math.random() * fishOver.HEIGHT);
            wave tmp = new wave(x,y,fishOver);

            waveCollection.add(tmp);

        }





        Gdx.gl.glClearColor(10/255f, 152/255f, 172/255f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
                           

        this.FlowersAndBees();
        fishOver.batch.begin();

        for (int i = 0; i < fishCollection.size();i++){
            fishCollection.get(i).render();
            if (fishCollection.get(i).checkCollision(player.net)){
                hud.score++;
                hud.worldTimer++;
                fishCollection.remove(i);
            }
        }

        for (int i = 0; i < fishmCollection.size(); i++){
            fishmCollection.get(i).render();
            if (fishmCollection.get(i).checkCollision(player.net)){
                hud.score++;
                hud.worldTimer++;
                fishmCollection.remove(i);
            }
        }

        for(int i = 0; i < waveCollection.size(); i++){
            waveCollection.get(i).render();


            if(waveCollection.get(i).stateTime > 1.4f){
                waveCollection.remove(i);
            }
        }

        //draw border

        for (int i = 0;i < 26; i++){
            fishOver.batch.draw(fishOver.as.barrierDownR,i*49,0);
            fishOver.batch.draw(fishOver.as.barrierDownR,i*49,700);
        }

        for (int i = 0; i<20; i++){
            fishOver.batch.draw(fishOver.as.barrierUp,0,i*35);
            fishOver.batch.draw(fishOver.as.barrierUp,1275,i*35);
        }

        
        player.render();
        fishOver.batch.end();
        hud.stage.draw();
        hud.drawMap(fishOver);


        if(gameOver(over)){
            endMessage = "TIME IS UP, NO FOOD AND YOU DIED";
            fishOver.setScreen(new GameOverScreen(fishOver));
            dispose();
        }

    }
    
    public boolean gameOver(Integer delta){
        if( delta == 0 ){
            return true;
        }else{
            return false;
        }
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
