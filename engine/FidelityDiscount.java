public class FidelityDiscount implements DiscountStrategy {
    @Override
    public String getName() {
        return "Remise de 5€";
    }

    @Override
    public double getDiscount(Cart cart, Fidelity fidelity) {
        if(fidelity==null||fidelity.getPoints()<100){
            return 0.0;
        }

        int discountFidelity= fidelity.getPoints()/100;
        int acceptedFidelity= (int) (cart.subTotal()/5.0);
        return Math.min(discountFidelity,acceptedFidelity);
        }
    }
