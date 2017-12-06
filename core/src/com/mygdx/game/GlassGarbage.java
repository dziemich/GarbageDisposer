package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

public class GlassGarbage extends Garbage {
    private Texture garbageImage;
    private garbageTypes type;
    private soundTypes sound;

    public GlassGarbage() {
        garbageImage = new Texture("core/assets/GlassBottle.png");
        type = garbageTypes.GLASS;
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
