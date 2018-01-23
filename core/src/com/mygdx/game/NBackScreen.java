package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
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
    private final TextureRegion costam;
    NBackBoard board;
    Stage stage;
    final MainGame game;
    OrthographicCamera camera;
    int level = 2;
    Random rndGen;
    int lives = 3;
    private float timer;
    private float delay=1.6f;
    private boolean firstTime = true;

    public NBackScreen(MainGame game) {
        this.game = game;
        board = new NBackBoard();
        stage = new Stage();
        Assets.load();

        positionButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("core/assets/pola/pole_pos.png"))));
        typeButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("core/assets/pola/pole_typ.png"))));
        positionAndTypeButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("core/assets/pola/pole_both.png"))));

        costam = new TextureRegion(new Texture("core/assets/pola/pole_both.png"));

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
                if(!board.checkNBackPosition(level)){
                    lives--;
                }
                System.out.println("jest klik 1");
            }
        });
        typeButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                if(!board.checkNBackType(level)){
                    lives--;
                }
            }
        });
        positionAndTypeButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                if(!board.checkNBackTypeAndPosition(level)){
                    lives--;
                }
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
            System.out.println("aa");
        }

       /* if (board.size() > 2) {
            if (board.checkPosition(0).equals(board.checkPosition(level)) || (board.checkPosition(0).equals(board.checkPosition(level)) || (board.checkPosition(0).equals(board.checkPosition(level))))) {
                MainGame.nBackTracker.incrementOccurence();
                System.out.println(MainGame.nBackTracker.getOccurence());
            }
        }*/

        timer += Gdx.graphics.getRawDeltaTime();
        if (timer > delay) {

            if (board.boardNBackPosition.size() > 2 && board.boardNBackType.size() > 2) {
                Garbage checkedType = board.boardNBackType.get(0);
                Garbage peekedType = board.boardNBackType.get(2);
                Integer checkedPos = board.boardNBackPosition.get(0);
                Integer peekedPos = board.boardNBackPosition.get(2);

                if (checkedType.returnType().equals(peekedType.returnType()) || (checkedPos.equals(peekedPos))) {
                    MainGame.nBackTracker.incrementOccurence();
                    System.out.println(MainGame.nBackTracker.getOccurence());
                }


            }
            board.addNewEvent(NBackBoard.randomGarbage(), NBackBoard.randomPosition());
            timer = 0;
            board.clear();
        }

        board.print(game.batch);
        game.live.nBackDisplayLives(lives, game.batch);
        //System.out.println("zycie: "+lives);
        game.batch.draw(costam, 1200, 1200);
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
