package src.model;

import java.util.ArrayList;
import java.util.List;


//Record Cart with a list of Cart lines
public record Cart(List<CartLine> cartLines) {

    public Cart() {
        this(new ArrayList<>());
    }

    public Cart(List<CartLine> cartLines) {
        this.cartLines = (cartLines != null) ? new ArrayList<>(cartLines) : new ArrayList<>();
    }

    //add a line of a product to the list
    public void addLine(CartLine line) {
        if (line != null) {
            this.cartLines.add(line);
        }
    }

    //get the sub-total of the full list
    public double subTotal() {
        double totalCart = 0.0;

        for (CartLine line : cartLines) {
            totalCart += line.total();
        }
        return totalCart;
    }
}
