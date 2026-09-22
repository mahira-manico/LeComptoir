import java.util.ArrayList;
import java.util.List;


//Class Cart with a list of Cart lines
public class Cart{

    //take list of cartLines
    private final List<CartLine> cartLines;

    public Cart() {
        this.cartLines=new ArrayList<>();
    }

    //Constructor
    public Cart(List<CartLine> cartLines){
        this.cartLines=cartLines;
    }

    //Take cart lines of the list
    public List<CartLine> getCartLines() {
        return cartLines;
    }

    //add a line of a product to the list
    public void addLine(CartLine line){
        this.cartLines.add(line);
    }

    //get the sub total of the full list
    public double subTotal(){
        double totalCart=0.0;

        for(CartLine line:cartLines){
            totalCart+=line.total();
        }
        return totalCart;
    }
}
