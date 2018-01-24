package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import java.util.LinkedList;
import java.util.Random;


public class NBackScreen implements Screen {
    private final ImageButton positionButton;
    private final ImageButton typeButton;
    private final ImageButton positionAndTypeButton;
    private final LinkedList<ImageButton> posList;
    private final TextureRegion flusher;
    private final Sound clickSound;
    NBackBoard board;
    Stage stage;
    final MainGame game;
    OrthographicCamera camera;
    int level = 2;
    Random rndGen;
    private float timer;
    private float delay=1.6f;
    private boolean firstTime = true;



    public NBackScreen(MainGame game) {
        this.game = game;
        board = new NBackBoard();
        stage = new Stage();
        Assets.load();
        Gdx.input.setInputProcessor(stage);

        positionButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("core/assets/pola/pole_pos.png"))));
        typeButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("core/assets/pola/pole_typ.png"))));
        positionAndTypeButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("core/assets/pola/pole_both.png"))));

        flusher = new TextureRegion(new Texture("core/assets/pola/pole_both.png"));

        clickSound = Gdx.audio.newSound(Gdx.files.internal("core/assets/ogg/403009_inspectorj_ui-confirmation-alert-b3.ogg"));

        positionButton.setPosition(550,350);
        typeButton.setPosition(550,200);
        positionAndTypeButton.setPosition(550,50);
        
        posList = new LinkedList<ImageButton>();
        
        posList.add(positionButton);
        posList.add(typeButton);
        posList.add(positionAndTypeButton);

        for(ImageButton i: posList){
            i.setVisible(true);
            i.setSize(200,100);
            stage.addActor(i);
        }


        positionButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                if (board.size() > 2) {
                    Integer checkedPos = board.boardNBackPosition.get(0);
                    Integer peekedPos = board.boardNBackPosition.get(2);

                    if (checkedPos.equals(peekedPos)) {
                        if(!MainGame.keyBlocker) {
                            MainGame.nBackTracker.incrementPlayerHits();
                            MainGame.keyBlocker = true;
                        }
                    }
                }
                clickSound.play();
            }
        });
        typeButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                if (board.size() > 2) {
                    Garbage checkedType = board.boardNBackType.get(0);
                    Garbage peekedType = board.boardNBackType.get(2);

                    if (checkedType.returnType().equals(peekedType.returnType())) {
                        if(!MainGame.keyBlocker) {
                            MainGame.nBackTracker.incrementPlayerHits();
                            MainGame.keyBlocker = true;
                        }
                    }
                }
                clickSound.play();
            }
        });
        positionAndTypeButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                if (board.size() > 2) {
                    Garbage checkedType = board.boardNBackType.get(0);
                    Garbage peekedType = board.boardNBackType.get(2);
                    Integer checkedPos = board.boardNBackPosition.get(0);
                    Integer peekedPos = board.boardNBackPosition.get(2);

                    if (checkedType.returnType().equals(peekedType.returnType()) && (checkedPos.equals(peekedPos))) {
                        if(!MainGame.keyBlocker) {
                            MainGame.nBackTracker.incrementPlayerHits();
                            MainGame.keyBlocker = true;
                        }
                    }
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
        game.batch.begin();
        Assets.displayNBackGame(game.batch);
        if (firstTime) {
            board.addNewEvent(NBackBoard.randomGarbage(), NBackBoard.randomPosition());
            firstTime = false;
        }

        timer += Gdx.graphics.getRawDeltaTime();
        MainGame.gameTimer += Gdx.graphics.getRawDeltaTime();
        if (timer > delay) {
            if (board.boardNBackPosition.size() > 2 && board.boardNBackType.size() > 2) {
                Garbage checkedType = board.boardNBackType.get(0);
                Garbage peekedType = board.boardNBackType.get(2);
                Integer checkedPos = board.boardNBackPosition.get(0);
                Integer peekedPos = board.boardNBackPosition.get(2);

                if (checkedType.returnType().equals(peekedType.returnType()) || (checkedPos.equals(peekedPos))) {
                    MainGame.nBackTracker.incrementOccurence();
                }
                MainGame.keyBlocker = false;
            }
            board.addNewEvent(NBackBoard.randomGarbage(), NBackBoard.randomPosition());
            timer = 0;
            board.clear();
        }

        board.print(game.batch);
        game.batch.draw(flusher, 1200, 1200);
        stage.draw();
        game.batch.end();
        if (MainGame.gameTimer>30){
            game.setScreen(new EndScreen(game, true));
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
