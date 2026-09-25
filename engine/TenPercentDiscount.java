public class TenPercentDiscount implements DiscountStrategy{

    @Override
    public String getName() {
        return "Remise de 10%";
    }

    @Override
    public double getDiscount(Cart cart, Fidelity fidelity) {
        if(cart.subTotal()>50.0){
            return cart.subTotal()*0.10;
        }
        return 0.0;
    }
}
