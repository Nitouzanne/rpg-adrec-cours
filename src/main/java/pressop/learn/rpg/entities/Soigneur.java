package pressop.learn.rpg.entities;

public class Soigneur extends Personnage {
    public Soigneur(String name) {
        super(name, 50, 5);
    }

    public void soigner(Personnage cible) {
        cible.pv += 30;
        // cible.pv = cible.pv + 30;
    }
}
