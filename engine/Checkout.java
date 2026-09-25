//Class for checkout with the full cart
public class Checkout {


    //method to decide which discount is the best
    public double getBestDiscount(Cart cart, int fidelityPoints){
        double discountFidelity=discountFidelity(cart, fidelityPoints);
        double discountTen=discountTen(cart);
        double discountFreeDrink=discountFreeDrink(cart);
        return Math.max(discountFidelity,Math.max(discountTen,discountFreeDrink));


    }

    //method to get the tva of food
    public double getTVAFood(Cart cart){
        double TVAFood=0.0;

        for(CartLine cartLine: cart.getCartLines()){
            double totalQT=cartLine.product().price()* cartLine.quantity();

            if(cartLine.product().category()==Category.FOOD){ //check category food only
                TVAFood+=totalQT*0.055; //tva at 5.5%
            }
        }
        return TVAFood;


    }

    //method to get the tva for drink and others
    public double getTVAOther(Cart cart){
        double TVAOther =0.0;

        for(CartLine cartLine: cart.getCartLines()){
            double totalQT=cartLine.product().price()* cartLine.quantity();

            if(cartLine.product().category()==Category.OTHERS || cartLine.product().category()==Category.DRINKS){ //check category others and drinks
                TVAOther +=totalQT*0.20; //tva at 20%
            }
        }
        return TVAOther;
    }

    //method to display receipt
    public void receipt(Cart cart, Fidelity fidelity){
        System.out.println("--Receipt--");

        for(CartLine cartLine:cart.getCartLines()){
            System.out.println(
                    cartLine.quantity()+" x "+cartLine.product().label()+"("+cartLine.product().price()+"$)"+" Total price :"+cartLine.total()+"$"
            );
        }

        System.out.println("------------------");

        double bestDiscount=getBestDiscount(cart, fidelity.getPoints());

        if (bestDiscount > 0.0) { //display best discount message depending on the best discount result
            if (bestDiscount == discountTen(cart)) {
                System.out.println("Congrats! you got -10% discount(for >50$) : -" + bestDiscount + "$");
            } else if (bestDiscount == discountFreeDrink(cart)) {
                System.out.println("Congrats! you got a free drink(for >=3 drink bought) : -" + bestDiscount + "$");
            } else if (bestDiscount == discountFidelity(cart, fidelity.getPoints())) {
                int pointsUsed= ((int) bestDiscount / 5) * 100;
                fidelity.spendPoints(pointsUsed);
                System.out.println("Congrats! your fidelity got you : -" + bestDiscount + "$");
            }
        } else {
            System.out.println("No discount this time :(");
        }

        //calcul of all total prices and tva
        double totalHT = cart.subTotal() - bestDiscount;
        double totalTVA = getTVAFood(cart)+getTVAOther(cart);
        double totalTTC = totalHT + totalTVA;
        int wonFidelity = (int) totalHT;
        fidelity.addPoints(wonFidelity);

        System.out.println("HT Price : "+totalHT+"$");
        System.out.println("TVA(5,5%) : "+getTVAFood(cart)+"$");
        System.out.println("TVA(20%) : "+getTVAOther(cart)+"$");
        System.out.println("TOTAL(TTC Price) : "+totalTTC+"$");
        System.out.println("Won fidelity points : "+wonFidelity+" points.");
        System.out.println("Total fidelity points : "+fidelity.getPoints()+" points.");
        System.out.println("------------------");
    }
}
