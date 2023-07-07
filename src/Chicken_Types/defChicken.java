package Chicken_Types;

import java.util.Random;

import javax.swing.Icon;

public class defChicken extends Chicken {  
    private int max_hp;

    // Method to Initiate Chicken
    public defChicken (String name, int hp, int x_coord, int y_coord, int max_rows, int max_columns, int damage, int direction) {
        super(name, hp, x_coord, y_coord, max_rows, max_columns, damage, direction, null);
        this.max_hp = hp;
    }

    public defChicken() {
        super();
    }

    public defChicken(String name, int i, int j, int k, int l, int m, int n, int o, Object object) {
    }

    // This is to decide how much increase of attack the Chicken will get according to their health
    private double increaseOfDef (int current_hp) {
        double hp_percentage = current_hp/this.max_hp;
        double damageDivider = 1;
        // This will decide the attack increase of a critical hit based off remaining hp
        if (hp_percentage > 0.95) {
            damageDivider = 0.1;
        } else if (hp_percentage <= 0.95 && hp_percentage > 0.8) {
            damageDivider = 0.2;
        } else if (hp_percentage <= 0.8 && hp_percentage > 0.6) {
            damageDivider = 0.4;
        } else if (hp_percentage <= 0.6 && hp_percentage > 0.2) {
            damageDivider = 0.6;
        } else if (hp_percentage <= 0.2 && hp_percentage > 0) {
            damageDivider = 0.9;
        }  
        return damageDivider;      
    }
    
    // Uses remaining hp to determine chance of defense increase
    private double chanceOfDefense (int current_hp) {
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

    // This chicken got hit and will take damage
    @Override
    public void hit(int damage) {
        int current_hp = super.get_hp();
        double chanceOfDef = chanceOfDefense(current_hp);
        double defStrenth = increaseOfDef(current_hp);
        Random ran = new Random();
        double success = ran.nextDouble();
        int damage_done = damage;
        if(chanceOfDef <= success) {
            damage_done = (int) (damage - (damage*defStrenth));
        }
        super.hit(damage_done);
    }

    // Get chicken type
    @Override
    public String getChickenType() {
        return "DefChicken";
    }
}
