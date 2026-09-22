import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {

        //test script and instanciation
        Product coca = new Product("fff", "Coca", 20, Category.DRINKS);
        CartLine line = new CartLine(coca, 8);
        Product pain=new Product("ggg","pain",5.2,Category.FOOD);
        CartLine line2=new CartLine(pain, 4);
        List<CartLine>cart=new ArrayList<>();
        cart.add(line);
        cart.add(line2);
        Cart totalCart=new Cart(cart);
        Checkout checkout=new Checkout();

        //display the receipt
        checkout.receipt(totalCart);



    }
}
