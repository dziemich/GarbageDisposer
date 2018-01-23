package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Live {

    public void nBackDisplayLives(int lives, SpriteBatch batch){
        int offset = 0;
        for(int i=0; i<lives; i++){
            batch.draw(new Texture("core/assets/Heart.png"), 705 - offset, 520,40,40);
            offset += 50;
        }
    }

    public void garbageDisplayLives(int lives, SpriteBatch batch){
        int offset = 0;
        for(int i=0; i<=lives; i++){
            batch.draw(new Texture("core/assets/Heart.png"), 740 - offset, 480,40,40);
            offset += 50;
        }
    }
}
