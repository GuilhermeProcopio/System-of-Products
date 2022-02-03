package Entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProduct extends Product{
    private Date manuFactureDate;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public UsedProduct(){ super(); }

    public UsedProduct(String name, Double price, Date manuFactureDate) {
        super(name, price);
        this.manuFactureDate = manuFactureDate;
    }

    public Date getManuFactureDate() {
        return manuFactureDate;
    }

    @Override
    public String priceTag(){
        return String.format("Product used: %s\t" +
                "Price: $%.2f\t" +
                        "Date Of Fabrication is:\t" + dateFormat.format(getManuFactureDate()),
                getName(), getPrice());
    }
}
