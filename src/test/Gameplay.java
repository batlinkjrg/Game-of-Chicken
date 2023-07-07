package test;

import java.util.Scanner;

import Chicken_Types.*;
import chkn.*;

public class Gameplay {
    private Board b1;
    private Chicken p1, p2;
    private Scanner scan;
    private boolean game_over;
    private int[] game_table;
    private int max_columns, max_rows, turn;
    private String[] cpu_names = {"Arit","Cyrus","Ivo","Marcus","Sebastian", "Tiberius","Otto","Orion","Nero","Icarus"};

    // Play game
    public Gameplay (Scanner scanner) {
        this.scan = scanner;
        initialize_game();
        play_Game();
    }

    // Print display the board
    private void print_Board(int[] player_location, int[] CPU_location) {
        System.out.println();
        b1.display_board();
        System.out.println();
    }

    // Take turns and run game
    private void play_Game() {
        while(!this.game_over) {     
            take_turn();
        }
    }

    // Create Game
    private void initialize_game() {
        turn = project_1.Utilities.calc_random(1, 5);
        this.max_columns = 9;
        this.max_rows = 9;

        System.out.println("Players ready...");
        initialize_chickens();
        initialize_board(p1.get_symbol(), p2.get_symbol());
        System.out.println();
        System.out.println("The Board -");
        print_Board(p1.get_location(), p2.get_location());
        game_over = false;
    }

    // Create the Playing Board
    private void initialize_board(char p1, char p2) {
        b1 = new Board(this.max_rows, this.max_columns);
        b1.mark_board(0, 0, p1);
        b1.mark_board(8, 8, p2);
    }

    // Prepare Player and Computer
    private void initialize_chickens() {
        initialize_HumanChicken();
        System.out.println("and now your opponent");
        initialize_CPUChicken();
    }

    // Prepare Player
    private void initialize_HumanChicken() {
        System.out.println("What will your name be?");
        String name = scan.nextLine();
        System.out.println("Welcome " + name);
        this.p1 = new defChicken(name, 100, 0, 0, max_rows-1, max_columns-1, 20, 3) {};
    }

    // Prepare Computer
    private void initialize_CPUChicken() {
        int rand_cpu = project_1.Utilities.calc_random(0, 9);
        String name = cpu_names[rand_cpu];
        System.out.println("Welceome " + name);
        this.p2 = new defChicken(name, 100, 8, 8, max_rows-1, max_columns-1, 20, 3) {};
       //  name, 100, 8, 8, max_rows-1, max_columns-1, 20, 1, null
    }

    // This is to cycle turns for computer and player
    private void take_turn() {
        if(this.turn % 2 == 0) {
            System.out.println();
            System.out.println("Player turn-");
            take_HumanTurn();
            check_win(p2.get_hp(), p2.get_name());
        } else {
            System.out.println();
            System.out.println("Computer turn-");
            take_CPUTurn();
            check_win(p1.get_hp(), p1.get_name());
        }
        this.turn ++;
        print_Board(p1.get_location(), p2.get_location());
        System.out.println(p1.get_name() + " has - " + p1.get_hp() + " hp left");
        System.out.println(p2.get_name() + " has - " + p2.get_hp() + " hp left");
    }

    // This is to take Player turns
    private void take_HumanTurn() {
        System.out.println("Your current direction is " + p1.get_direction());
        System.out.println("You have three options...");
        System.out.println("1 - Change your current direction");
        System.out.println("2 - Move foward Two");
        System.out.println("3 - Attempt an Attack");
        System.out.println("What will you choose?");
        int userChoice = project_1.Utilities.get_user_int(scan, 1, 3);
        int direction;
        switch (userChoice) {
            case 1:
                System.out.println("What direction would you like to face?");
                System.out.println("1 - North");
                System.out.println("2 - East");
                System.out.println("3 - South");
                System.out.println("4 - West");
                direction = project_1.Utilities.get_user_int(scan, 1, 4);
                p1.change_direction(direction);
                break;
            case 2:
                b1.mark_board(p1.y_coord, p1.x_coord, '-');
                p1.move();
                b1.mark_board(p1.y_coord, p1.x_coord, p1.get_symbol());
                break;
            case 3:
                p2.hit(p1.attack(p2.get_location()));
                break;
            default:
                System.out.println("Choose a valid option");
        }  
    }

    // This is to take Computer turns
    private void take_CPUTurn() {
        int userChoice = project_1.Utilities.calc_random(1, 3);
        int direction;
        switch (userChoice) {
            case 1:
                System.out.println("Computer decided to change direction to " + p2.get_direction());
                direction = project_1.Utilities.calc_random(1, 4);
                p2.change_direction(direction);
                break;
            case 2:
                System.out.println("Computer decided to move");
                b1.mark_board(p2.y_coord, p2.x_coord, '-');
                p2.move();
                b1.mark_board(p2.y_coord, p2.x_coord, p2.get_symbol());
                break;
            case 3:
                System.out.println("Computer dicided to attack");
                p1.hit(p2.attack(p1.get_location()));
                break;
        }  
    }

    // Check to see if there is as winner yet
    private void check_win(int enemy_hp, String name) {
        if (enemy_hp == 0) {
            System.out.println(name + "has lost!!");
            game_over = true;
        }
    }


}
