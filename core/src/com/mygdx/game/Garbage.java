package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

public abstract class Garbage {

    enum garbageTypes {
        GLASS, PLASTIC, PAPER
    }

    public abstract garbageTypes returnType();
    public abstract Texture getGarbageImage();
}
