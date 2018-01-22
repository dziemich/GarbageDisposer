/*
package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import java.util.LinkedList;

import static com.mygdx.game.MainGame.nBackTracker;
import static com.mygdx.game.MainGame.scoreKeeper;

public class Buttons {
    public static ImageButton startButton;
    public static ImageButton endButton;

    public static ImageButton glassBinButton;
    public static ImageButton plasticBinButton;
    public static ImageButton paperBinButton;

    static LinkedList<ImageButton> garbageButtonList = new LinkedList<ImageButton>();

    public static void load(Stage stage) {

        startButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("core/assets/StartMenu.png"))));
        endButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("core/assets/EndMenu.png"))));
        glassBinButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("core/assets/EndMenu.png"))));
        plasticBinButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("core/assets/EndMenu.png"))));
        paperBinButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("core/assets/EndMenu.png"))));


        startButton.setPosition(180, 250);
        endButton.setPosition(180, 250);
        glassBinButton.setPosition(40,0);
        plasticBinButton.setPosition(290,0);
        paperBinButton.setPosition(540,0);

        garbageButtonList.add(glassBinButton);
        garbageButtonList.add(plasticBinButton);
        garbageButtonList.add(paperBinButton);



        startButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                MainGame.moveToGameScreen=true;
                MainGame.startMenu=false;
            }
        });

        endButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                MainGame.startMenu = true;
                MainGame.endMenu = false;
                MainGame.lives = 3;
                scoreKeeper.resetScore();
            }
        });

        int displayCounter =0;
        int moveToNextGarbage=0;

        for (ImageButton b : garbageButtonList) {
            stage.addActor(b);
        }

        stage.addActor(startButton);
        stage.addActor(endButton);

        resetDisplay(stage);

        }

    public static void display(Stage stage, boolean startMenu, boolean endMenu) {
        if(startMenu){
            resetDisplay(stage);
            startButton.setVisible(true);
        }
        else if(!startMenu && !endMenu){
            resetDisplay(stage);
            for (ImageButton i: garbageButtonList){
                i.setVisible(true);
            }
        }
        else if(endMenu){
            resetDisplay(stage);
            endButton.setVisible(true);
        }
    }
    public static void resetDisplay(Stage stage){
        for (Actor a: stage.getActors()){
            a.setVisible(false);
        }
    }
}


*/
/*
NbackButtonList.add(glassGarbageNONEButton);
        NbackButtonList.add(glassGarbagePOSButton);
        NbackButtonList.add(glassGarbageSOUNDButton);
        NbackButtonList.add(plasticGarbageNONEButton);
        NbackButtonList.add(plasticGarbagePOSButton);
        NbackButtonList.add(plasticGarbageSOUNDButton);
        NbackButtonList.add(paperGarbageNONEButton);
        NbackButtonList.add(paperGarbagePOSButton);
        NbackButtonList.add(paperGarbageSOUNDButton);




        glassGarbageNONEButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y){
                Garbage checker = GameScreen.belt.returnPopped();
                nBackTracker.checkForNBack(checker.returnType(), MainGame.typeStorage2);
                if(checker.returnType().equals(Garbage.garbageTypes.GLASS)){
                    scoreKeeper.add(100);
                    MainGame.typeStorage2 = MainGame.typeStorage;
                    MainGame.typeStorage = checker.returnType();
                }
                else{
                    MainGame.lives--;
                }
                MainGame.timer=0;
                System.out.println(nBackTracker.getOccurence());
                //System.out.println(MainGame.typeStorage.toString() + "  " + MainGame.typeStorage2.toString());
            }
        });
        glassGarbagePOSButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                Garbage checker = MainGame.belt.returnPopped();
                nBackTracker.checkForNBack(checker.returnType(), MainGame.typeStorage2);
                if (checker.returnType().equals(Garbage.garbageTypes.GLASS) && checker.returnType().equals(MainGame.typeStorage2)) {
                    MainGame.scoreKeeper.add(100);
                    //final long playGlassSound = glassSound.play(1.0f);
                    MainGame.typeStorage2 = MainGame.typeStorage;
                    MainGame.typeStorage = checker.returnType();
                    nBackTracker.incrementPlayerHits();
                } else {
                    MainGame.lives--;
                }
                MainGame.timer=0;
                System.out.println(nBackTracker.getOccurence());
                //System.out.println(MainGame.typeStorage.toString() + "  " + MainGame.typeStorage2.toString());
            }
        });
        plasticGarbageNONEButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y){
                Garbage checker = MainGame.belt.returnPopped();
                nBackTracker.checkForNBack(checker.returnType(), MainGame.typeStorage2);
                if(checker.returnType().equals(Garbage.garbageTypes.PLASTIC) && !checker.returnType().equals(MainGame.typeStorage2)){
                    MainGame.scoreKeeper.add(100);
                    //final long playGlassSound = glassSound.play(1.0f);
                    MainGame.typeStorage2 = MainGame.typeStorage;
                    MainGame.typeStorage = checker.returnType();
                }
                else{
                    MainGame.lives--;
                }
                MainGame.timer=0;
                System.out.println(nBackTracker.getOccurence());
                //System.out.println(MainGame.typeStorage.toString() + "  " + MainGame.typeStorage2.toString());
            }
        });
        plasticGarbagePOSButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                Garbage checker = MainGame.belt.returnPopped();
                nBackTracker.checkForNBack(checker.returnType(), MainGame.typeStorage2);
                if (checker.returnType().equals(Garbage.garbageTypes.PLASTIC) && checker.returnType().equals(MainGame.typeStorage2)) {
                    MainGame.scoreKeeper.add(100);
                    //final long playGlassSound = glassSound.play(1.0f);
                    MainGame.typeStorage2 = MainGame.typeStorage;
                    MainGame.typeStorage = checker.returnType();
                } else {
                    MainGame.lives--;
                }
                MainGame.timer=0;
                System.out.println(nBackTracker.getOccurence());
                //System.out.println(MainGame.typeStorage.toString() + "  " + MainGame.typeStorage2.toString());
            }
        });
        paperGarbageNONEButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y){
                Garbage checker = MainGame.belt.returnPopped();
                nBackTracker.checkForNBack(checker.returnType(), MainGame.typeStorage2);
                if(checker.returnType().equals(Garbage.garbageTypes.PAPER) && !checker.returnType().equals(MainGame.typeStorage2)){
                    MainGame.scoreKeeper.add(100);
                    //final long playGlassSound = glassSound.play(1.0f);
                    MainGame.typeStorage2 = MainGame.typeStorage;
                    MainGame.typeStorage = checker.returnType();
                    nBackTracker.incrementPlayerHits();
                }
                else{
                    MainGame.lives--;
                }
                MainGame.timer=0;
                System.out.println(nBackTracker.getOccurence());
                //System.out.println(MainGame.typeStorage.toString() + "  " + MainGame.typeStorage2.toString());
            }
        });
        paperGarbagePOSButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                Garbage checker = MainGame.belt.returnPopped();
                nBackTracker.checkForNBack(checker.returnType(), MainGame.typeStorage2);
                if (checker.returnType().equals(Garbage.garbageTypes.PAPER) && checker.returnType().equals(MainGame.typeStorage2)) {
                    MainGame.scoreKeeper.add(100);
                    //final long playGlassSound = glassSound.play(1.0f);
                    MainGame.typeStorage2 = MainGame.typeStorage;
                    MainGame.typeStorage = checker.returnType();
                    nBackTracker.incrementPlayerHits();
                } else {
                    MainGame.lives--;
                }
                MainGame.timer=0;
                System.out.println(nBackTracker.getOccurence());
                //System.out.println(MainGame.typeStorage.toString() + "  " + MainGame.typeStorage2.toString());
            }
        });

                glassGarbageNONEButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("core/assets/pola/pole_none.png"))));
        glassGarbagePOSButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("core/assets/pola/pole_pos.png"))));
        glassGarbageSOUNDButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("core/assets/pola/pole_sound.png"))));

        plasticGarbageNONEButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("core/assets/pola/pole_none.png"))));
        plasticGarbagePOSButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("core/assets/pola/pole_pos.png"))));
        plasticGarbageSOUNDButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("core/assets/pola/pole_sound.png"))));

        paperGarbageNONEButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("core/assets/pola/pole_none.png"))));
        paperGarbagePOSButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("core/assets/pola/pole_pos.png"))));
        paperGarbageSOUNDButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture("core/assets/pola/pole_sound.png"))));


        */

