package chkn;

import Chicken_Types.*;
import User_Interface.Window_Manager;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Ai_Logic {
    // Intialize computer
    public static Chicken initializeComputer(String computerName, int choice) {
        Chicken playerChicken;
        switch (choice) {
            case 1:
                playerChicken = new teleChicken(computerName, 135, 9, 9, 9, 9, 15, 1);
                
                System.out.println("Computer chose Teleporting chicken");
                return playerChicken;
            case 2:
                playerChicken = new healerChicken(computerName, 95, 9, 9, 9, 9, 15, 1);

                System.out.println("Computer chose a Healer chicken");
                return playerChicken;
            case 3:
                playerChicken = new powerChicken(computerName, 145, 9, 9, 9, 9, 15, 1);

                System.out.println("Computer chose a Powerful chicken");
                return playerChicken;
            case 4:
                playerChicken = new fastChicken(computerName, 105, 9, 9, 9, 9, 15, 1);

                System.out.println("Computer chose a Fast chicken");
                return playerChicken;  
            default:
                playerChicken = new defChicken(computerName, 100, 9, 9, 9, 9, 15, 1);

                System.out.println("Didn't pick a chicken, default is chosen");
                return playerChicken;
        }
    }
    
    // Determine move of ai
    public static void aiTurn(Chicken computerPlayer, Chicken player, int difficulty, Window_Manager wm, Sound_fx sfx) {
        switch (difficulty) {
            case 1:
                aiEasyAction(computerPlayer, player, wm, sfx);
                System.out.println("Computer Easy move choice");
                break;
            case 2:
                aiMediumAction(computerPlayer, player, wm, sfx);
                System.out.println("Computer Medium move choice");
                break;
            case 3:
                aiHardAction(computerPlayer, player, wm, sfx);
                System.out.println("Computer Hard move choice");
                break;
            case 4:
                aiJustGiveUpAction(computerPlayer, player, wm, sfx);
                System.out.println("Computer Just Give Up move choice");
                break; 
            default:
                aiEasyAction(computerPlayer, player, wm, sfx);
                System.out.println("Defualt Easy move choice");
                break;
        }
    }

    // Take the move of the Ai predecided by algorithm
    private static void aiTakeMove(Chicken computer, Chicken player, int moveChoice, int aiDirectionChoice, Window_Manager wm, Sound_fx sfx) {
        switch (moveChoice) {
            case 1:
                sfx.moveSound();
                wm.markBoard(computer.y_coord, computer.x_coord, null);
                computer.move();
                wm.markBoard(computer.y_coord, computer.x_coord, computer.getIcon());
                System.out.println("Computer changing direction");
                break;
            case 2:
                sfx.moveSound();
                wm.markBoard(computer.y_coord, computer.x_coord, null);
                computer.setIcon(aiDirectionChoice);
                computer.change_direction(aiDirectionChoice);
                wm.markBoard(computer.y_coord, computer.x_coord, computer.getIcon());
                System.out.println("Computer is Moving");
                break;
            case 3:
                sfx.attackSound();
                player.hit(computer.attack(player.get_location()));
                System.out.println("Computer is Attacking");
                break;
            case 4:
                sfx.specialButtonSound();
                wm.markBoard(computer.y_coord, computer.x_coord, null);
                computer.specialMove(player);
                wm.markBoard(computer.y_coord, computer.x_coord, computer.getIcon());
                System.out.println("Computer is using special");
                break; 
            default:
                sfx.moveSound();
                wm.markBoard(computer.y_coord, computer.x_coord, null);
                computer.move();
                wm.markBoard(computer.y_coord, computer.x_coord, computer.getIcon());
                System.out.println("Default is to move");
                break;
        }
    }

    // Define logic for easy mode
    private static void aiEasyAction(Chicken computerPlayer, Chicken player, Window_Manager wm, Sound_fx sfx) {
        int moveChoice;
        int aiDirectionChoice = project_1.Utilities.calc_random(1, 4);
        double randomMove = Math.random();

        // Pick a random move
        if (randomMove < 0.4) {
            moveChoice = 1; // Change direction
        } else if (randomMove < 0.8 && randomMove > 0.4) {
            moveChoice = 2; // Move forward
        }else {
            moveChoice = 4; // Special Move
        }

        int[] nextMove = computerPlayer.new_movement();
        int next_y = nextMove[0], next_x = nextMove[1];
        // Check to see if the player is in front of the computer if so attack
        if(next_y == player.y_coord && next_x == player.x_coord) {
            moveChoice = 3; // Attempt an attack
        } else if(computerPlayer.y_coord == player.y_coord && computerPlayer.x_coord == player.x_coord) {
            moveChoice = 3; 
        }

        aiTakeMove(computerPlayer, player, moveChoice, aiDirectionChoice, wm, sfx);
    }

    // Define logic for medium mode
    private static void aiMediumAction(Chicken computerPlayer, Chicken player, Window_Manager wm, Sound_fx sfx) {
        int directionChoice = pathFind(computerPlayer, player);
        int moveChoice;
        double randomMove = Math.random();

        // Pick a random move
        if (randomMove < 0.4) {
            moveChoice = 1; // Change direction
        } else if (randomMove < 0.8 && randomMove > 0.4) {
            moveChoice = 2; // Move forward
        }else {
            moveChoice = 4; // Special Move
        }

        int[] nextMove = computerPlayer.new_movement();
        int next_y = nextMove[0], next_x = nextMove[1];
        // Check to see if the player is in front of the computer if so attack
        if(next_y == player.y_coord && next_x == player.x_coord) {
            moveChoice = 3; // Attempt an attack
        } else if(computerPlayer.y_coord == player.y_coord && computerPlayer.x_coord == player.x_coord) {
            moveChoice = 3; 
        }

        aiTakeMove(computerPlayer, player, moveChoice, directionChoice, wm, sfx);
    }

    // Define logic for hard mode
    private static void aiHardAction(Chicken computerPlayer, Chicken player, Window_Manager wm, Sound_fx sfx) {
        int directionChoice = pathFind(computerPlayer, player);
        int moveChoice;
        double randomMove = Math.random();

        // Pick a random move
        if (randomMove < 0.5) {
            moveChoice = 1; // Change direction
        } else if (randomMove < 0.9 && randomMove > 0.5) {
            moveChoice = 2; // Move forward
        }else {
            moveChoice = 4; // Special Move
        }

        int[] nextMove = computerPlayer.new_movement();
        int next_y = nextMove[0], next_x = nextMove[1];
        // Check to see if the player is in front of the computer if so attack
        if(next_y == player.y_coord && next_x == player.x_coord) {
            moveChoice = 3; // Attempt an attack
        }

        aiTakeMove(computerPlayer, player, moveChoice, directionChoice, wm, sfx);
    }

    // Define logic for hardest mode
    private static void aiJustGiveUpAction(Chicken computerPlayer, Chicken player, Window_Manager wm, Sound_fx sfx) {
        int directionChoice = pathFind(computerPlayer, player);
        int moveChoice;
        double randomMove = Math.random();

        // Pick a random move
        if (randomMove < 0.6) {
            moveChoice = 1; // Change direction
        } else if (randomMove < 0.9 && randomMove > 0.6) {
            moveChoice = 2; // Move forward
        }else {
            moveChoice = 4; // Special Move
        }

        int[] nextMove = computerPlayer.new_movement();
        int next_y = nextMove[0], next_x = nextMove[1];
        // Check to see if the player is in front of the computer if so attack
        if(next_y == player.y_coord && next_x == player.x_coord) {
            moveChoice = 3; // Attempt an attack
        }

        aiTakeMove(computerPlayer, player, moveChoice, directionChoice, wm, sfx);
    }

    // Set the icons
    public static void setComputerIcons(Chicken computer)  {
        Image imgCurrent, imgNorth, imgEast, imgSouth, imgWest;
        Icon iconCurrent, iconNorth, iconEast, iconSouth, iconWest;
        try {
            // Get images
            imgCurrent = ImageIO.read(new File("src\\Images\\Computer_Chicken\\BownChickenUp.png"));
            imgNorth = ImageIO.read(new File("src\\Images\\Computer_Chicken\\BownChickenUp.png"));
            imgEast = ImageIO.read(new File("src\\Images\\Computer_Chicken\\BrownChickenRight.png"));
            imgSouth = ImageIO.read(new File("src\\Images\\Computer_Chicken\\BorwnChickenDown.png"));
            imgWest = ImageIO.read(new File("src\\Images\\Computer_Chicken\\BrownChickenLeft.png"));

            // Get icons
            iconCurrent = new ImageIcon(imgCurrent.getScaledInstance(59, 59, Image.SCALE_DEFAULT));
            iconNorth = new ImageIcon(imgNorth.getScaledInstance(59, 59, Image.SCALE_DEFAULT));
            iconEast = new ImageIcon(imgEast.getScaledInstance(59, 59, Image.SCALE_DEFAULT));
            iconSouth = new ImageIcon(imgSouth.getScaledInstance(59, 59, Image.SCALE_DEFAULT));
            iconWest = new ImageIcon(imgWest.getScaledInstance(59, 59, Image.SCALE_DEFAULT));

            // Set icons
            computer.setIcons(iconCurrent, iconEast, iconNorth, iconWest, iconSouth);
        } catch (IOException e) {
            System.out.println("Failed to get images");
            e.printStackTrace();
        }
    }

    // Simple pathfinding algorithm
    public static int pathFind(Chicken computerPlayer, Chicken player) {
        // Gets the difference in the players coordinates
        int diff_y = player.y_coord - computerPlayer.y_coord;
        int diff_x = player.x_coord - computerPlayer.x_coord;
    
        // Sets a defualt direction
        int directionUpDownChoice = project_1.Utilities.calc_random(1, 4), directionLeftRightChoice = project_1.Utilities.calc_random(1, 4);

        // This will choose whether the computer needs to go up or down to get to the player
        if(diff_y > 0) {
            directionUpDownChoice = 3;
        }else if(diff_y < 0) {
            directionUpDownChoice = 1;
        }
        
        // This will choose whether the computer needs to go left or right to get to the player
        if(diff_x > 0) {
            directionLeftRightChoice = 2;
        }else if(diff_x < 0) {
            directionLeftRightChoice = 4;
        }
                
        // If the computer is already lined up with player than it will choose only one direction;
        if(diff_x == 0) {
        directionLeftRightChoice = directionUpDownChoice;
        }else if(diff_y == 0) {
        directionUpDownChoice = directionLeftRightChoice;
        }

        double directionChoice = Math.random();
        if(directionChoice > 0.5) {
            return directionUpDownChoice;
        } else {
            return directionLeftRightChoice;
        }
    }
}
