//class fidelity, represent object fidelity card

public class Fidelity {
    private int points; //cards points

    public Fidelity(int points) {
        this.points = points;
    }

    //methods to manipulate the class
    public int getPoints() {
        return points;
    }

    public void addPoints(int points) {
        this.points+= points;
    }

    public void usePoints(int usedPoints){
        this.points-=usedPoints;
    }
}