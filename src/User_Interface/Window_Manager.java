package User_Interface;

import Game_Screen.Game_Manager;
import chkn.chkn_main;

import javax.swing.Icon;
import java.awt.event.*;

import Game_Screen.GameScreen;

public class Window_Manager {
    
    private Game_Manager gScreen;
    private TitleScreen tScreen;
    private Window window;
    
    public Window_Manager(Window window) {
      this.window = window;
      this.gScreen = new Game_Manager(window.gScreen);
      this.tScreen = window.tScreen;
    }

    // Be able to change the text at the top of the window
    public final void changeNorthText(String text) {
      gScreen.changeNorthText(text);
    }

    // Be able to put a character on the board
    public final void markBoard(int y, int x, Icon icon) {
      gScreen.markBoard(y, x, icon);
    }

    // This is to set the visablity of the game screen
    public final void setVisible(boolean visable) {
      gScreen.setVisible(visable);
    }

    // This is to set title screen or not
    public final void titleScreen(boolean titleScreen) {
      if(titleScreen == true) {
        gScreen.setVisible(false);
        tScreen.setVisible(true);
      }else {
        tScreen.setVisible(false);
        gScreen.setVisible(true);
      }
    }

    // This is to toggle the direction panel
    public final void switchToDirections(boolean switchPanels) {
      gScreen.switchToDirections(switchPanels);
    }

    // Thisis to set the type of chicken the players are
    public final void setChickenTypes (String playerChickenType, String computerChickenType) {
      gScreen.setChickenTypes(playerChickenType, computerChickenType);
    }

    // Allows setting and updating of chicken hp
    public final void hpUpdate(int playerHP, int computerHP) {
      gScreen.hpUpdate(playerHP, computerHP);
    }

    // Allows picking of player chicken
    public final void switchChickenChoice(boolean switchChickenChoice) {
      tScreen.switchChickenChoice(switchChickenChoice);
    }

    // Switch to difficulty panel
    public final void switchDifficultyPanel(boolean switchDifficultyPanel) {
      tScreen.switchDifficultyPanel(switchDifficultyPanel);
    }

    // This will get the players name
    public final String getPlayerName() {
      return tScreen.getPlayerName();
    }

    // This will close and reset the window
    public final void closeWindow() {
      this.window.dispose();
      chkn_main.playGame();
    }

    // To disable action buttons at the end of the game
    public final void disableButtons() {
      gScreen.disableButtons();
    }

    // Used to set players names
    public void nameUpdate(String playerName, String computerName) {
      gScreen.nameUpdate(playerName, computerName);
   }
}

