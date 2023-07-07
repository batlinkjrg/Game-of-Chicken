package test;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.junit.*;

import Chicken_Types.*;
import chkn.*;
import Game_Screen.*;
import User_Interface.*;

public class ChickenTest {
    Chicken_Types.Chicken c1 = new Chicken_Types.defChicken("Frank", 100, 0, 1, 5, 5, 20, 4) {};
    Chicken_Types.Chicken c2 = new Chicken_Types.offChicken("Freddy", 100, 1, 1, 5, 5, 20, 2) {};
    Chicken_Types.Chicken c3 = new Chicken_Types.Chicken() {};

   /*  @Test
    void chickenAttTest() {
        c2.attack(c1.get_location());
        System.out.println("Freddys HP = " + c2.get_hp());

        int c1_hp = c1.get_hp();
        AssertJUnit.assertTrue(c1_hp < 100);
    } 

    
    @Test
    int chickenDefTest_hitTest_1 () {
        int samples = 100;
        int damage_total;
        int average_damage;
        int damage_percentage;

        // This will collect several hit samples 
        for(int i = 0; i < samples; i++) {
            c2.set_hp(95);
            c2.hit(30);
            damage_total += c2.get_hp();
        }

        // This takes the samples and gets the average damage done
        average_damage = damage_total/samples;
        damage_percentage = 
        AssertJUnit.assertTrue(c2.get_hp() > 45);
    } */

    @Test
    void chickenDefTest_hitTest_2() {
    //    c1.set_hp(95);
     //   c1.hit(30);
        System.out.println("Hp is - " + c2.get_hp());
        AssertJUnit.assertTrue(c2.get_hp() > 0);
    }

}
