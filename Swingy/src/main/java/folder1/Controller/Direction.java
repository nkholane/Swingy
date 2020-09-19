package folder1.Controller;

import folder1.Model.Globals;
import folder1.Model.Hero;

import java.util.Scanner;

public class Direction {

    public void dir(Hero hero){
        String input;
        System.out.println("Directions are Up = w , Down = s, Left = a, Right = d on keyboard");

        Scanner userInput = new Scanner(System.in);
        input = userInput.next();

        if (input.equals("w") ) {
            hero.setY(hero.getY() + 1);
            System.out.println("You moved NORTH \n");        }

         if(input.equals("s") ) {
             hero.setY(hero.getY() - 1);
             System.out.println("You moved SOUTH \n");
         }

         if (input.equals("a")) {
             hero.setX(hero.getX() - 1);
             System.out.println("You moved WEST \n");
         }

         if (input.equals("d") ) {
             hero.setX(hero.getX() + 1);
             System.out.println("You moved EAST \n");
         }

         if(hero.getX() == 0 || hero.getY() == 0 || hero.getY() == Globals.mapSize + 1 || hero.getX() == Globals.mapSize + 1){
             System.out.println("You have reached the border: Game completed");
             System.exit(0);
         }

    }
}