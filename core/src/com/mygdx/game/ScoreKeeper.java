package com.mygdx.game;

public class ScoreKeeper {
    private int score;

    public int getScore() {
        return score;
    }
    public void add(int val){
        score+=val;
    }
    public void resetScore(){
        score=0;
    }
}
