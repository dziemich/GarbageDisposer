package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Assets {

    private static  TextureRegion gameBackgroundImage;
    private static TextureRegion startBackgroundImage;
    private static TextureRegion beltImage;
    private static TextureRegion heartImage;
    private static TextureRegion Garbages;
    private static TextureRegion glassBin;
    private static TextureRegion plasticBin;
    private static TextureRegion paperBin;
    private static TextureRegion allGarbages;

    public static void load() {

        gameBackgroundImage =new TextureRegion(new Texture("core/assets/bg.jpg"));
        startBackgroundImage = new TextureRegion(new Texture("core/assets/startbg.jpg"));
        beltImage = new TextureRegion(new Texture("core/assets/Belt.png"));
        heartImage = new TextureRegion(new Texture("core/assets/Heart.png"));
        Garbages = new TextureRegion(new Texture("core/assets/Garbages.png"));
        glassBin = new TextureRegion(new Texture("core/assets/GlassGarbage.png"));
        plasticBin = new TextureRegion(new Texture("core/assets/PlasticGarbage.png"));
        paperBin =new TextureRegion(new Texture("core/assets/PaperGarbage.png"));
        allGarbages = new TextureRegion(new Texture("core/assets/Garbages.png"));
    }

    public static void displayMainGame(SpriteBatch batch ){

            batch.draw(gameBackgroundImage, 0, 0);
            batch.draw(beltImage, 50, 400);

            batch.draw(glassBin, 40, 0);
            batch.draw(plasticBin, 290, 0);
            batch.draw(paperBin, 540, 0);

            //batch.draw(allGarbages, 40,100);



        }
    }
