package pressop.learn.rpg.engine;

import pressop.learn.rpg.entities.Monstre;
import pressop.learn.rpg.entities.Personnage;
import java.util.ArrayList;

public class Combat {
    private ArrayList<Personnage> joueurs;

    private Monstre monstre;

    public Combat(ArrayList<Personnage> joueurs) {
        this.joueurs = joueurs;
        this.monstre = new Monstre();
    }

    public void combattre() {
        int numeroDuJoueur = 0;

        while (this.monstre.getPv() > 0 && this.joueurs.size() > 0) {
            Personnage aQuiLeTour = this.joueurs.get(numeroDuJoueur);

            Tour tourCourant = new Tour(this.joueurs, this.monstre, aQuiLeTour);
            tourCourant.lancerLeTour();

            if (aQuiLeTour.getPv() <= 0) {
                this.joueurs.remove(aQuiLeTour);
            } else {
                numeroDuJoueur++;
            }

            if (numeroDuJoueur >= this.joueurs.size()) {
                numeroDuJoueur = 0;
            }
        }

        if (this.monstre.getPv() <= 0) {
            System.out.println("Le monstre est battu.");
        } else if (this.joueurs.size() == 0) {
            System.out.println("Le monstre a gagné.");
        }

        for (int i = 0; i < this.joueurs.size(); i++) {
            Personnage joueur = this.joueurs.get(i);
            System.out.printf(" %s - %s (%d PVs)\n", i + 1, joueur, joueur.getPv());
        }
    }
}
