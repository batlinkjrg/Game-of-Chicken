package Chicken_Types;

import java.util.Random;

public class offChicken extends Chicken {
    private int max_hp;
    private int damage;

    // Method to Initiate Chicken
    public offChicken (String name, int hp, int x_coord, int y_coord, int max_rows, int max_columns, int damage, int direction) {
        super(name, hp, x_coord, y_coord, max_rows, max_columns, damage, direction, null);
        this.max_hp = hp;
        this.damage = damage;
    }

    // Defualt Chicken
    public offChicken() {
        super();
    }

    // This is to decide how much increase of attack the Chicken will get according to their health
    protected double increaseOfAttack (int current_hp) {
        double hp_percentage = current_hp/this.max_hp;
        double damageMultiplier = 1;
        // This will decide the attack increase of a critical hit based off remaining hp
        if (hp_percentage > 0.95) {
            damageMultiplier = 1.1;
        } else if (hp_percentage <= 0.95 && hp_percentage > 0.8) {
            damageMultiplier = 1.4;
        } else if (hp_percentage <= 0.8 && hp_percentage > 0.6) {
            damageMultiplier = 1.6;
        } else if (hp_percentage <= 0.6 && hp_percentage > 0.2) {
            damageMultiplier = 2;
        } else if (hp_percentage <= 0.2 && hp_percentage > 0) {
            damageMultiplier = 2.2;
        }  
        return damageMultiplier;      
    }

    // Uses remaining hp to determine chance of attack increase
    protected double chanceOfAttack (int current_hp) {
        double hp_percentage = current_hp/this.max_hp;
        double damageMultiplierChance;
        // This will dediced chance based of remaining hp
        if (hp_percentage > 0.95) {
            damageMultiplierChance = 0.2;
        } else if (hp_percentage <= 0.95 && hp_percentage > 0.8) {
            damageMultiplierChance = 0.4;
        } else if (hp_percentage <= 0.8 && hp_percentage > 0.6) {
            damageMultiplierChance = 0.8;
        } else if (hp_percentage <= 0.6 && hp_percentage > 0.2) {
            damageMultiplierChance = 0.15;
        } else if (hp_percentage <= 0.2 && hp_percentage > 0) {
            damageMultiplierChance = 0.25;
        } else {
            damageMultiplierChance = 0.5;
        }
        return damageMultiplierChance;
    }

    // This chicken will attempt to attack
    @Override
    public int attack(int[] enemy_location) {
        int current_hp = super.get_hp();
        double chanceOfAtt = chanceOfAttack(current_hp);
        double attStrenth = increaseOfAttack(current_hp);
        int damage = this.damage;
        int [] impact_zone = new_movement();
        Random rand = new Random();
        int impact_x = impact_zone[1], impact_y = impact_zone[0];
        int target_x = enemy_location[1], target_y = enemy_location[0];

        // This is to find out whether or not an enemy is present
        if (impact_x == target_x && impact_y == target_y) {
            // This is to decide whether or not the attack will be increased
            if (chanceOfAtt <= rand.nextDouble()){
                System.out.println(super.get_name() + " got a critical hit and did " + this.damage + " damage");
                damage = (int) (damage*attStrenth);
            } else {
            System.out.println(super.get_name() + " got a hit and did " + this.damage + " damage");
            }
        } else {
            System.out.println(super.get_name() + " has missed");
            damage = 0;
        }
        return damage;
    }

        // Get chicken type
        @Override
        public String getChickenType() {
            return "OffChicken";
        }
}
