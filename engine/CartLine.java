import java.util.List;

//Record of Cart lines with a product and its quantity
public record CartLine(Product product, int quantity) {

    public double total(){
        return product().price()*quantity;
    }
}

