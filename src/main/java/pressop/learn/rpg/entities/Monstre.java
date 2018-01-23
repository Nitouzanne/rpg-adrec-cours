package pressop.learn.rpg.entities;

public class Monstre extends Combattant {
    public Monstre() {
        super(
                (int)(Math.random() * 250 + 50),
                (int)(Math.random() * 15 + 5)
        );
    }

    public void attaquer(Combattant cible) {
        super.attaquer(cible);

        if (Math.random() * 100 <= 10) {
            super.attaquer(cible);
        }
    }
}
