package com.mygdx.game;

public class NBackTracker {
    private int occurence;
    private int playerHits;
    public NBackTracker() {
        occurence=0;
    }

    public void incrementPlayerHits(){
        playerHits++;
    }

    public void checkForNBack(Garbage.garbageTypes current, Garbage.garbageTypes nback2){
        if(current.equals(nback2)) occurence++;
    }

    public int getPlayerHits() {
        return playerHits;
    }

    public int getOccurence() {
        return occurence;
    }
}
