package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

public class PlasticGarbage extends Garbage {
    private Texture garbageImage;
    private garbageTypes type;
    private soundTypes sound;

    public PlasticGarbage() {
        garbageImage = new Texture("core/assets/PlasticBottle.png");
        type = garbageTypes.PLASTIC;
        //Tu trzeba randomowo ustawić dzwiek
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
