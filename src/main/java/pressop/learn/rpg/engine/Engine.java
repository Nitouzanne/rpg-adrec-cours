package pressop.learn.rpg.engine;

import pressop.learn.rpg.entities.Guerrier;
import pressop.learn.rpg.entities.Mage;
import pressop.learn.rpg.entities.Personnage;
import pressop.learn.rpg.entities.Soigneur;

import java.util.ArrayList;
import java.util.Scanner;

public class Engine {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Combien de joueurs : ");
        int nbJoueurs = scan.nextInt();
        scan.nextLine();

        ArrayList<Personnage> joueurs = new ArrayList<Personnage>();

        for (int i = 0; i < nbJoueurs; i++) {
            System.out.print("Nom du joueur " + (i+1) + " : ");
            String name = scan.nextLine();

            System.out.println("Les classes disponnible sont :");
            System.out.println(" 1 - Guerrier");
            System.out.println(" 2 - Mage");
            System.out.println(" 3 - Soigneur");

            System.out.print("Votre choix : ");
            int choix = scan.nextInt();
            scan.nextLine();

            if (choix == 1) {
                joueurs.add(new Guerrier(name));
            } else if (choix == 2) {
                joueurs.add(new Mage(name));
            } else if (choix == 3) {
                joueurs.add(new Soigneur(name));
            }
        }

        do {
            Combat combat = new Combat(joueurs);
            combat.combattre();

            System.out.println("Lancer un nouveau combat ? (Oui = 1, Non = 0");
            int continuer = scan.nextInt();

            if (continuer != 1) {
                break;
            }
        } while(true);
    }
}
