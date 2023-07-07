package User_Interface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import test.Gameplay;

public class graphic_interface extends JFrame {
    
    public void createUI(Gameplay game) {
        JFrame window;
        JPanel direction_buttons, choice_buttons, board_panel, stats_panel, getName_Panel; 
        JTable board;
        JLabel current_hp_label, name_label, direction_Label, getName_label;
        JTextField name_field, hp_field, getName_Field;
        JButton northButton, southButton, eastButton, westButton, getName_Button;
        


        // Window
        window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(true);
        window.setSize(800, 600);
        window.setLayout(new BorderLayout(0, 10));
        window.setBackground(Color.gray);
        window.setVisible(true);

        // GetName/Start Menu
        getName_Panel = new JPanel();
        
            // Get name label

            // Get name field

            // Get name Button

        // Board Panel
        board_panel = new JPanel();
        board_panel.setPreferredSize(new Dimension(600, 450));
        board_panel.setBackground(Color.white);
        window.add(board_panel, BorderLayout.CENTER);
        window.setVisible(true);

            // States Label
            stats_panel = new JPanel();
            stats_panel.setBackground(Color.darkGray);
            stats_panel.setPreferredSize(new Dimension(600, 50));
            stats_panel.setVisible(true);
            stats_panel.setLayout(new BoxLayout(stats_panel, BoxLayout.LINE_AXIS));
            board_panel.add(stats_panel, BorderLayout.NORTH);

                // HP Stat
                current_hp_label = new JLabel();
                current_hp_label.setText("Your Current HP is - ");
                current_hp_label.setFont(new Font("Ink Free", Font.PLAIN, 15));
                current_hp_label.setForeground(Color.magenta);
                current_hp_label.setBackground(Color.lightGray); 
                current_hp_label.setPreferredSize(new Dimension(130, 50));
                current_hp_label.setVisible(true);

                    // HP Stat Field
                    hp_field = new JTextField();
                    hp_field.setEditable(false);
                    hp_field.setText("130");
                    hp_field.setFont(new Font("Ink Free", Font.PLAIN, 15));
                    hp_field.setForeground(Color.magenta);
                    hp_field.setBackground(Color.lightGray); 
                    hp_field.setPreferredSize(new Dimension(100, 50));

                // Name 
                name_label = new JLabel();
                name_label.setText("Name - ");
                name_label.setFont(new Font("Ink Free", Font.PLAIN, 15));
                name_label.setForeground(Color.magenta);
                name_label.setBackground(Color.lightGray); 
                name_label.setPreferredSize(new Dimension(75, 50));
                name_label.setVisible(true);

                    // Name Field
                    name_field = new JTextField();
                    name_field.setEditable(false);
                    name_field.setText("Freddy");
                    name_field.setFont(new Font("Ink Free", Font.PLAIN, 15));
                    name_field.setForeground(Color.magenta);
                    name_field.setBackground(Color.lightGray); 
                    name_field.setPreferredSize(new Dimension(100, 50));

                // Final Layout
                stats_panel.add(name_label);
                stats_panel.add(name_field);
                stats_panel.add(Box.createHorizontalStrut(170));
                stats_panel.add(current_hp_label);
                stats_panel.add(hp_field); 

        // Directions Button Panel
        direction_buttons = new JPanel();
        direction_buttons.setPreferredSize(new Dimension(600, 150));
        direction_buttons.setBackground(Color.darkGray);
        direction_buttons.setLayout(new BorderLayout(100,0));
        direction_buttons.setVisible(false);
        window.add(direction_buttons, BorderLayout.SOUTH);

            // North Button
            northButton = new JButton("North");
            northButton.setActionCommand("n_direction");
            northButton.setSize(80, 40);
            northButton.setFont(new Font("Ink Free", Font.PLAIN, 15));
            northButton.setForeground(Color.magenta);
            northButton.setBackground(Color.black);
            northButton.setVisible(true);
            direction_buttons.add(northButton, BorderLayout.NORTH);

            // East Button
            eastButton = new JButton("East");
            eastButton.setActionCommand("e_direction");
            eastButton.setSize(80, 40);
            eastButton.setFont(new Font("Ink Free", Font.PLAIN, 15));
            eastButton.setForeground(Color.magenta);
            eastButton.setBackground(Color.black);
            eastButton.setVisible(true);
            direction_buttons.add(eastButton, BorderLayout.EAST);

            // South Button
            southButton = new JButton("South");
            southButton.setActionCommand("s_direction");
            southButton.setSize(80 , 40);
            southButton.setFont(new Font("Ink Free", Font.PLAIN, 15));
            southButton.setForeground(Color.magenta);
            southButton.setBackground(Color.black);
            southButton.setVisible(true);
            direction_buttons.add(southButton, BorderLayout.SOUTH);

            // West Button
            westButton = new JButton("West");
            westButton.setActionCommand("w_direction");
            westButton.setSize(80, 40);
            westButton.setFont(new Font("Ink Free", Font.PLAIN, 15));
            westButton.setForeground(Color.magenta);
            westButton.setBackground(Color.black);
            westButton.setVisible(true);
            direction_buttons.add(westButton, BorderLayout.WEST); 

            // Direction Label
            direction_Label = new JLabel();
            direction_Label.setSize(80, 40);
            direction_Label.setFont(new Font("Ink Free", Font.PLAIN, 55));
            direction_Label.setForeground(Color.green);
            direction_Label.setBackground(Color.black);
            direction_Label.setText("Pick your direction");
            direction_buttons.add(direction_Label, BorderLayout.CENTER);

        // Choice Button Panel
        choice_buttons = new JPanel();
        choice_buttons.setPreferredSize(new Dimension(600, 75));
        choice_buttons.setBackground(Color.darkGray);
        choice_buttons.setLayout(new BoxLayout(choice_buttons, BoxLayout.LINE_AXIS)); 
        choice_buttons.setVisible(true);
        window.add(choice_buttons, BorderLayout.SOUTH);  

            // Attack Button

            // Move Button

            // Change Direction Button

            // Final Layout

    }
}
