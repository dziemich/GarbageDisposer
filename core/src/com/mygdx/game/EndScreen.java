package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class EndScreen implements Screen {
    private final MainGame game;
    private final Stage stage;
    private final TextureRegion flusher;
    private final boolean flag;
    private final ImageButton playAgainButton;


    public EndScreen(final MainGame game, boolean flag) {
        this.game = game;
        this.flag = flag;
        stage = new Stage();
        Assets.load();
        playAgainButton =   new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("core/assets/PlayAgain.png"))));
        playAgainButton.setSize(350, 180);
        playAgainButton.setPosition(220, 100);
        flusher = new TextureRegion(new Texture("core/assets/pola/pole_both.png"));
        Gdx.input.setInputProcessor(stage);
        stage.addActor(playAgainButton);
        playAgainButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new MainMenuScreen(game));
                MainGame.moveToNBackGame = false;
                MainGame.moveToGameScreen = false;
                MainGame.lives = 3;
                MainGame.gameTimer = 0;
                MainGame.scoreKeeper.resetScore();
                MainGame.nBackTracker.reset();
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
        game.batch.begin();
        Assets.displayEndGame(game.batch, flag);
        game.batch.draw(flusher, 1200, 1200);
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
