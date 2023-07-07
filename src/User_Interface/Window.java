package User_Interface;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;

import Game_Screen.GameScreen;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class Window extends JFrame {

    GameScreen gScreen;
    TitleScreen tScreen;

    private Image windowIconCache;
    private ImageIcon windowIcon;

    protected ActionListener actionListener, directionListener, chickenChoiceListener, resetStartListener, difficultyListener;

    public Window (ActionListener resetStartListener, ActionListener actionListener, ActionListener directionListener, ActionListener chickenChoiceListener, ActionListener difficultyListener) {
        // Sync variables
        this.resetStartListener = resetStartListener;
        this.actionListener = actionListener;
        this.directionListener = directionListener;
        this.chickenChoiceListener = chickenChoiceListener;
        this.difficultyListener = difficultyListener;
        setFrame();
    }

    // Create window
    private void setFrame() {
        // Create Icon
        try {
            windowIconCache = ImageIO.read(new File("src\\Images\\ChickenPixelArt.png")); 
            windowIcon = new ImageIcon(windowIconCache);
            this.setIconImage(windowIcon.getImage());
         } catch (IOException exc) {
             exc.printStackTrace();
         }

        // Add atrributes
        this.setSize(1296, 759);
        this.setResizable(false);
        this.setLocation(100, 100);
        this.setTitle("Game of Chicken");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.green);


        // Create Panels
        gScreen = new GameScreen(this.actionListener, this.directionListener, this.resetStartListener);
        gScreen.setVisible(false);
        this.getContentPane().add(gScreen);
        tScreen = new TitleScreen(this.chickenChoiceListener, this.resetStartListener, this.difficultyListener);
        tScreen.setVisible(true);
        this.getContentPane().add(tScreen);

        // Set visablity
        this.setVisible(true);
    }

    protected void switchToTitle(boolean switchToTitle) {
        if(switchToTitle == true) {
            gScreen.setVisible(false);
            tScreen.setVisible(true);
        } else {
            gScreen.setVisible(true);
            tScreen.setVisible(false);
        }
    }
}
