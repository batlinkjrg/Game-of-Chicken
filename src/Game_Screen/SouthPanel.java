package Game_Screen;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.*;

public class SouthPanel extends JPanel {
    private ButtonsPanel actionButtons, directionButtons;
    private StatsPanel playerInfo, computerInfo;
    private ActionListener actionListener,  directionListener, resetListener;
    private JPanel buttonDisplay, statsPanel;
    private JButton resetButton;

    protected SouthPanel(ActionListener actionListener, ActionListener directionListener, ActionListener resetListener) {
        // Sync variables
        this.actionListener = actionListener;
        this.directionListener = directionListener;
        this.resetListener = resetListener;
        // Create south panel
        createSouthPanel();
    }

    // Initialize panel
    private void createSouthPanel() {
        // Add some attributes
        this.setBackground(new Color(112, 224, 240));
        this.setBorder(new LineBorder(Color.BLUE));
        this.setPreferredSize(new Dimension(1280, 100));
        this.setLayout(new BorderLayout());
        this.setVisible(true);

        // Create panel to hold buttons
        buttonDisplay = new JPanel();
        buttonDisplay.setPreferredSize(new Dimension(600, 100));
        buttonDisplay.setLayout(new OverlayLayout(buttonDisplay));
        this.add(buttonDisplay, BorderLayout.EAST);

        // Initialize buttons
        initialize_ActionButtons();
        initialize_DirectionButtons();

        // Create panel to hold stats
        statsPanel = new JPanel();
        statsPanel.setPreferredSize(new Dimension(600, 100));
        statsPanel.setLayout(new BorderLayout());
        this.add(statsPanel, BorderLayout.WEST);

        // Initialize stats
        initialize_Playerstats();
        initialize_ComputerStats();

        // Reset Button
        createResetButton();
    }

    // Create action buttons
    private void initialize_ActionButtons() {
        actionButtons = new ButtonsPanel(this.actionListener, "Action", "Direction", "Move", "Attack", "Special");
        actionButtons.setVisible(true);
        buttonDisplay.add(actionButtons);
    }

    // Create direction buttons
    private void initialize_DirectionButtons() {
        directionButtons = new ButtonsPanel(this.directionListener, "Direction", "North", "East", "South", "West");
        directionButtons.setVisible(false);
        buttonDisplay.add(directionButtons);
    }

    // Create player stats
    private void initialize_Playerstats() {
        playerInfo = new StatsPanel("Player");
        playerInfo.setVisible(true);
        statsPanel.add(playerInfo, BorderLayout.WEST);
    }

    // Create computer stats
    private void initialize_ComputerStats() {
        computerInfo = new StatsPanel("Computer");
        computerInfo.setVisible(true);
        statsPanel.add(computerInfo, BorderLayout.EAST);
    }

    // Create reset button
    private void createResetButton() {
        resetButton = new JButton("-Reset-");
        resetButton.setBackground(new Color(112, 224, 240));
        resetButton.setForeground(Color.white);
        resetButton.setActionCommand("Reset");
        resetButton.addActionListener(resetListener);
        resetButton.setBorder(BorderFactory.createRaisedSoftBevelBorder());

        this.add(resetButton, BorderLayout.CENTER);
    }

    // Allows a way to show direction panel
    protected void switchToDirections(boolean switchPanels) {
        if(switchPanels == true) {
            directionButtons.setVisible(true);
            actionButtons.setVisible(false);
        }else {
            actionButtons.setVisible(true);
            directionButtons.setVisible(false);
        }
    }

    // Allows a way to set the chicken type for the players
    protected void setChickenTypes(String playerChickenType, String computerChickenType) {
        playerInfo.setPlayerType(playerChickenType);
        computerInfo.setPlayerType(computerChickenType);
    }

    // Allows setting and updating of chicken hp
    protected void hpUpdate(int playerHP, int computerHP) {
        playerInfo.hpUpdate(playerHP);
        computerInfo.hpUpdate(computerHP);
    }

    // Set player and computer names
    protected void nameUpdate(String playerName, String computerName) {
        playerInfo.setPlayerName(playerName);
        computerInfo.setPlayerName(computerName);
    }

    // Disable buttons for victory
    protected void disableButtons() {
        this.actionButtons.disableButtons();
        this.directionButtons.disableButtons();
    }
}