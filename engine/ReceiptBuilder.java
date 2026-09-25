
//Interface to handle receipt display, use Builder pattern
public interface ReceiptBuilder {

    //methods initializing
    void reset();
    void buildHeader();
    void buildProductLine(CartLine line);
    void buildDiscountLine(DiscountStrategy discountStrategy, double amount,Cart cart, Fidelity fidelity);
    void buildTotalHT(double totalHT);
    void buildVAT(double vat);
    void buildTotalTTC(double totalTTC);
    void buildFidelity(int oldPoint, int usedPoints, int earnedPoints, int finalPoints);
    String getResult();



}
