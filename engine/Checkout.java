//Class for checkout with the full cart
public class Checkout {

    //calcul method (add of v2 with discount of 10% and free drink discount)
    public double calculateTotal(Cart cart){
       double pastTotal= cart.subTotal();
       double discount=0.0;
       double drinkDiscount=calculateFreeDrink(cart);

       if (pastTotal>50.0){
           discount=pastTotal*0.10;
       }

       double total=pastTotal-discount-drinkDiscount;
       return total;
    }

    //add of free drink method
    public double calculateFreeDrink(Cart cart) {
        int totalDrink = 0; //counter of drink
        for (CartLine cartLine : cart.getCartLines()) { //loop of cart lines
            if (cartLine.product().category() == Category.DRINKS) { //check for drink category of each product
                totalDrink += cartLine.quantity(); //add to counter
            }
        }
        if (totalDrink >= 3) {
            double minPrice = Double.MAX_VALUE; //take max value to compare
            for (CartLine cartLine : cart.getCartLines()) {
                if (cartLine.product().category() == Category.DRINKS) {
                    if (cartLine.product().price() < minPrice) { //compare price to max value for each loop
                        minPrice = cartLine.product().price(); //change value of minPrice to price of the product if the price is lower than minPrice
                    }
                }
            }
            return minPrice; //return the lowest price
        }
        return 0.0;
    }

    public void receipt(Cart cart){
        System.out.println("--Receipt--");
        for(CartLine cartLine:cart.getCartLines()){
            System.out.println(
                    cartLine.quantity()+" x "+cartLine.product().label()+"("+cartLine.product().price()+"$)"+" Total price :"+cartLine.total()+"$"
            );}

        System.out.println("------------------");
        double freeDrink=calculateFreeDrink(cart);
        if(freeDrink>0){
            System.out.println("Congrats! you got : Discount Drink(the lowest for free!) -"+freeDrink+"$");
        }
        if(cart.subTotal()>50.0){
            System.out.println("Congrats! you got : Discount -10% -"+(cart.subTotal()*0.10)+"$");
        }
        System.out.println("TOTAL:"+calculateTotal(cart)+"$");
        System.out.println("------------------");
    }
}
