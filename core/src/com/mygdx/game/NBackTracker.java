package com.mygdx.game;

public class NBackTracker {
    private int occurence;
    public NBackTracker() {
        occurence=0;
    }
    public void checkForNBack(Garbage.garbageTypes current, Garbage.garbageTypes nback2){
        if(current.equals(nback2)) occurence++;
    }
    public int getOccurence() {
        return occurence;
    }
}
