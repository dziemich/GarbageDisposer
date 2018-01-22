package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.LinkedList;
import java.util.Random;

public class Belt {
    private LinkedList<Garbage> garbageList;

    public Belt() {
        garbageList = new LinkedList<Garbage>();
    }

    public LinkedList<Garbage> getGarbageList() {
        return garbageList;
    }

    public Garbage returnPopped(){
        return garbageList.pop();
    }

    /*public Garbage.garbageTypes popAndCheck(int pos){
        Garbage popped = garbageList.remove(pos);
        return popped.returnType();
    }*/

   /* public Garbage.soundTypes checkSound(int pos){
        return garbageList.get(pos).returnSound();
    }*/

    public Garbage.garbageTypes checkType(int pos){
        return garbageList.get(pos).returnType();
    }
    public void displayBelt(Random generator, SpriteBatch batch){
        int offset = 0;
        for(Garbage g: garbageList){
            batch.draw(g.getGarbageImage(), 550 - offset, 450);
            offset+=113;
        }
        addToBelt(generator);
    }
    public int size(){
        return garbageList.size();
    }

    public void addToBelt(Random generator){
        if(garbageList.size() <6) {
            //garbageList.add(new GlassGarbage());
            int switcher = generator.nextInt(3);
            switch (switcher) {
                case 0:
                    garbageList.add(new GlassGarbage());
                    break;
                case 1:
                    garbageList.add(new PaperGarbage());
                    break;
                case 2:
                    garbageList.add(new PlasticGarbage());
            }
        }
    }
    public void firstTimeBelt(Random generator){
        for(int i=0; i<6; ++i){
            addToBelt(generator);
        }
    }
}
