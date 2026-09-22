import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {

        //test script and instanciation
        Product Coca = new Product("fff", "Coca", 1.50, Category.DRINKS);
        CartLine line = new CartLine(Coca, 1);
        Product Bread =new Product("ggg","Bread",2.10,Category.FOOD);
        CartLine line2=new CartLine(Bread, 5);
        List<CartLine>cart=new ArrayList<>();
        cart.add(line);
        cart.add(line2);
        Cart totalCart=new Cart(cart);
        Checkout checkout=new Checkout();
        Fidelity fidelityPoints=new Fidelity(0);

        //display the receipt
        checkout.receipt(totalCart, fidelityPoints);

        //check add of fidelity points
        Product pepsi = new Product("jjj", "Pepsi", 3.50, Category.DRINKS);
        CartLine line3 = new CartLine(pepsi, 3);
        Product noodles=new Product("pop","Noodles",5.10,Category.FOOD);
        CartLine line4 =new CartLine(noodles, 5);
        cart.add(line3);
        cart.add(line4);
        Cart totalCart2=new Cart(cart);
        Checkout checkout2=new Checkout();
        checkout2.receipt(totalCart2,fidelityPoints);



    }
}
