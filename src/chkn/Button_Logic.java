package chkn;

import User_Interface.*;

import java.awt.event.*;

public class Button_Logic {

    private Window window;
    private Window_Manager wm;
    private Game game;
    private Sound_fx sfx;

    private ActionListener startRestartListener, actionListener, directionListener, chickenChoiceListener, difficultyChoiceListener;

    // Create button functionality
    public Button_Logic () {
            // Create button listeners than intialize other classes
            createListeners();
            this.window = new Window(this.startRestartListener, this.actionListener, this.directionListener, this.chickenChoiceListener, this.difficultyChoiceListener);
            this. wm = new Window_Manager(window);
            this.sfx = new Sound_fx();
            this.game = new Game(wm, sfx);
            sfx.bgmPlay();

    }

    // Create the action listeners
    private void createListeners() {
        createStartRestartListener();
        createActionListener();
        createDirectionListener();
        createChickenChoiceListener();
        createDifficultyChoiceListener();
    }

    // Create the restart and start buttons
    private void createStartRestartListener() {
        startRestartListener = new ActionListener() {
            // Create actionlistener
            @Override
            public void actionPerformed(ActionEvent s) {
                // This grabs the button info
                String buttonPressed = s.getActionCommand(); 

                // This defines what happens when each button is pressed
                switch(buttonPressed) {
                    case "Start":
                        sfx.buttonSound();
                        game.setPlayerName();
                        System.out.println("Starting Game");
                        wm.switchChickenChoice(true);
                        break;
                    case "Reset": 
                        sfx.buttonSound();
                        System.out.println("Resetting the Game");
                        game.gameOver = true;
                        wm.closeWindow();
                        break;
                }  
            }
        };
    }

    // Create difficulty listener
    private void createDifficultyChoiceListener() {
        this.difficultyChoiceListener = new ActionListener() {
            // Create actionlistener
            @Override
            public void actionPerformed(ActionEvent h) {
                // This grabs the button info
                String buttonPressed = h.getActionCommand(); 

                // This defines what happens when each button is pressed
                switch(buttonPressed) {
                    case "Easy":
                        sfx.buttonSound();
                        System.out.println("Difficulty is set to - Easy");
                        game.initializeComputer(1);
                        wm.titleScreen(false);
                        game.initialize_game();
                        break;
                    case "Medium": 
                        sfx.buttonSound();
                        System.out.println("Difficulty is set to - Medium");
                        game.initializeComputer(2);
                        wm.titleScreen(false);
                        game.initialize_game();
                        break;
                    case "Hard": 
                        sfx.buttonSound();
                        System.out.println("Difficulty is set to - Hard");
                        game.initializeComputer(3);
                        wm.titleScreen(false);
                        game.initialize_game();
                        break;
                    case "Just Give Up": 
                        sfx.buttonSound();
                        System.out.println("Difficulty is set to - Just Give Up");
                        game.initializeComputer(4);
                        wm.titleScreen(false);
                        game.initialize_game();
                        break;
                }  
            }
        };
    }

    // Create chicken choice listener
    private void createChickenChoiceListener() {
        this. chickenChoiceListener = new ActionListener() {
            // Create actionlistener
            @Override
            public void actionPerformed(ActionEvent c) {
                // This grabs the button info
                String buttonPressed = c.getActionCommand(); 

                // This defines what happens when each button is pressed
                switch(buttonPressed) {
                    case "Teleporter":
                        sfx.buttonSound();
                        System.out.println("The chicken you have picked can teleport entire lines");
                        game.initializePlayer(1);
                        wm.switchDifficultyPanel(true);
                        break;
                    case "Healer": 
                        sfx.buttonSound();
                        System.out.println("The chicken that you have picked had the ability to heal");
                        game.initializePlayer(2);
                        wm.switchDifficultyPanel(true);
                        break;
                    case "Powerful": 
                        sfx.buttonSound();
                        System.out.println("This chicken is powerful and you will be able to strike down foes");
                        game.initializePlayer(3);
                        wm.switchDifficultyPanel(true);
                        break;
                    case "Fast": 
                        sfx.buttonSound();
                        System.out.println("This is a speedy chicken, allowing you to travel fourspaces in one turn");
                        game.initializePlayer(4);
                        wm.switchDifficultyPanel(true);
                        break;
                }  
            }
        };
    }

    // Create direction listener
    private void createDirectionListener() {
        this.directionListener = new ActionListener() {
            // Create actionlistener
            @Override
            public void actionPerformed(ActionEvent d) {
                // This grabs the button info
                String buttonPressed = d.getActionCommand(); 

                // This defines what happens when each button is pressed
                switch(buttonPressed) {
                    case "North":
                        game.playerDirection(1);
                        break;
                    case "East": 
                        game.playerDirection(2);
                        break;
                    case "South": 
                        game.playerDirection(3);
                        break;
                    case "West": 
                        game.playerDirection(4);
                        break;
                }  
            }
        };
    }

    // Create action listener
    private void createActionListener() {
        this.actionListener = new ActionListener() {
            // Create actionlistener
            @Override
            public void actionPerformed(ActionEvent a) {
                // This grabs the button info
                String buttonPressed = a.getActionCommand(); 
                // This defines what happens when each button is pressed
                switch(buttonPressed) {
                    case "Direction":
                        sfx.buttonSound();
                        game.playerTurn(1);
                        break;
                    case "Move": 
                        sfx.buttonSound();
                        game.playerTurn(2);
                        break;
                    case "Attack": 
                        sfx.buttonSound();
                        game.playerTurn(3);
                        break;
                    case "Special": 
                        sfx.buttonSound();
                        game.playerTurn(4);
                        break;
                }  
            }
        };
    }

}
