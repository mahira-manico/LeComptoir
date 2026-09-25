import java.util.List;

//Class for checkout, handle all calculs
public class Checkout {

    private final List<DiscountStrategy> strategies; //take the list of discount strategies

    public Checkout() {
        this.strategies = List.of(
                new TenPercentDiscount(), //Instanciation of each under class of interfaces DiscountStrategy
                new FreeDrinksDiscount(),
                new FidelityDiscount()
        );
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
        return bestDiscount; //return body
    }

    public double totalHT(Cart cart, Fidelity fidelity){ //get the total ht, price after discounts
        DiscountStrategy bestDiscount=getBestDiscount(cart, fidelity);
        double amount=(bestDiscount!=null)?bestDiscount.getDiscount(cart,fidelity) : 0.0;
        return Math.max(0.0,cart.subTotal()-amount);
    }

    public double totalTTC(Cart cart, Fidelity fidelity){ //get the ttc price, use price ht and vat total
        return totalHT(cart,fidelity)+getVAT(cart,fidelity);
    }

    public double getVAT(Cart cart, Fidelity fidelity){ //get the vat
        double ht=totalHT(cart, fidelity);
        double totalRaw=cart.subTotal();
        double discountFactor=(totalRaw>0.0)?(ht/totalRaw) :1.0; //check if the full price is not negative, if not it does a division

        double vat055=0.0;
        double vat20=0.0;

        for(CartLine lines:cart.cartLines()){
            double lineNet=lines.total()*discountFactor;
            double lineVAT=lineNet*lines.product().category().getVat();
            if(lines.product().category().getVat()==0.055){
                vat055+=lineVAT;
            }else {
                vat20+=lineVAT;
            }
        }
        return  vat055+vat20;
    }

    public void updateCard(Cart cart,Fidelity fidelity){ //update fidelity class after each checkout
      DiscountStrategy bestDiscount=getBestDiscount(cart,fidelity);
      double discountAmount=(bestDiscount!=null)?bestDiscount.getDiscount(cart,fidelity) : 0.0; //check if there is a discount
      double totalTTC=totalTTC(cart,fidelity);

      if(fidelity!=null){
          if(bestDiscount instanceof FidelityDiscount&&discountAmount>0.0){
              int usedPoints= (int) (discountAmount/5.0);
              int pointsToDeducts=usedPoints*100;
              fidelity.usePoints(pointsToDeducts);
          }
          int wonPoints= (int) totalTTC;
          fidelity.addPoints(wonPoints);
      }
    }
}






