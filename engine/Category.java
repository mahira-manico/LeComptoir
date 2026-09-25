//enum for categories
public enum Category {
    DRINKS(0.20),
    FOOD(0.055),
    OTHERS(0.20);

    private final double vat;

    Category(double vat) {
        this.vat=vat;
    }

    public double getVat() {
        return vat;
    }
}
