package Game_Screen;

import javax.swing.*;

import User_Interface.Window;

import java.awt.*;

public class Game_Manager {

    private GameScreen gScreen;
    
    public Game_Manager(GameScreen gScreen) {
      this.gScreen = gScreen;
    }

    // Be able to change the text at the top of the window
    public final void changeNorthText(String text) {
      gScreen.north_Panel.changeNorthText(text);
    }

    // Be able to put a character on the board
    public final void markBoard(int y, int x, Icon icon) {
      gScreen.center_Panel.mark_board(y, x, icon);
    }

    // Controls visiblity of the game screen
    public final void setVisible(boolean visable) {
      gScreen.setVisible(visable);
    }

    // This is to toggle the direction panel
    public final void switchToDirections(boolean switchPanels) {
      gScreen.south_Panel.switchToDirections(switchPanels);
    }

    // This is to set the type of chicken the players are
    public final void setChickenTypes (String playerChickenType, String computerChickenType) {
      gScreen.south_Panel.setChickenTypes(playerChickenType, computerChickenType);
    }

    // Allows setting and updating of chicken hp
    public final void hpUpdate(int playerHP, int computerHP) {
      gScreen.south_Panel.hpUpdate(playerHP, computerHP);
    }

    // Used to end the game
    public final void disableButtons() {
      gScreen.south_Panel.disableButtons();
    }

    // Used to set players names
    public void nameUpdate(String playerName, String computerName) {
      gScreen.south_Panel.nameUpdate(playerName, computerName);
   }
}
