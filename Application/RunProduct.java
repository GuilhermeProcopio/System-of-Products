package Application;

import Entities.ImportedProduct;
import Entities.Product;
import Entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public final class RunProduct {

    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        List<Product> listOfProducts = new ArrayList<>();

        System.out.print("Enter the number of products: ");
        int numberOfProducts = input.nextInt();

        for (int i=1; i<=numberOfProducts; i++) {
            System.out.println("Product #" + i + " data:");
            System.out.print("Common, used or imported (c/u/i)? ");
            char type = input.next().charAt(0);
            System.out.print("Name: ");
            input.nextLine();
            String name = input.nextLine();
            System.out.print("Price: ");
            double price = input.nextDouble();
            if (type == 'c') {
                listOfProducts.add(new Product(name, price));
            }
            else if (type == 'u') {
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                Date date = dateFormat.parse(input.next());
                listOfProducts.add(new UsedProduct(name, price, date));
            }
            else {
                System.out.print("Customs fee: ");
                double customsFee = input.nextDouble();
                listOfProducts.add(new ImportedProduct(name, price, customsFee));
            }
        }

        System.out.println();
        System.out.println("PRICE TAGS:");
        for (Product prod : listOfProducts) {
            System.out.println(prod.priceTag());
        }

        input.close();
    }


}
