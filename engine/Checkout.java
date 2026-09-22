//Class for checkout with the full cart
public class Checkout {

    //calcul method
    public double calculateTotal(Cart cart){
        return cart.subTotal();
    }

    public void receipt(Cart cart){
        System.out.println("--Receipt--");
        for(CartLine cartLine:cart.getCartLines()){
            System.out.println(
                    cartLine.quantity()+" x "+cartLine.product().label()+"("+cartLine.product().price()+"$)"+" Total price :"+cartLine.total()+"$"
            );}

        System.out.println("------------------");
        System.out.println("TOTAL:"+cart.subTotal()+"$");
        System.out.println("------------------");
    }
}
