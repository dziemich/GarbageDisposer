package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import java.util.LinkedList;
import java.util.Random;


public class GameScreen implements Screen {

    private final ImageButton glassBinButton;
    private final ImageButton plasticBinButton;
    private final ImageButton paperBinButton;
    private final LinkedList<ImageButton> garbageButtonsList;
    private final Sound clickSound;

    Stage stage;
    final MainGame game;
    OrthographicCamera camera;
    Random rndGen;

    public GameScreen(final MainGame game) {
        this.game = game;
        stage = new Stage();
        Assets.load();
        rndGen = new Random();
        game.belt.firstTimeBelt(rndGen);
        garbageButtonsList = new LinkedList<ImageButton>();
        Gdx.input.setInputProcessor(stage);


        glassBinButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("core/assets/GlassGarbage.png"))));
        plasticBinButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("core/assets/PlasticGarbage.png"))));
        paperBinButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("core/assets/PaperGarbage.png"))));

        clickSound = Gdx.audio.newSound(Gdx.files.internal("core/assets/ogg/403009_inspectorj_ui-confirmation-alert-b3.ogg"));

        glassBinButton.setPosition(40,0);
        plasticBinButton.setPosition(290,0);
        paperBinButton.setPosition(540,0);

        garbageButtonsList.add(glassBinButton);
        garbageButtonsList.add(plasticBinButton);
        garbageButtonsList.add(paperBinButton);

        for(ImageButton i: garbageButtonsList){
            i.setVisible(true);
            stage.addActor(i);
        }

       glassBinButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                Garbage checker = game.belt.returnPopped();
                if(checker.returnType().equals(Garbage.garbageTypes.GLASS)){
                    MainGame.scoreKeeper.add(100);
                }else{
                    MainGame.lives--;
                }
                clickSound.play();
            }
        });
        plasticBinButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                Garbage checker = game.belt.returnPopped();
                if(checker.returnType().equals(Garbage.garbageTypes.PLASTIC)){
                    MainGame.scoreKeeper.add(100);
                }else{
                    MainGame.lives--;
                }
                clickSound.play();
            }
        });
        paperBinButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                Garbage checker = game.belt.returnPopped();
                if(checker.returnType().equals(Garbage.garbageTypes.PAPER)){
                    MainGame.scoreKeeper.add(100);
                }else{
                    MainGame.lives--;
                }
                clickSound.play();
            }
        });

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.gameTimer += Gdx.graphics.getRawDeltaTime();
        game.batch.begin();
        Assets.displayMainGame(game.batch);
        game.belt.displayBelt(game.rnd, game.batch);
        game.live.garbageDisplayLives(MainGame.lives, game.batch);
        stage.draw();
        game.batch.end();
        if (MainGame.lives==0){
            game.setScreen(new EndScreen(game, false));
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
