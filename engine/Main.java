import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //Client test script
        Cart cart=new Cart();
        cart.addLine(new CartLine(new Product("DRINK-SODA1","COCA",3.50,Category.DRINKS),3));
        cart.addLine(new CartLine(new Product("DRINK-SODA2","PEPSI",2.50,Category.DRINKS),3));
        cart.addLine(new CartLine(new Product("FOOD-FASTFOOD","PANINI",2.30,Category.FOOD),4));

        //Initialize data
        Fidelity fidelity=new Fidelity(0);
        Checkout checkout=new Checkout();
        ReceiptBuilder receiptBuilder=new TextReceiptBuilder();
        ReceiptDirector receiptDirector=new ReceiptDirector(receiptBuilder);
        receiptDirector.makeReceipt(cart,fidelity,checkout);
        String receipt= receiptBuilder.getResult();
        System.out.println(receipt);
        checkout.updateCard(cart,fidelity);

        //check if fidelity points get add and if free drink discount works
        Cart cart2 = new Cart();
        cart2.addLine(new CartLine(new Product("DRINK-SODA3", "FANTA", 1.50,Category.DRINKS), 4));
        receiptDirector.makeReceipt(cart2, fidelity, checkout);
        System.out.println(receiptBuilder.getResult());
        checkout.updateCard(cart2,fidelity);

        //Check if -10% reduction is used
        Cart cart3=new Cart();
        cart3.addLine(new CartLine(new Product("PASTA","PANZANI",4.50,Category.FOOD),5));
        cart3.addLine(new CartLine(new Product("TECH","PS5",649,Category.OTHERS),1));
        receiptDirector.makeReceipt(cart3,fidelity,checkout);
        System.out.println(receiptBuilder.getResult());
        checkout.updateCard(cart3,fidelity);

        //check if fidelity points are used and get deducted
        Cart cart4=new Cart();
        cart4.addLine(new CartLine(new Product("PASTA","FARFALLE",4.50,Category.FOOD),3));
        receiptDirector.makeReceipt(cart4,fidelity,checkout);
        System.out.println(receiptBuilder.getResult());
        checkout.updateCard(cart4,fidelity);



    }
}
