package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.util.Random;

public class MainGame extends ApplicationAdapter {
    private static final int X_BUTTON_POS=180;
    private static final int Y_BUTTON_POS=250;
    private static final int X_GARBAGE_POS=50;

    SpriteBatch batch;
    public static Belt belt;
    private Random rnd;
    public static boolean startMenu = true;
    public static boolean endMenu = false;
    private Stage stage;
    public static ScoreKeeper scoreKeeper;
    public static NBackTracker nBackTracker;
    public static BitmapFont bitMapDisplay, timeDisplay;
    Sound bgSound, paperSound, plasticSound, glassSound;
    public static int lives= 3;
    private Long lifeTime;
    public static float timer=0;
    public static float gameTimer=0;
    private float delay = 6;
    public static Garbage.garbageTypes typeStorage;
    public static Garbage.garbageTypes typeStorage2;

    @Override
    public void create () {
        batch = new SpriteBatch();
        nBackTracker = new NBackTracker();
        bgSound = Gdx.audio.newSound(Gdx.files.internal("core/assets/ogg/326639_monkeyman535_happy-music.ogg"));
        paperSound = Gdx.audio.newSound(Gdx.files.internal("core/assets/ogg/82378_gynation_paper-flip-2.ogg"));
        plasticSound = Gdx.audio.newSound(Gdx.files.internal("core/assets/ogg/405702_apinasaundi_found-plastic-bottle-1.ogg"));
        glassSound = Gdx.audio.newSound(Gdx.files.internal("core/assets/ogg/338692_natemarler_glass-break-small.ogg"));
        lifeTime = System.currentTimeMillis();
        stage = new Stage(new ScreenViewport());
        belt = new Belt();
        rnd = new Random();
        scoreKeeper = new ScoreKeeper();
        belt.firstTimeBelt(rnd);
        bitMapDisplay = new BitmapFont();
        bitMapDisplay.setColor(Color.WHITE);
        bitMapDisplay.getData().setScale(1.2f);
        Gdx.input.setInputProcessor(stage);
        typeStorage = Garbage.garbageTypes.GLASS;
        typeStorage2 =Garbage.garbageTypes.GLASS;

        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("core/assets/font/LLPIXEL3.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 36;
        bitMapDisplay = generator.generateFont(parameter);
        Assets.load();
        Buttons.load(stage);

        bgSound.loop(1.0f);
    }
	@Override
    public void render() {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        Assets.display(batch, lives, startMenu, endMenu);
        Buttons.display(stage, startMenu, endMenu);
        gameTimer += Gdx.graphics.getRawDeltaTime();
        if (gameTimer > 30) {
            endMenu = true;
        }
        timer += Gdx.graphics.getRawDeltaTime();
        if (timer > delay) {
            belt.returnPopped();
            lives--;
            timer = 0;
        }
        if(lives<1){
            endMenu=true;
        }
        if(!startMenu && !endMenu) {
            belt.displayBelt(rnd, batch);
        }
        batch.end();
        stage.getBatch();
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }
    @Override
    public void dispose() {
        batch.dispose();
        stage.dispose();
    }
}
