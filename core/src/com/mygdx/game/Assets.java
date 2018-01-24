package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class Assets {

    private static  TextureRegion gameBackgroundImage;
    private static TextureRegion nbackBg;
    private static TextureRegion beltImage;
    private static TextureRegion heartImage;
    private static BitmapFont bitMapDisplay;
    private static FreeTypeFontGenerator generator;
    private static TextureRegion grid;
    private static TextureRegion endMenu;

    public static void load() {

        gameBackgroundImage =new TextureRegion(new Texture("core/assets/bg.jpg"));
        beltImage = new TextureRegion(new Texture("core/assets/Belt.png"));
        grid= new TextureRegion(new Texture("core/assets/Grid.png"));
        bitMapDisplay = new BitmapFont();
        endMenu = new TextureRegion(new Texture("core/assets/startbg.jpg"));
        nbackBg = new TextureRegion(new Texture("core/assets/nbackbg.jpg"));

        generator = new FreeTypeFontGenerator(Gdx.files.internal("core/assets/font/LLPIXEL3.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 30;
        bitMapDisplay = generator.generateFont(parameter);
    }

    public static void displayMainGame(SpriteBatch batch) {

        batch.draw(gameBackgroundImage, 0, 0);
        batch.draw(beltImage, 50, 400);
        bitMapDisplay.setColor(Color.BLACK);
        bitMapDisplay.draw(batch, "Score: " + MainGame.scoreKeeper.getScore(), 600, 600);

    }

    public static void displayNBackGame(SpriteBatch batch) {
        batch.draw(nbackBg, 0, 0);
        batch.draw(grid, 50, 50);
        bitMapDisplay.draw(batch, String.valueOf(30 - (int) MainGame.gameTimer), 380, 600);
    }

    public static void displayEndGame(SpriteBatch batch, boolean flag){
        batch.draw(endMenu, 0 ,0);
        if (flag){
            bitMapDisplay.draw(batch, "You've hit " + MainGame.nBackTracker.getPlayerHits() + " out of " + MainGame.nBackTracker.getOccurence(), 250, 400);
        }else{
            bitMapDisplay.draw(batch, "game over", 300, 400);
        }
    }
}
