//Class for checkout with the full cart
public class Checkout {

    //calcul method (add of v2 with discount of 10%)
    public double calculateTotal(Cart cart){
       double pastTotal= cart.subTotal();
       double discount=0.0;

       if (pastTotal>50.0){
           discount=pastTotal*0.10;
       }
       double total=pastTotal-discount;
       return total;
    }

    public void receipt(Cart cart){
        System.out.println("--Receipt--");
        for(CartLine cartLine:cart.getCartLines()){
            System.out.println(
                    cartLine.quantity()+" x "+cartLine.product().label()+"("+cartLine.product().price()+"$)"+" Total price :"+cartLine.total()+"$"
            );}

        System.out.println("------------------");
        System.out.println("TOTAL:"+calculateTotal(cart)+"$");
        System.out.println("------------------");
    }
}
