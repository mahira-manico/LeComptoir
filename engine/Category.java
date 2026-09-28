//enum for categories
public enum Category {
    DRINKS(0.20), //Value of vat by category
    FOOD(0.055),
    OTHERS(0.20);

    private final double vat;

    Category(double vat) {  //Constructor
        this.vat=vat;
    }

    public double getVat() {
        return vat;
    }
}
