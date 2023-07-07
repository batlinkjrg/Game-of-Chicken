package Game_Screen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ButtonsPanel extends JPanel {
    private JButton[][] actionButtons;
    private JPanel actionButtonsPanel;
    private JLabel selectAction;
    private ActionListener actionListener;
    private String optionSet, buttonOne, buttonTwo, buttonThree, buttonFour;
    
    public ButtonsPanel(ActionListener actionListener,String optionSet, String buttonOne, String buttonTwo, String buttonThree, String buttonFour) {
        // Sync action listeners
        this.actionListener = actionListener;
        this.optionSet = optionSet;
        this.buttonOne = buttonOne;
        this.buttonTwo = buttonTwo;
        this.buttonThree = buttonThree;
        this.buttonFour = buttonFour;

        // Create attributes
        this.setBackground(Color.CYAN);
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(600, 100));
        this.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        // Get buttons
        createActionButtons();
    }

    // Create buttons
    private void createActionButtons() {
        // Upper Text
        selectAction = new JLabel("--- Choose " + this.optionSet + " ---", SwingConstants.CENTER);
        selectAction.setFont(new Font("New Times Roman", Font.BOLD, 20));
        selectAction.setForeground(Color.white);
        selectAction.setPreferredSize(new Dimension(600, 25));
        selectAction.setVisible(true);
        this.add(selectAction, BorderLayout.NORTH);

        // Buttons
        actionButtons = new JButton[1][4];

        // Buttons Panel
        actionButtonsPanel = new JPanel();
        actionButtonsPanel.setBackground(Color.darkGray);
        actionButtonsPanel.setPreferredSize(new Dimension(600, 60));
        actionButtonsPanel.setVisible(true);
        this.add(actionButtonsPanel, BorderLayout.SOUTH);
        actionButtons();
    }

    // Create action buttons
    private void actionButtons() {
        ButtonOne();
        ButtonTwo();
        ButtonThree();
        ButtonFour();
    }

    // Create button one
    private void ButtonOne() {
        int i = 0;
        actionButtons[0][i] = new JButton(this.buttonOne);
        actionButtons[0][i].addActionListener(this.actionListener);
        actionButtons[0][i].setActionCommand(this.buttonOne);
        actionButtons[0][i].setBackground(Color.darkGray);
        actionButtons[0][i].setForeground(Color.lightGray);
        actionButtons[0][i].setPreferredSize(new Dimension(100, 50));
        actionButtons[0][i].setBorder(BorderFactory.createEtchedBorder(new Color(154, 168, 53), new Color(79, 84, 26)));

        actionButtonsPanel.add(actionButtons[0][i]);
    }

    // Create button two
    private void ButtonTwo() {
        int i = 1;
        actionButtons[0][i] = new JButton(this.buttonTwo);
        actionButtons[0][i].addActionListener(this.actionListener);
        actionButtons[0][i].setActionCommand(this.buttonTwo);
        actionButtons[0][i].setBackground(Color.darkGray);
        actionButtons[0][i].setForeground(Color.lightGray);
        actionButtons[0][i].setPreferredSize(new Dimension(100, 50));
        actionButtons[0][i].setBorder(BorderFactory.createEtchedBorder(new Color(53, 168, 65), new Color(36, 84, 51)));

        actionButtonsPanel.add(actionButtons[0][i]);
    }

    // Create button three
    private void ButtonThree() {
        int i = 2;
        actionButtons[0][i] = new JButton(this.buttonThree);
        actionButtons[0][i].addActionListener(this.actionListener);
        actionButtons[0][i].setActionCommand(this.buttonThree);
        actionButtons[0][i].setBackground(Color.darkGray);
        actionButtons[0][i].setForeground(Color.lightGray);
        actionButtons[0][i].setPreferredSize(new Dimension(100, 50));
        actionButtons[0][i].setBorder(BorderFactory.createEtchedBorder(new Color(168, 53, 53), new Color(84, 36, 36)));

        actionButtonsPanel.add(actionButtons[0][i]);
    }

    // Create button four
    private void ButtonFour() {
        int i = 3;
        actionButtons[0][i] = new JButton(this.buttonFour);
        actionButtons[0][i].addActionListener(this.actionListener);
        actionButtons[0][i].setActionCommand(this.buttonFour);
        actionButtons[0][i].setBackground(Color.darkGray);
        actionButtons[0][i].setForeground(Color.lightGray);
        actionButtons[0][i].setPreferredSize(new Dimension(100, 50));
        actionButtons[0][i].setBorder(BorderFactory.createEtchedBorder(new Color(53, 55, 168), new Color(36, 36, 84)));

        actionButtonsPanel.add(actionButtons[0][i]);
    }

    // disable buttons
    protected void disableButtons() {
        actionButtons[0][0].setEnabled(false);
        actionButtons[0][1].setEnabled(false);
        actionButtons[0][2].setEnabled(false);
        actionButtons[0][3].setEnabled(false);
    }
}
