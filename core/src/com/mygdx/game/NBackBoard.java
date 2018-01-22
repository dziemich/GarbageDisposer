package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.*;

public class NBackBoard {
    private LinkedList<Garbage> boardNBackType;
    private LinkedList<Integer> boardNBackPosition;

    public NBackBoard(){
        boardNBackType = new LinkedList<Garbage>();
        boardNBackPosition = new LinkedList<Integer>();
    }

    public Garbage checkType(int pos){
        return boardNBackType.get(pos);
    }

    public Integer checkPosition(int pos){
        return boardNBackPosition.get(pos);
    }

    public void addNewEvent(Garbage type, int position){
        boardNBackPosition.add(0,position);
        boardNBackType.add(0,type);
    }

    public void randomAndAdd(){
        Garbage type = null;
        int position;
        float x=0;
        float y=0;
        type = randomGarbage();
        position = randomPosition();
        addNewEvent(type, position);
    }

    public void print(SpriteBatch batch){
        Garbage type = checkType(0);
        int position = checkPosition(0);
        float x=0;
        float y=0;

        addNewEvent(type, position);
        switch (position){
            case 1:
                x= 120;
                y= 100;
                break;
            case 2:
                x= 260;
                y= 100;
                break;
            case 3:
                x= 400;
                y= 100;
                break;
            case 4:
                x= 120;
                y= 240;
                break;
            case 5:
                x= 260;
                y= 240;
                break;
            case 6:
                x= 400;
                y= 240;
                break;
            case 7:
                x= 120;
                y= 380;
                break;
            case 8:
                x= 260;
                y= 380;
                break;
            case 9:
                x= 400;
                y= 380;
                break;

        }
        batch.draw(type.getGarbageImage(), x, y);
    }

    public Integer randomPosition(){
        Random generator = new Random();
        int position = generator.nextInt((9 - 1) + 1) + 1; // XDDDDDD
        return position;
    }

    public Garbage randomGarbage(){
        Garbage type = null;
        Random generator = new Random();
        int number = generator.nextInt((3 - 1) + 1) + 1;
        switch(number){
            case 1:
                type = new GlassGarbage();
                break;
            case 2:
                type = new PlasticGarbage();
                break;
            case 3:
                type = new PaperGarbage();
                break;
        }
        return type;
    }

    public void checkNBackPosition(int level){
        if(checkPosition(0) == checkPosition(level)){
            removeFirst();
            //xD najlepszy if w miescie
        }else{
            removeFirst();
        }
    }

    public void checkNBackType(int level){
        if(checkType(0).equals(checkType(level))){
            removeFirst();
        }else{
            removeFirst();
        }
    }

    public void checkNBackTypeAndPosition(int level){
        if((checkPosition(0) == checkPosition(level)) && (checkType(0).equals(checkType(level)))){
            removeFirst();
        }else{
            removeFirst();
        }
    }

    public void removeFirst(){
        boardNBackPosition.remove(0);
        boardNBackType.remove(0);
    }

    public void removeIndex(int index){
        boardNBackType.remove(index);
        boardNBackPosition.remove(index);
    }

    public int size(){
        if(boardNBackPosition.size() == boardNBackType.size()){
            return boardNBackPosition.size();
        }else{
            return 0;
        }
    }

}
