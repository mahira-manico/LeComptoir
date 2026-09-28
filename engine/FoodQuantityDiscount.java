public class FoodQuantityDiscount implements DiscountStrategy {

    @Override
    public String getName() {
        return "Remise 20% FOOD";
    }

    @Override
    public double getDiscount(Cart cart, Fidelity fidelity) {
        double discount = 0.0;

        for (CartLine line : cart.cartLines()) {

            if (line.product().category() == Category.FOOD && line.quantity() >= 5) {
                discount += line.total() * 0.20;
            }
        }

        return discount;
    }
}