package src.model;

//Record of Cart lines with a product and its quantity
public record CartLine(Product product, int quantity) {
    public CartLine{
        if (product==null){
            throw new IllegalArgumentException("Un objet produit est obligatoire!");
        }
        if(quantity<=0){
            throw new IllegalArgumentException("La quantité de produit ne peut pas être négative!");
        }
    }

    public double total(){
        return product().price()*quantity;
    }
}

