package Game_Screen;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.*;

public class StatsPanel extends JPanel {
    private String playerType = "Player", chickenType = "Chicken";
    private int currentHP = 0;
    private JLabel nameLabel, typeLabel, healthLabel;
    private JPanel statPane;

    protected StatsPanel(String playerType) {
        this.playerType = playerType;
        createPanel();
    }

    private void createPanel() {
        // Add attributes
        this.setPreferredSize(new Dimension(300, 100));
        this.setLayout(new BorderLayout());
        this.setBackground(Color.cyan);
        this.setBorder(BorderFactory.createRaisedSoftBevelBorder());

        // Create labels
        createNamePane();
    }

    // Create the nametag panel
    private void createNamePane() {
        nameLabel = new JLabel();
        nameLabel = new JLabel("--- " + this.playerType + " ---", SwingConstants.CENTER);
        nameLabel.setFont(new Font("New Times Roman", Font.BOLD, 20));
        nameLabel.setForeground(Color.white);
        nameLabel.setPreferredSize(new Dimension(300, 25));
        nameLabel.setVisible(true);
        this.add(nameLabel, BorderLayout.NORTH);

        createStatPane();
    }

    // Create the chicken status panel
    private void createStatPane() {
        // Create stats panel
        statPane = new JPanel();
        statPane.setLayout(new BorderLayout(20, 20));
        statPane.setPreferredSize(new Dimension(300, 60));
        statPane.setBackground(Color.darkGray);
        this.add(statPane, BorderLayout.SOUTH);

        // Create stats indicator
        typeLabel = new JLabel("Chicken Type - " + this.chickenType, SwingConstants.CENTER);
        typeLabel.setFont(new Font("Ink Free", Font.PLAIN, 20));
        typeLabel.setForeground(Color.white);
        statPane.add(typeLabel, BorderLayout.NORTH);


        healthLabel = new JLabel("Current Health is - " + this.currentHP, SwingConstants.CENTER);
        healthLabel.setFont(new Font("Ink Free", Font.PLAIN, 20));
        healthLabel.setForeground(Color.white);
        statPane.add(healthLabel, BorderLayout.SOUTH);

    }

    // Be able to set the chicken types
    protected void setPlayerType(String chickenType) {
        this.typeLabel.setText("Chicken Type - " + chickenType);
    }

    // Be able to set and update hp
    protected void hpUpdate(int currentHP) {
        this.healthLabel.setText("Current Health is - " + currentHP);
    }

    // Set player name
    protected void setPlayerName(String playerName) {
        if (playerName.length() > 8) {
            playerName = playerName.substring(0,8);
            nameLabel.setText("--- " + playerName + "... ---");
        } else {
            nameLabel.setText("--- " + playerName + " ---");
       }    
    }
}
