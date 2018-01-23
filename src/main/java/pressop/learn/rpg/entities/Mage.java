package pressop.learn.rpg.entities;

public class Mage extends Personnage {
    public Mage(String name) {
        super(name, 100, 20);
    }

    public void seSoigner() {
        this.pv += 5;
    }
}
