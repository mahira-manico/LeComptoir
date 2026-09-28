//under class of interface DiscountStrategy
public class FidelityDiscount implements DiscountStrategy {

    //use methods of interface DiscountStrategy
    @Override
    public String getName() {
        return "Remise de 5€(10€ max)";
    }

    @Override
    public double getDiscount(Cart cart, Fidelity fidelity) {
        if(fidelity==null||fidelity.getPoints()<100){ //security check
            return 0.0;
        }

        int discountFidelity= fidelity.getPoints()/100;
        int acceptedFidelity= (int) (cart.subTotal()/5.0);
        int wonDiscounts= Math.min(discountFidelity,acceptedFidelity);
        return wonDiscounts*5.0;
        }
    }
