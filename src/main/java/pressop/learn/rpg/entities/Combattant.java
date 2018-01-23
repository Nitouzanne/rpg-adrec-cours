package pressop.learn.rpg.entities;

public class Combattant {
    protected int pv;

    private int degat;

    public Combattant(int pv, int degat) {
        this.pv = pv;
        this.degat = degat;
    }

    public int getPv() {
        return this.pv;
    }

    public int getDegat() {
        return this.degat;
    }

    public void attaquer(Combattant cible) {
        cible.pv = cible.pv - this.degat;
    }
}
