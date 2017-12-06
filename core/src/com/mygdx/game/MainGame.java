
package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.util.LinkedList;
import java.util.Random;

public class MainGame extends ApplicationAdapter {
    private static final int X_BUTTON_POS=180;
    private static final int Y_BUTTON_POS=250;
    private static final int X_GARBAGE_POS=50;

    SpriteBatch batch;
    private Belt belt;
    private Texture gameBackgroundImage, startBackgroundImage, beltImage, heartImage, glassBin, plasticBin, paperBin;
    Sprite heartSprite;
    private Random rnd;
    boolean startMenu = true;
    boolean endMenu = false;
    private boolean timerIsOn=false;
    private Stage stage;
    private ImageButton startButton, endButton, glassGarbageNONEButton, glassGarbagePOSButton, glassGarbageSOUNDButton, plasticGarbageNONEButton,
            plasticGarbagePOSButton, plasticGarbageSOUNDButton, paperGarbageNONEButton, paperGarbagePOSButton, paperGarbageSOUNDButton;
    private LinkedList<ImageButton> NbackButtonList;
    private ScoreKeeper scoreKeeper;
    private BitmapFont scoreDisplay;
    Sound bgSound, paperSound, plasticSound, glassSound;
    private int lives= 3;
    private Long lifeTime;
    private float timer=0;
    private float delay = 4;
    private int displayCounter =0;
    private int moveToNextGarbage=0;


    @Override
    public void create () {
        batch = new SpriteBatch();
        gameBackgroundImage = new Texture("core/assets/bg.jpg");
        startBackgroundImage = new Texture("core/assets/startbg.jpg");
        beltImage = new Texture("core/assets/Belt.png");
        heartImage = new Texture("core/assets/Heart.png");
        glassBin = new Texture("core/assets/GlassGarbage.png");
        plasticBin = new Texture("core/assets/PlasticGarbage.png");
        paperBin = new Texture("core/assets/PaperGarbage.png");
        bgSound = Gdx.audio.newSound(Gdx.files.internal("core/assets/ogg/326639_monkeyman535_happy-music.ogg"));
        paperSound = Gdx.audio.newSound(Gdx.files.internal("core/assets/ogg/82378_gynation_paper-flip-2.ogg"));
        plasticSound = Gdx.audio.newSound(Gdx.files.internal("core/assets/ogg/405702_apinasaundi_found-plastic-bottle-1.ogg"));
        glassSound = Gdx.audio.newSound(Gdx.files.internal("core/assets/ogg/338692_natemarler_glass-break-small.ogg"));
        lifeTime = System.currentTimeMillis();
        NbackButtonList = new LinkedList<ImageButton>();
        stage = new Stage(new ScreenViewport());
        belt = new Belt();
        rnd = new Random();
        scoreKeeper = new ScoreKeeper();
        belt.firstTimeBelt(rnd);
        scoreDisplay = new BitmapFont();
        scoreDisplay.setColor(Color.WHITE);
        scoreDisplay.getData().setScale(1.2f);
        Gdx.input.setInputProcessor(stage);
        //SOUND

        bgSound.loop(1.0f);
        //BUTTONS
        startButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("core/assets/StartMenu.png"))));
        endButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("core/assets/EndMenu.png"))));

        glassGarbageNONEButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("core/assets/pola/pole_none.png"))));
        glassGarbagePOSButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("core/assets/pola/pole_pos.png"))));
        glassGarbageSOUNDButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("core/assets/pola/pole_sound.png"))));

        plasticGarbageNONEButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("core/assets/pola/pole_none.png"))));
        plasticGarbagePOSButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("core/assets/pola/pole_pos.png"))));
        plasticGarbageSOUNDButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("core/assets/pola/pole_sound.png"))));

        paperGarbageNONEButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("core/assets/pola/pole_none.png"))));
        paperGarbagePOSButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("core/assets/pola/pole_pos.png"))));
        paperGarbageSOUNDButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("core/assets/pola/pole_sound.png"))));


        startButton.setPosition(X_BUTTON_POS, Y_BUTTON_POS);
        endButton.setPosition(X_BUTTON_POS, Y_BUTTON_POS);

        NbackButtonList.add(glassGarbageNONEButton);
        NbackButtonList.add(glassGarbagePOSButton);
        NbackButtonList.add(glassGarbageSOUNDButton);
        NbackButtonList.add(plasticGarbageNONEButton);
        NbackButtonList.add(plasticGarbagePOSButton);
        NbackButtonList.add(plasticGarbageSOUNDButton);
        NbackButtonList.add(paperGarbageNONEButton);
        NbackButtonList.add(paperGarbagePOSButton);
        NbackButtonList.add(paperGarbageSOUNDButton);

        for (ImageButton b : NbackButtonList) {
            stage.addActor(b);
        }
        for(ImageButton b: NbackButtonList){
            b.setSize(50f,50f);
            if(displayCounter==3 || displayCounter==6) {
                moveToNextGarbage+=1;
            }
            b.setPosition(50+65*displayCounter+55*moveToNextGarbage, 200);
            displayCounter +=1;
        }
        stage.addActor(startButton);
        stage.addActor(endButton);

        for (Actor a : stage.getActors()) {
            a.setVisible(false);
        }

        startButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                startMenu = false;
            }
        });

        endButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                endMenu = false;
                lives = 3;
            }
        });

        startButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                startMenu = false;
            }
        });
        startButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                startMenu = false;
            }
        });

        /*glassGarbageNONEButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                startMenu = false;
            }
        });*/
    }
    @Override
    public void render () {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        if (startMenu) {
            batch.draw(startBackgroundImage, 0, 0);
            startButton.setVisible(true);
        }
        else if(!endMenu && !startMenu){
            batch.draw(gameBackgroundImage, 0, 0);
            batch.draw(beltImage, 50, 400);
            batch.draw(glassBin, 40,0);
            batch.draw(plasticBin, 290,0);
            batch.draw(paperBin, 540,0);
            int offset = 0;
            for(Garbage g : belt.getGarbageList()){
                batch.draw(g.getGarbageImage(), 550-offset, 450);
                offset+=113;
            }
            for(int i=0; i<lives; ++i){
                batch.draw(heartImage, 750-50*i, 530, 50, 50);
            }
            for(Actor a : stage.getActors()){
                a.setVisible(true);
            }
            startButton.setVisible(false);
            endButton.setVisible(false);
            scoreDisplay.draw(batch, "Score: " + scoreKeeper.getScore(), 710, 600);

            /*timer+=Gdx.graphics.getRawDeltaTime();
            if(timer>delay){
                belt.returnPopped();
                lives--;
                timer=0;
            }*/
        }
        else if(endMenu){
            batch.draw(startBackgroundImage, 0, 0);
            for(Actor a: stage.getActors()){
                a.setVisible(false);
            }
            endButton.setVisible(true);
        }
        if(lives<1){
            endMenu=true;
            scoreKeeper.resetScore();
        }
        belt.addToBelt(rnd);
        batch.end();
        stage.getBatch();
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }
    @Override
    public void dispose() {
        batch.dispose();
        gameBackgroundImage.dispose();
        startBackgroundImage.dispose();
        stage.dispose();
    }
}
