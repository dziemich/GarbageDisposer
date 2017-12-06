package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

public abstract class Garbage {

    enum garbageTypes {
        GLASS, PLASTIC, PAPER
    }

    enum soundTypes {
        //tu dodać dzwieki
    }
    public abstract garbageTypes returnType();
    public abstract soundTypes returnSound();
    public abstract Texture getGarbageImage();
}
