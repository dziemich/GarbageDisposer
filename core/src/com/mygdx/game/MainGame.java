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
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.util.Random;

public class MainGame extends ApplicationAdapter {
    private static final int X_BUTTON_POS=180;
    private static final int Y_BUTTON_POS=250;
    private static final int X_GARBAGE_POS=50;

	SpriteBatch batch;
	private Belt belt;
	private Texture gameBackgroundImage, startBackgroundImage, beltImage, heartImage;
    Sprite heartSprite;
	private Random rnd;
	boolean startMenu = true;
	boolean endMenu = false;
	private Stage stage;
	private ImageButton startButton, endButton, glassGarbageButton, plasticGarbageButton, paperGarbageButton;
    private ScoreKeeper scoreKeeper;
    private BitmapFont scoreDisplay;
    Sound bgSound, paperSound, plasticSound, glassSound;
    private int lives= 3;

	@Override
	public void create () {
		batch = new SpriteBatch();
		gameBackgroundImage = new Texture("core/assets/bg.jpg");
		startBackgroundImage = new Texture("core/assets/startbg.jpg");
		beltImage = new Texture("core/assets/Belt.png");
		heartImage = new Texture("core/assets/Heart.png");
        bgSound = Gdx.audio.newSound(Gdx.files.internal("core/assets/ogg/326639_monkeyman535_happy-music.ogg"));
        paperSound = Gdx.audio.newSound(Gdx.files.internal("core/assets/ogg/82378_gynation_paper-flip-2.ogg"));
        plasticSound = Gdx.audio.newSound(Gdx.files.internal("core/assets/ogg/405702_apinasaundi_found-plastic-bottle-1.ogg"));
        glassSound = Gdx.audio.newSound(Gdx.files.internal("core/assets/ogg/338692_natemarler_glass-break-small.ogg"));
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
        glassGarbageButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("core/assets/GlassGarbage.png"))));
        plasticGarbageButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("core/assets/PlasticGarbage.png"))));
        paperGarbageButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("core/assets/PaperGarbage.png"))));

        startButton.setPosition(X_BUTTON_POS,Y_BUTTON_POS);
        endButton.setPosition(X_BUTTON_POS,Y_BUTTON_POS);
        glassGarbageButton.setPosition(X_GARBAGE_POS,0);
        plasticGarbageButton.setPosition(X_GARBAGE_POS+250,0);
        paperGarbageButton.setPosition(X_GARBAGE_POS+500,0);

        stage.addActor(startButton);
        stage.addActor(glassGarbageButton);
        stage.addActor(plasticGarbageButton);
        stage.addActor(paperGarbageButton);
        stage.addActor(endButton);

        for(Actor a: stage.getActors()){
            a.setVisible(false);
        }

        startButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y){
                startMenu = false;
            }
        });

        endButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y){
                endMenu = false;
                lives=3;
            }
        });

        startButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y){
                startMenu = false;
            }
        });
        startButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y){
                startMenu = false;
            }
        });
        glassGarbageButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y){
                Garbage check = belt.returnPopped();
                if(check.returnType().equals(Garbage.garbageTypes.GLASS)){
                    scoreKeeper.add(100);
                    final long playGlassSound = glassSound.play(1.0f);
                }
                else{
                    lives--;
                }
            }
        });
        paperGarbageButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y){
                Garbage check = belt.returnPopped();
                if(check.returnType().equals(Garbage.garbageTypes.PAPER)){
                    scoreKeeper.add(100);
                    final long playPaperSound = paperSound.play(1.0f);
                }
                else {
                    lives--;
                }
            }
        });
        plasticGarbageButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y){
                Garbage check = belt.returnPopped();
                if(check.returnType().equals(Garbage.garbageTypes.PLASTIC)){
                    scoreKeeper.add(100);
                    final long playPlasticSound = plasticSound.play(1.0f);
                }
                else {
                    lives--;
                }
            }
        });
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
            int offset = 0;
            for(Garbage g : belt.getGarbageList()){
                batch.draw(g.getGarbageImage(), 550-offset, 450);
                offset+=113;
            }
            for(int i=0; i<lives; ++i){
                batch.draw(heartImage, 750-50*i, 530, 50, 50);
            }
            startButton.setVisible(false);
            glassGarbageButton.setVisible(true);
            plasticGarbageButton.setVisible(true);
            paperGarbageButton.setVisible(true);
            endButton.setVisible(false);
            scoreDisplay.draw(batch, "Score: " + scoreKeeper.getScore(), 710, 600);
		}
        else if(endMenu){
            batch.draw(startBackgroundImage, 0, 0);
            startButton.setVisible(false);
            glassGarbageButton.setVisible(false);
            plasticGarbageButton.setVisible(false);
            paperGarbageButton.setVisible(false);
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
