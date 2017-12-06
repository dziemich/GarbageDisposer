package com.mygdx.game;

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

    public Garbage.garbageTypes popAndCheck(int pos){
        Garbage popped = garbageList.remove(pos);
        return popped.returnType();
    }

    public Garbage.soundTypes checkSound(int pos){
        return garbageList.get(pos).returnSound();
    }

    public Garbage.garbageTypes checkType(int pos){
        return garbageList.get(pos).returnType();
    }

    public int size(){
        return garbageList.size();
    }

    public void addToBelt(Random generator){
        if(garbageList.size() <5) {
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
        for(int i=0; i<5; ++i){
            addToBelt(generator);
        }
    }
}
