package chkn;

import java.awt.Image;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

import javax.imageio.*;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.*;

import Chicken_Types.*;
import User_Interface.*;

public class Game {
    private Window window;
    private Window_Manager wm;
    private Sound_fx sfx;

    private Chicken p1, p2;

    private int difficulty;
    public String playerName, computerName;
    public boolean gameOver = false;


    public Game(Window_Manager wm, Sound_fx sfx) {
        this.sfx = sfx;
        this.wm = wm;
    }

    // Create the game
    public void initialize_game() {
        wm.nameUpdate(playerName, computerName);
        System.out.println("Game Started!!"); 
        wm.markBoard(1, 1, p1.getIcon());
        wm.markBoard(9, 9, p2.getIcon());
        wm.setChickenTypes(p1.getChickenType(), p2.getChickenType());
        wm.hpUpdate(p1.get_hp(), p2.get_hp());
        this.gameOver = false;
        computerPlayer();
    }

    // Take computer turn
    public void takeComputerTurn() {
        Ai_Logic.aiTurn(this.p2, this.p1, this.difficulty, this.wm, this.sfx);
        check_win(p1.get_hp(), p2.get_name(), p1);
    }

    // Take player turn
    public void playerTurn(int choice) {
        Player.takeTurn(p2, p1, choice, wm, sfx);
        check_win(p2.get_hp(), p1.get_name(), p2);
    }

    // Take player turn
    public void playerDirection(int choice) {
        Player.changeDirection(p1, choice, wm, sfx);
    }

    // Set player name
    public void setPlayerName() {
        this.playerName = wm.getPlayerName();
        System.out.println("Player name is - " + this.playerName);
    }

    // Intialize player
    public void initializePlayer(int playerType) {
        System.out.println("Welcome " + this.playerName);
        this.p1 = Player.intializePlayer(this.playerName, playerType);
        Player.setPlayerIcons(p1);
    }

    // Intialize computer
    public void initializeComputer(int difficulty) {
        String[] cpu_names = {"Arit","Cyrus","Ivo","Marcus","Sebastian", "Tiberius","Otto","Orion","Nero","Icarus"};
        int rand_cpu = project_1.Utilities.calc_random(0, 9);
        String name = cpu_names[rand_cpu];
        this.computerName = name;
        this.difficulty = difficulty;
        int computerType = project_1.Utilities.calc_random(1, 4);
        this.p2 = Ai_Logic.initializeComputer(name, computerType);
        Ai_Logic.setComputerIcons(p2);
    }

    // Check to see if there is as winner yet
    public void check_win(int enemy_hp, String name, Chicken enemy) {
        wm.hpUpdate(p1.get_hp(), p2.get_hp());
        if (enemy_hp == 0) {
            this.gameOver = true;
            wm.disableButtons();
            System.out.println(enemy.get_name() + " killed from a chicken choke by " + name);
            System.out.println(name + " has won!!");
            Image deadChicken;
            Icon iconDead;
            try {
                deadChicken = ImageIO.read(new File("Images\\ChickenLeg.png"));
                iconDead = new ImageIcon(deadChicken.getScaledInstance(59, 59, Image.SCALE_DEFAULT));
                wm.markBoard(enemy.y_coord, enemy.x_coord, null);
                wm.markBoard(enemy.y_coord, enemy.x_coord, iconDead);
            } catch (Exception e) {
                System.out.println("Failed to load image");
                e.printStackTrace();
            }
            wm.changeNorthText(name + " has won!!");
        }
    }

    // Get difficulty 
    private int getDifficulty() {
        return this.difficulty;
    }
        
    // Computer player thread
    public void computerPlayer() {
        Thread computerTurn = new Thread (new Runnable() {
            @Override
            public void run() {
                while(!gameOver) {
                    takeComputerTurn();
                    try {
                        if(getDifficulty() == 1) {
                        Thread.sleep(1000);
                        }else if(getDifficulty() == 2) {
                            Thread.sleep(500);
                        }else if(getDifficulty() == 3) {
                            Thread.sleep(250);
                        }else if(getDifficulty() == 4) {
                            Thread.sleep(75);
                        }
                    } catch (Exception e) {
                        System.out.println("Thread did not sleep");
                        e.printStackTrace();
                    }
                }
            }
        });
        computerTurn.start();
        if(gameOver) {
            computerTurn.isInterrupted();
        }
    }
}
