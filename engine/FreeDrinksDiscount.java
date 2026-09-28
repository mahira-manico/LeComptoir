import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//under class of interface DiscountStrategy
public class FreeDrinksDiscount implements DiscountStrategy {
    @Override
    public String getName() {
        return "Boissons offertes";
    }

    @Override
    public double getDiscount(Cart cart, Fidelity fidelity) {
        //initialize a list to contains the price of each drinks
        List<Double> drinkPrices = new ArrayList<>();

        for (CartLine cartLine: cart.cartLines()) { //Loop on lines in cartLines
            if (cartLine.product().category() == Category.DRINKS) {  //Filter by category DRINK
                for (int i = 0; i < cartLine.quantity(); i++) { //Loop on each quantity of a product
                    drinkPrices.add(cartLine.product().price()); //take each prices
                }
            }
        }
        int drinksByThree = drinkPrices.size() / 3; //max of 3 drinks
        if (drinksByThree == 0) { //if no more than 3 return 0
            return 0.0;
        }
        Collections.sort(drinkPrices); //Sort from the lowest price to the max
        double totalDiscount = 0.0;
        for (int i = 0; i < drinksByThree; i++) { //Loop to get each drinks by three
            totalDiscount += drinkPrices.get(i);
        }
        return totalDiscount;
    }
}
