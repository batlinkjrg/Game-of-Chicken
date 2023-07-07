package Chicken_Types;

import javax.swing.Icon;

public abstract class Chicken implements IChicken {
    private String name;
    private char symbol;
    private int max_hp;
    private int current_hp;
    public int x_coord;
    public int y_coord;
    private int max_rows;
    private int max_columns;
    private int damage;
    private int direction;
    private Icon currentIcon, northIcon, westIcon, southIcon, eastIcon;

    // Main chicken used for game
    public Chicken(String name, int hp, int x_coord, int y_coord, int max_rows, int max_columns, int damage, int direction, Icon icon) {
        this.name = name;
        //this.symbol = this.name.charAt(0);                        
        this.current_hp = hp;
        this.x_coord = x_coord;
        this.y_coord = y_coord;
        this.max_rows = max_rows;
        this.max_columns = max_columns;
        this.damage = damage;
        this.direction = direction;
        this.max_hp = hp;
        this.currentIcon = icon;
        this.northIcon = icon;
        this.westIcon = icon;
        this.southIcon = icon;
        this.eastIcon = icon;
    }

    // This is defult chicken (used if not wanting to enter values)
    public Chicken() {
        this.name = "Yoki";
        this.symbol = this.name.charAt(0);                        
        this.current_hp = 30;
        this.x_coord = 0;
        this.y_coord = 0;
        this.max_rows = 9;
        this.max_columns = 9;
        this.damage = 25;
        this.direction = 2;
    }

    // This is to make sure a given input is within a certain range
    public int set_vars(int min, int max, int variable) {
		if(variable < min) {
			variable = min;
		}else if(variable > max) {
			variable = max;
		}
		return variable;
    }

    // This will return a string according to which direction the chicken is facing
    public String facing(){
        switch (this.direction) {
            case 1:
               return "North";
            case 2:
               return "East";
            case 3:
               return "South";
            case 4:
                return "West";
            default:
                return "Error";
        }   
    }

    // This will tell the chicken which way it is moving according to its current direction
    public int[] new_movement() {
        int[] movement = new int[2];
        switch(this.direction) {
            case 1:
                movement = move_north();
                break;
            case 2:
                movement = move_east();
                break;
            case 3:
                movement = move_south();
                break;
            case 4:
                movement = move_west();
                break;
        }
        return movement;
    }

    // This will move the chicken in different directions
    private int[] move_north() {  // Moves one coordinate upwards
        int y = set_vars(1, this.max_rows, this.y_coord - 1);
        int[] new_location = {y, this.x_coord};
        return new_location;
    }

    private int[] move_south() { // Move one coordinate downwards
        int y = set_vars(1, this.max_rows, this.y_coord + 1);
        int[] new_location = {y, this.x_coord};
        return new_location;
    }

    private int[] move_east() {  // Moves one coordinate right
        int x = set_vars(1, this.max_columns, this.x_coord + 1);
        int[] new_location = {this.y_coord, x};
        return new_location;
    }

    private int[] move_west() {  // Move one coordinate left
        int x = set_vars(1, this.max_columns, this.x_coord - 1);
        int[] new_location = {this.y_coord, x};
        return new_location;
    }


    // These are chicken functions
    @Override // Used to get the chickens name
    public String get_name() {
        return this.name;
    }

    @Override // Used to get the symbol of the chicken which will be its first letter in its name
    public char get_symbol() {
        return this.symbol;
    }

    @Override // Used to get the current hp of the chicken
    public int get_hp() {
        return this.current_hp;
    }

    @Override // Used to verify that the chicken is alive
    public boolean is_alive() {
        return this.current_hp > 0;
    }

    @Override // This will assign the damage to the chicken
    public void hit(int damage) {
        int new_hp = this.current_hp - damage;
        this.current_hp = set_vars(0, this.max_hp, new_hp);
    }

    @Override // Used to get current position of chicken on game board
    public int[] get_location() {
        int[] location = {this.y_coord, this.x_coord};
        return location;
    }

    @Override // Used to check what direction the chicken is facing
    public String get_direction() {
        return facing();
    }

    @Override // Used to move the chicken in the dirction it is currently facing
    public void move() { 
        int[] new_position = new_movement();
        this.y_coord = new_position[0];
        this.x_coord = new_position[1];
    }

    @Override // This is to change the chickens direction that it is currently facing
    public void change_direction(int direction) {
        // This sets direction of chicken
        this.direction = this.set_vars(1, 4, direction);
        }

    @Override // The chicken will attempt to attack
    public int attack(int[] enemy_location) {
        int damage;
        int [] impact_zone = new_movement();
        int impact_x = impact_zone[1], impact_y = impact_zone[0];
        int target_x = enemy_location[1], target_y = enemy_location[0];
        if (impact_x == target_x && impact_y == target_y) {
            System.out.println(this.name + " got a hit and did " + this.damage + " damage");
            damage = this.damage;
        } else {
            System.out.println(this.name + " has missed");
            damage = 0;
        }
        return damage;
    }

    // Temporary for tests
    protected void set_hp(int hp) {
        this.current_hp = hp;
    }

    // set direction icons
    public void setIcons(Icon current, Icon iconEast, Icon iconNorth, Icon iconWest, Icon iconSouth) {
        this.currentIcon = current;
        this.eastIcon = iconEast;
        this.northIcon = iconNorth;
        this.westIcon = iconWest;
        this.southIcon = iconSouth;
    }

    // Get Chicken Icon
    public Icon getIcon() {
        return this.currentIcon;
    }

    // Get chicken type
    public String getChickenType() {
        return "Chicken";
    }

    // Set chicken icon
    public void setIcon(int choice) {
        switch (choice) {
            case 1:
                this.currentIcon = this.northIcon;
                break;
            case 2:
                this.currentIcon = this.eastIcon;
                break;
            case 3:
                this.currentIcon = this.southIcon;   
                break;
            case 4:
                this.currentIcon = this.westIcon;
                break;
            case 5: 
                this.currentIcon = null;
                break;
            default:
                System.out.println("Not an option");
        }
    }

    // Special Move
    public void specialMove(Chicken computerPlayer) {
        this.set_hp(current_hp + 100);
    }
}
