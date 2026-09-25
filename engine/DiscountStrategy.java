//Interface for discounts, use strategy pattern

public interface DiscountStrategy {

    //initialize empty methods
    String getName();
    double getDiscount(Cart cart, Fidelity fidelity);

    default String displayDiscount(Cart cart, Fidelity fidelity){
        double amount=getDiscount(cart, fidelity);
        return getName()+ " -"+ String.format("%.2f", amount) +"€";
    }
}
