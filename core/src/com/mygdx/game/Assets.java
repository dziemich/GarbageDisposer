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
    private static TextureRegion beltImage;
    private static TextureRegion heartImage;
    private static BitmapFont bitMapDisplay;
    private static FreeTypeFontGenerator generator;

    public static void load() {

        gameBackgroundImage =new TextureRegion(new Texture("core/assets/bg.jpg"));
        beltImage = new TextureRegion(new Texture("core/assets/Belt.png"));
        bitMapDisplay = new BitmapFont();

        generator = new FreeTypeFontGenerator(Gdx.files.internal("core/assets/font/LLPIXEL3.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 36;
        bitMapDisplay = generator.generateFont(parameter);

    }

    public static void displayMainGame(SpriteBatch batch ){

        batch.draw(gameBackgroundImage, 0, 0);
        batch.draw(beltImage, 50, 400);
        bitMapDisplay.setColor(Color.BLACK);
        bitMapDisplay.draw(batch, "Score: " + MainGame.scoreKeeper.getScore(), 620, 600);
        bitMapDisplay.draw(batch, String.valueOf(30 - (int) MainGame.gameTimer), 380, 600);


            /*batch.draw(glassBin, 40, 0);
            batch.draw(plasticBin, 290, 0);
            batch.draw(paperBin, 540, 0);*/

            //batch.draw(allGarbages, 40,100);



        }
    }
