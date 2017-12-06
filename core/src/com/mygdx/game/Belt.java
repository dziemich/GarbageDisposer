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
        if(garbageList.size() == 5) {
            int switcher = generator.nextInt(3);
            switch (switcher) {
                case 0:
                    garbageList.add(5, new GlassGarbage());
                    break;
                case 1:
                    garbageList.add(5, new PaperGarbage());
                    break;
                case 2:
                    garbageList.add(5, new PlasticGarbage());
            }
        }else if(garbageList.size() == 6) {
            int switcher = generator.nextInt(3);
            switch (switcher) {
                case 0:
                    garbageList.add(6, new GlassGarbage());
                    break;
                case 1:
                    garbageList.add(6, new PaperGarbage());
                    break;
                case 2:
                    garbageList.add(6, new PlasticGarbage());
            }
        }else if(garbageList.size() > 6) {
            int switcher = generator.nextInt(3);
            switch (switcher) {
                case 0:
                    garbageList.add(7, new GlassGarbage());
                    break;
                case 1:
                    garbageList.add(7, new PaperGarbage());
                    break;
                case 2:
                    garbageList.add(7, new PlasticGarbage());
            }
        }

    }
    public void firstTimeBelt(Random generator){
        for(int i=0; i<5; ++i){
            addToBelt(generator);
        }
    }
}
