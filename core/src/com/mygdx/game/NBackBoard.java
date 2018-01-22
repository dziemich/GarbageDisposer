package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.*;

public class NBackBoard {
    private LinkedList<Garbage.garbageTypes> boardNBackType;
    private LinkedList<Integer> boardNBackPosition;

    public NBackBoard(){
        boardNBackType = new LinkedList<Garbage.garbageTypes>();
        boardNBackPosition = new LinkedList<Integer>();
    }

    public Garbage.garbageTypes checkType(int pos){
        return boardNBackType.get(pos);
    }

    public Integer checkPosition(int pos){
        return boardNBackPosition.get(pos);
    }

    public void addNewEvent(Garbage.garbageTypes type, int position){
        boardNBackPosition.add(position);
        boardNBackType.add(type);
    }

    public void randomAndAdd(){
        Garbage.garbageTypes type = null;
        int position;
        type = randomGarbage();
        position = randomPosition();
        addNewEvent(type, position);
    }

    public Integer randomPosition(){
        Random generator = new Random();
        int position = generator.nextInt((9 - 1) + 1) + 1;
        return position;
    }

    public Garbage.garbageTypes randomGarbage(){
        Garbage.garbageTypes type = null;
        Random generator = new Random();
        int number = generator.nextInt((3 - 1) + 1) + 1;
        switch(number){
            case 1:
                type = Garbage.garbageTypes.PAPER;
                break;
            case 2:
                type = Garbage.garbageTypes.GLASS;
                break;
            case 3:
                type = Garbage.garbageTypes.PLASTIC;
                break;
        }
        return type;
    }

    public void checkNBackPosition(int level){
        if(checkPosition(0) == checkPosition(level)){
            removeLast();
        }else{
            removeLast();
        }
    }

    public void checkNBackType(int level){
        if(checkType(0).equals(checkType(level))){
            removeLast();
        }else{
            removeLast();
        }
    }

    public void checkNBackTypeAndPosition(int level){
        if((checkPosition(0) == checkPosition(level)) && (checkType(0).equals(checkType(level)))){
            removeLast();
        }else{
            removeLast();
        }
    }

    public void removeLast(){
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
