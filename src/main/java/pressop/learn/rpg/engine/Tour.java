package pressop.learn.rpg.engine;

import pressop.learn.rpg.entities.Mage;
import pressop.learn.rpg.entities.Monstre;
import pressop.learn.rpg.entities.Personnage;
import pressop.learn.rpg.entities.Soigneur;

import java.util.ArrayList;
import java.util.Scanner;

public class Tour {
    private ArrayList<Personnage> joueurs;

    private Monstre monstre;

    private Personnage aQuiLeTour;

    public Tour(ArrayList<Personnage> joueurs, Monstre monstre, Personnage aQuiLeTour) {
        this.joueurs = joueurs;
        this.monstre = monstre;
        this.aQuiLeTour = aQuiLeTour;
    }

    public void lancerLeTour() {
        System.out.println("C'est à " + this.aQuiLeTour + " de jouer.");
        for (int i = 0; i < this.joueurs.size(); i++) {
            Personnage joueur = this.joueurs.get(i);
            System.out.printf(" %s - %s (%d PVs)\n", i + 1, joueur, joueur.getPv());
        }

        System.out.println("Reste " + this.monstre.getPv() + " au monstre.");

        // Phase Perso

        System.out.println("Actions possibles :");
        System.out.println(" 1 - Attaquer le monstre.");

        if (this.aQuiLeTour instanceof Mage) {
            System.out.println(" 2 - Se soigner.");
        } else if (this.aQuiLeTour instanceof Soigneur) {
            System.out.println(" 2 - Soigner un joueur.");
        }

        System.out.print("Votre choix : ");

        Scanner scanner = new Scanner(System.in);

        int action = scanner.nextInt();

        if (action == 1) {
            this.aQuiLeTour.attaquer(this.monstre);
        } else if (this.aQuiLeTour instanceof Mage && action == 2) {
            ((Mage) this.aQuiLeTour).seSoigner();
        } else if (this.aQuiLeTour instanceof Soigneur && action == 2) {
            System.out.println("Choisir un joueur :");

            for (int i = 0; i < this.joueurs.size(); i++) {
                System.out.printf(" %s - %s\n", i + 1, this.joueurs.get(i));
            }

            System.out.print("Votre choix : ");
            int subAction = scanner.nextInt();

            ((Soigneur) this.aQuiLeTour).soigner(this.joueurs.get(subAction - 1));
        }

        // Phase Monstre

        this.monstre.attaquer(this.aQuiLeTour);
    }
}
