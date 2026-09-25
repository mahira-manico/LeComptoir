//Builder of interface ReceiptBuilder
public class TextReceiptBuilder implements ReceiptBuilder{

    private StringBuilder sb; //get java native class StringBuilder

    public TextReceiptBuilder() {
    }

    @Override
    public void reset() {
        this.sb=new StringBuilder();

    }

    //build header of receipt
    @Override
    public void buildHeader() {
        sb.append("\n==========TICKET==========\n");

    }

    //Build the full list of products
    @Override
    public void buildProductLine(CartLine line) {
        sb.append(String.format("%s x%d : (%.2f€) %.2f €\n",
                line.product().label(),
                line.quantity(),
                line.product().price(),
                line.total()));
    }

    //build the discount text calling the display method of DiscountStrategy interface
    @Override
    public void buildDiscountLine(DiscountStrategy discountStrategy, double amount, Cart cart, Fidelity fidelity) {
        sb.append("==========REMISE==========\n");

        if(discountStrategy!=null&&amount>0.0){
            sb.append(discountStrategy.displayDiscount(cart,fidelity));
        }else {
            sb.append("Aucune remise applicable.\n");
        }
    }

    //Build the line of price ht
    @Override
    public void buildTotalHT(double totalHT) {
        sb.append("\n==========PRIX HT=========\n");
        sb.append(String.format("%.2f €\n",totalHT));
    }

    //build the line of vat
    @Override
    public void buildVAT(double vat) {
        sb.append("==========TVA=============\n");
        sb.append(String.format("%.2f €",vat));
    }

    //build total ttc line
    @Override
    public void buildTotalTTC(double totalTTC) {
        sb.append("\n==========PRIX TTC========\n");
        sb.append(String.format("%.2f €\n",totalTTC));
        sb.append("--------------------------\n");
    }

    //build the fidelity text part
    @Override
    public void buildFidelity(int oldPoint, int usedPoints, int earnedPoints, int finalPoints) {
        sb.append("====CARTE DE FIDÉLITÉ=====\n");
        sb.append("Points de fidélité :\n");
        sb.append(String.format("Points initiaux : %dpts\n",oldPoint));
        if(usedPoints>0) {
            sb.append(String.format("Points utilisés : %dpts\n", usedPoints));
        }
        sb.append(String.format("Points acquis : %dpts\n",earnedPoints));
        sb.append(String.format("Solde actuel : %dpts\n",finalPoints));
        sb.append("--------------------------");
    }

    //return the full result in string format
    @Override
    public String getResult() {
        return sb.toString();
    }
}
