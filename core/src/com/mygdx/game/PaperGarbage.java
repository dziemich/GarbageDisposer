package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

public class PaperGarbage extends Garbage {
    private Texture garbageImage;
    private garbageTypes type;
    private soundTypes sound;

    public PaperGarbage() {
        garbageImage = new Texture("core/assets/PaperNewspaper.png");
        type = garbageTypes.PAPER;
    }
    @Override
    public Texture getGarbageImage() {
        return garbageImage;
    }

    @Override
    public garbageTypes returnType() {
        return type;
    }

    @Override
    public soundTypes returnSound(){
        return sound;
    }
}
