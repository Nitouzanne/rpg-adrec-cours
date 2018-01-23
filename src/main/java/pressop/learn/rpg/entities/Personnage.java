package pressop.learn.rpg.entities;

public class Personnage extends Combattant {
    private String name;

    public Personnage(String name, int pv, int degat) {
        super(pv, degat);

        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return name;
    }
}
