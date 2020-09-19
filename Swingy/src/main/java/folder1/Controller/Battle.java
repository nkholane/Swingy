package folder1.Controller;

import folder1.Model.Globals;
import folder1.Model.Hero;
import folder1.Model.Monster;

import java.util.Random;
import java.util.Scanner;

public class Battle{
    
    public void fight (Hero hero, Monster monster) {
        System.out.println(hero.toString());
        System.out.println(monster.toString());

        while(hero.getHitPoints() > 0 && monster.getHitPoints() > 0) {
            if(hero.getAttack() > monster.getDefense())
               monster.setHitPoints(monster.getHitPoints() - hero.getAttack());
            else
                monster.setHitPoints(monster.getHitPoints() - hero.getAttack() / 2);
            System.out.println(monster.toString());
            if(monster.getHitPoints() <= 0)
            {
                break;
            }
            if(monster.getAttack() > hero.getDefense()) {
                hero.setHitPoints(hero.getHitPoints() - monster.getAttack());
                Globals.currentHitPoints = Globals.currentHitPoints - monster.getAttack();
            }
            else {
                hero.setHitPoints(hero.getHitPoints() - monster.getAttack() / 2);
                Globals.currentHitPoints = Globals.currentHitPoints - monster.getAttack() / 2;
            }
            System.out.println(hero.toString());
        }
        if(hero.getHitPoints() <= 0)
        {
            System.out.println("You lose \n");
            System.exit(0);
        }
        else {
            System.out.println("You win \n");
            experience(hero);
            dropArtifact(hero);
        }
    }

    public void dropArtifact (Hero hero){
        Scanner myScanner = new Scanner(System.in);
        int number;
        int number1;
        int randIncrease;
        Random num = new Random();
        number = num.nextInt(3);
        number1 = num.nextInt(3);
        randIncrease = num.nextInt(10) + 1;

        if(number == 1) {
            if(number1 == 0) {
                System.out.println("Armor received");

                System.out.println("Do you want to keep the Armor (Armor value is " + randIncrease + ")" + ": Yes or No? ");
                String armor = myScanner.next();
                if(armor.equals("Yes")) {
                    hero.setDefense(Globals.originalDefense + randIncrease);
                    hero.setArmor(randIncrease);
                    System.out.println("defence increased by " + randIncrease);
                }
            }
            if(number1 == 1) {
                System.out.println("Helm received");

                System.out.println("Do you want to keep the Helm (Helm value is " + randIncrease + ")" + ": Yes or No?");
                String helm = myScanner.next();
                if(helm.equals("Yes")) {
                    hero.setHitPoints(Globals.currentHitPoints + randIncrease);
                    hero.setHelm(randIncrease);
                    System.out.println("hp increased by " + randIncrease);
                }

            }
            if(number1 == 2) {
                System.out.println("Weapon received");

                System.out.println("Do you want to keep the Weapon (Weapon value is " + randIncrease + ")" + ": Yes or No?");
                String weapon = myScanner.next();
                if(weapon.equals("Yes")) {
                    hero.setAttack(Globals.originalAttack + randIncrease);
                    hero.setWeapon(randIncrease);
                    System.out.println("attack increased by " + randIncrease);
                }
            }
        }

    }

    public void experience(Hero hero) {
        int xp;
        int levelForm;
        int stats;
        levelForm = hero.getLevel() * 1000 + (hero.getLevel() - 1) * (hero.getLevel() - 1) * 450;
        Random num = new Random();
        stats = num.nextInt(15) + 1;
        xp = num.nextInt(100) + 1;

        System.out.println("Experience gained is " + xp + "\n");
        hero.setXp(hero.getXp() + xp);

        if(hero.getXp() >= levelForm){
            hero.setLevel(hero.getLevel() + 1);
            hero.setHitPoints(hero.getHitPoints() + stats);
            hero.setDefense(hero.getDefense() + stats);
            hero.setAttack(hero.getAttack() + stats);
            System.out.println("Hero reached level  " + hero.getLevel());
        }

    }

}