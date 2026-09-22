//class fidelity, represent object fidelity card

public class Fidelity {
    private int points; //cards points

    public Fidelity(int points) {
        this.points = points;
    }

    public int getPoints() {
        return this.points;
    }

    public void addPoints(int earned) {
        this.points += earned;
    }

    public void spendPoints(int spent) {
        this.points -= spent;
    }
}