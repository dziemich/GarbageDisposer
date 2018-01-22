package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class MainMenuScreen implements Screen {

    final MainGame game;
    private final ImageButton startButton;
    private final ImageButton endButton;

    Stage stage;
    OrthographicCamera camera;

    public MainMenuScreen(final MainGame game) {


        this.game = game;
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 600);

        startButton =   new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("core/assets/StartMenu.png"))));
        endButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("core/assets/EndMenu.png"))));


        startButton.setPosition(180, 250);
        endButton.setPosition(180, 250);

        startButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                MainGame.moveToGameScreen=true;
                MainGame.startMenu=false;
            }
        });

        endButton.addListener(new ClickListener(){
            public void clicked(InputEvent event, float x, float y){
                MainGame.startMenu = true;
                MainGame.endMenu = false;
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

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        Table table = new Table();
        table.setFillParent(true);
        table.center().center();
        stage.addActor(table);

        game.batch.begin();
        stage.addActor(startButton);
        if(MainGame.moveToGameScreen){
            game.setScreen(new GameScreen(game));
            dispose();
        }
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


    //...Rest of class omitted for succinctness.

}
