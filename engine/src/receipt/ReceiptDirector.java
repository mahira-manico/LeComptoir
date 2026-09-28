package src.receipt;
import src.Checkout;
import src.discount.DiscountStrategy;
import src.discount.FidelityDiscount;
import src.model.Cart;
import src.model.CartLine;
import src.model.Fidelity;


//Director of Receipt, Build src.discount.receipt steps by steps using the builder class
public class ReceiptDirector {

    private final ReceiptBuilder builder; //get the builder

    public ReceiptDirector(ReceiptBuilder builder) {
        this.builder = builder;
    }

    //method that build the full src.discount.receipt using methods calls
    public void makeReceipt(Cart cart, Fidelity fidelity, Checkout checkout){
        builder.reset();
        builder.buildHeader();

        for (CartLine lines: cart.cartLines()){
            builder.buildProductLine(lines);
        }

        DiscountStrategy discountStrategy=checkout.getBestDiscount(cart,fidelity);
        double amount=(discountStrategy!=null)?discountStrategy.getDiscount(cart,fidelity) : 0.0;
        builder.buildDiscountLine(discountStrategy,amount, cart, fidelity);

        double priceHT=checkout.totalHT(cart,fidelity);
        builder.buildTotalHT(priceHT);

        double vat= checkout.getVAT(cart,fidelity);
        builder.buildVAT(vat);

        double totalTTC=checkout.totalTTC(cart,fidelity);
        builder.buildTotalTTC(totalTTC);

        if(fidelity!=null){
            int pointsBefore= fidelity.getPoints();
            int usedPoints=0;
            if(discountStrategy instanceof FidelityDiscount &&amount>0.0){
                usedPoints= (int) ((amount/5.0)*100);
            }
            int wonPoints= (int) totalTTC;
            int newPoints=pointsBefore-usedPoints+wonPoints;
            builder.buildFidelity(pointsBefore,usedPoints,wonPoints,newPoints);
        }
        builder.getResult();
    }
}
