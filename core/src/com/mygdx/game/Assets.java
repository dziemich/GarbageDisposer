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
    private static TextureRegion glassBin;
    private static TextureRegion plasticBin;
    private static TextureRegion paperBin;

    public static void load() {

        gameBackgroundImage =new TextureRegion(new Texture("core/assets/bg.jpg"));
        startBackgroundImage = new TextureRegion(new Texture("core/assets/startbg.jpg"));
        beltImage = new TextureRegion(new Texture("core/assets/Belt.png"));
        heartImage = new TextureRegion(new Texture("core/assets/Heart.png"));
        glassBin = new TextureRegion(new Texture("core/assets/GlassGarbage.png"));
        plasticBin = new TextureRegion(new Texture("core/assets/PlasticGarbage.png"));
        paperBin =new TextureRegion( new Texture("core/assets/PaperGarbage.png"));
    }

    public static void display(SpriteBatch batch, int lives, boolean startMenu, boolean endMenu ){
        if(startMenu || endMenu) {
            batch.draw(startBackgroundImage, 0, 0);
            if (endMenu){
                MainGame.bitMapDisplay.draw(batch, "Your score was:  " + MainGame.scoreKeeper.getScore(), 200, 200);
            }
        }
        else if(!startMenu && !endMenu) {
            batch.draw(gameBackgroundImage, 0, 0);
            batch.draw(beltImage, 50, 400);
            batch.draw(glassBin, 40, 0);
            batch.draw(plasticBin, 290, 0);
            batch.draw(paperBin, 540, 0);
            MainGame.bitMapDisplay.setColor(Color.BLACK);
            MainGame.bitMapDisplay.draw(batch, "Score: " + MainGame.scoreKeeper.getScore(), 620, 600);
            MainGame.bitMapDisplay.draw(batch, String.valueOf(30-(int)MainGame.gameTimer), 380, 600);
            int offset = 0;
            for(int i=0; i<lives; ++i){
                batch.draw(heartImage, 750-50*i, 530, 50, 50);
            }
        }
    }
}
