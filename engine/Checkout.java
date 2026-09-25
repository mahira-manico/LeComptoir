import java.util.List;

//Class for checkout with the full cart
public class Checkout {

    private final List<DiscountStrategy> strategies;

    public Checkout(List<DiscountStrategy> strategies) {
        this.strategies = strategies;
    }

    //method to decide which discount is the best
    public DiscountStrategy getBestDiscount(Cart cart, Fidelity fidelity){
        DiscountStrategy bestDiscount=null;
        double max=0.0;

        for (DiscountStrategy strategy : strategies) {
            double amount=strategy.getDiscount(cart,fidelity);
            if(amount>max){
                max=amount;
                bestDiscount=strategy;
            }
        }
        return bestDiscount;
    }

    public double getVAT(Cart cart, Fidelity fidelity){
        DiscountStrategy bestDiscount=getBestDiscount(cart, fidelity);
        double amount=(bestDiscount!=null)?bestDiscount.getDiscount(cart,fidelity) : 0.0;
        double total=cart.subTotal();
        double totalHT=Math.max(0.0,total-amount);
        double discountFactor=(total>0.0)?(totalHT/total) :1.0;

        double vat055=0.0;
        double vat20=0.0;

        for(CartLine lines:cart.getCartLines()){
            double priceRawLines=lines.total();
            double lineNet=priceRawLines*discountFactor;
            double lineVAT=lineNet*lines.product().category().getVat();
            if(lines.product().category().getVat()==0.055){
                vat055+=lineVAT;
            }else {
                vat20+=lineVAT;
            }
        }
        return  vat055+vat20;
    }
}






