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

    public Garbage.garbageTypes checkType(int pos){
        return boardNBackType.get(pos).returnType();
    }

    public Integer checkPosition(int pos){
        return boardNBackPosition.get(pos);
    }

    public void addNewEvent(Garbage type, int position){
        boardNBackPosition.add(position);
        boardNBackType.add(type);
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
            case 2:
                type = Garbage.garbageTypes.GLASS;
            case 3:
                type = Garbage.garbageTypes.PLASTIC;
        }
        return type;
    }

    public void printEvent(Garbage type, int position){


    }

    public void displayBoard(Random generator, SpriteBatch batch){

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
