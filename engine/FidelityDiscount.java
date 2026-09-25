public class FidelityDiscount implements DiscountStrategy{
    @Override
    public String getName() {
        return "Remise de 5€";
    }

    @Override
    public double getDiscount(Cart cart, Fidelity fidelity) {
        //discount for fidelity points
            double discount=(fidelity.getPoints()/100)*5.0;
            if(discount>cart.subTotal()){
                discount=cart.subTotal();
            }
            return discount;
        }

    }
