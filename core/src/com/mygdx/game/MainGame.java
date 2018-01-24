package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;

import java.util.Random;

public class MainGame extends Game {

    public SpriteBatch batch;
    public BitmapFont font;
    public Belt belt;
    public Random rnd;
    public Life live;

    public static boolean startMenu = true;
    public static boolean moveToGameScreen = false;
    public static boolean moveToNBackGame = false;
    public static boolean keyBlocker = false;
    public static ScoreKeeper scoreKeeper;
    public static float timer=0;
    public static float gameTimer=0;
    public static int lives= 3;
    private Sound music;


    public void create() {
        batch = new SpriteBatch();
        belt = new Belt();
        live = new Life();
        rnd = new Random();
        belt.firstTimeBelt(rnd);
        music = Gdx.audio.newSound(Gdx.files.internal("core/assets/ogg/326639_monkeyman535_happy-music.ogg"));
        scoreKeeper = new ScoreKeeper();
        nBackTracker = new NBackTracker();
        this.setScreen(new MainMenuScreen(this));
        music.loop();
    }

    public void render() {
        super.render(); //important!
    }

    public void dispose() {
        batch.dispose();
    }

    private Stage stage;

    public static NBackTracker nBackTracker;


}
