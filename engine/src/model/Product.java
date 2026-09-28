package src.model;

//record for a product
public record Product(String reference, String label, double price, Category category) {
    public Product{
        if(reference==null && reference.isBlank()){
            throw new IllegalArgumentException("la référence est obligatoire!");
        }
        if(label==null&&label.isBlank()){
            throw new IllegalArgumentException("Le nom du produit est obligatoire!");
        }
        if(price<0.0){
            throw new IllegalArgumentException("Le prix du produit ne doit pas être négatif!");
        }
        if(category==null){
            throw new IllegalArgumentException("La catégorie est obligatoire!");
        }
    }
}
