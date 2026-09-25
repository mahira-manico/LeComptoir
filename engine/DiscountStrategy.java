//Interface for discounts
public interface DiscountStrategy {

    String getName();
    double getDiscount(Cart cart, Fidelity fidelity);

    default String displayDiscount(Cart cart, Fidelity fidelity){
        double amount=getDiscount(cart, fidelity);
        return getName()+ " -"+ String.format("%.2f", amount) +"€";
    }
}
