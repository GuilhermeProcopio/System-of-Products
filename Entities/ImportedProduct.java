package Entities;

public class ImportedProduct extends Product{
    private Double customFee;

    public ImportedProduct(){ super(); }

    public ImportedProduct(String name, Double price, Double customFee) {
        super(name, price);
        this.customFee = customFee;
    }

    public Double totalPrice(){
        return getPrice() + customFee;
    }

    @Override
    public String priceTag(){
        return String.format(
                "Product %s\t" +
                        "Price: $%.2f\t" +
                        "Customs fees: $%.2f",
                getName(), totalPrice(), customFee);
    }
}
