package chkn;

import java.awt.Image;
import java.awt.font.ImageGraphicAttribute;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import Chicken_Types.*;
import User_Interface.Window_Manager;

public class Player {
    private static Image img;

    // This will initiate the chosen chicken by the player
    public static Chicken intializePlayer(String playerName, int chickenType) {
        
        Chicken playerChicken;
        switch (chickenType) {
            case 1:
                playerChicken = new teleChicken(playerName, 135, 1, 1, 9, 9, 15, 3);

                System.out.println("Player chose Teleporting chicken");
                return playerChicken;
            case 2:
                playerChicken = new healerChicken(playerName, 95, 1, 1, 9, 9, 15, 3);

                System.out.println("Player chose a Healer chicken");
                return playerChicken;
            case 3:
                playerChicken = new powerChicken(playerName, 145, 1, 1, 9, 9, 15, 3);

                System.out.println("Player chose a Powerful chicken");
                return playerChicken;
            case 4:
                playerChicken = new fastChicken(playerName, 105, 1, 1, 9, 9, 15, 3);

                System.out.println("Player chose a Fast chicken");
                return playerChicken;  
            default:
                playerChicken = new defChicken(playerName, 100, 1, 1, 9, 9, 15, 3);

                System.out.println("Didn't pick a chicken, default is chosen");
                return playerChicken;
        }
    }

    // Used to take a player turn
    public static void takeTurn(Chicken computerPlayer, Chicken player, int choice, Window_Manager wm, Sound_fx sfx) {
        wm.markBoard(player.y_coord, player.x_coord, null);
        switch (choice) {
            case 1:
                wm.switchToDirections(true);
                System.out.println("Player chose to change direction");
                break;
            case 2:
                sfx.moveSound();
                wm.markBoard(player.y_coord, player.x_coord, null);
                player.move();
                wm.markBoard(player.y_coord, player.x_coord, player.getIcon());
                System.out.println("Player chose to move");
                break;
            case 3:
                sfx.attackSound();
                computerPlayer.hit(player.attack(computerPlayer.get_location()));
                System.out.println("Player chose to attack");
                break;
            case 4:
                sfx.specialButtonSound();
                wm.markBoard(player.y_coord, player.x_coord, null);
                player.specialMove(computerPlayer);
                wm.markBoard(player.y_coord, player.x_coord, player.getIcon());
                System.out.println("Player chose to use their special move");
                break; 
            default:
                sfx.moveSound();
                wm.markBoard(player.y_coord, player.x_coord, null);
                player.move();
                wm.markBoard(player.y_coord, player.x_coord, player.getIcon());
                System.out.println("Defualt is move choice");
                break;
        }
        wm.markBoard(player.y_coord, player.x_coord, player.getIcon());
    }

    // Used to change the players direction
    public static void changeDirection(Chicken player, int choice, Window_Manager wm, Sound_fx sfx) {
        switch (choice) {
            case 1:
                sfx.moveSound();
                wm.markBoard(player.y_coord, player.x_coord, null);
                player.setIcon(1);
                player.change_direction(1);
                wm.markBoard(player.y_coord, player.x_coord, player.getIcon());
                wm.switchToDirections(false);
                System.out.println("Player chose to move North");
                break;
            case 2:
                sfx.moveSound();
                wm.markBoard(player.y_coord, player.x_coord, null);
                player.setIcon(2);
                player.change_direction(2);
                wm.markBoard(player.y_coord, player.x_coord, player.getIcon());
                wm.switchToDirections(false);
                System.out.println("Player chose to move East");
                break;
            case 3:
                sfx.moveSound();
                wm.markBoard(player.y_coord, player.x_coord, null);
                player.setIcon(3);
                player.change_direction(3);
                wm.markBoard(player.y_coord, player.x_coord, player.getIcon());
                wm.switchToDirections(false);
                System.out.println("Player chose to move South");
                break;
            case 4: 
                sfx.moveSound();
                wm.markBoard(player.y_coord, player.x_coord, null);
                player.setIcon(4);
                player.change_direction(4);
                wm.markBoard(player.y_coord, player.x_coord, player.getIcon());
                wm.switchToDirections(false);
                System.out.println("Player chose to move West");
                break; 
            default:
                sfx.moveSound();
                wm.switchToDirections(false);
                System.out.println("Defualt is to go back to choices");
                break;
        }
    }

    // set the icons
    public static void setPlayerIcons(Chicken player)  {
        Image imgCurrent, imgNorth, imgEast, imgSouth, imgWest;
        Icon iconCurrent, iconNorth, iconEast, iconSouth, iconWest;
        try {
            // Get images
            imgCurrent = ImageIO.read(new File("src\\Images\\Player_Chicken\\WhiteChickenDown.png"));
            imgNorth = ImageIO.read(new File("src\\Images\\Player_Chicken\\WhiteChickenUp.png"));
            imgEast = ImageIO.read(new File("src\\Images\\Player_Chicken\\WhiteChickenRight.png"));
            imgSouth = ImageIO.read(new File("src\\Images\\Player_Chicken\\WhiteChickenDown.png"));
            imgWest = ImageIO.read(new File("src\\Images\\Player_Chicken\\WhiteChickenLeft.png"));

            // Get icons
            iconCurrent = new ImageIcon(imgCurrent.getScaledInstance(59, 59, Image.SCALE_DEFAULT));
            iconNorth = new ImageIcon(imgNorth.getScaledInstance(59, 59, Image.SCALE_DEFAULT));
            iconEast = new ImageIcon(imgEast.getScaledInstance(59, 59, Image.SCALE_DEFAULT));
            iconSouth = new ImageIcon(imgSouth.getScaledInstance(59, 59, Image.SCALE_DEFAULT));
            iconWest = new ImageIcon(imgWest.getScaledInstance(59, 59, Image.SCALE_DEFAULT));

            // Set icons
            player.setIcons(iconCurrent, iconEast, iconNorth, iconWest, iconSouth);
        } catch (IOException e) {
            System.out.println("Failed to get images");
            e.printStackTrace();
        }
    }
}
