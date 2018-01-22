package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;

import java.util.Random;


public class NBackScreen implements Screen {
    Stage stage;
    final NBackGame game;
    OrthographicCamera camera;
    Belt belt;
    Random rndGen;

    public NBackScreen(NBackGame game) {
        this.game = game;
        stage = new Stage();
        Buttons.load(stage);
        Assets.load();
        belt = new Belt();
        rndGen = new Random();
        belt.firstTimeBelt(rndGen);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        Assets.displayMainGame(game.batch);
        Buttons.display(stage, MainGame.startMenu,MainGame.endMenu);
        belt.displayBelt(rndGen, game.batch);
        stage.draw();
        game.batch.end();
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
