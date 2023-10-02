
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Product[] products = {
                new Product(312887411, "Banana", parseDate("2023-01-24"), 124, 0.55),
                new Product(292745826, "Apple", parseDate("2022-12-09"), 18, 1.09),
                new Product(918992746, "Carrot", parseDate("2023-03-31"), 89, 2.99)
        };


        Arrays.sort(products, Comparator.comparing(Product::getName));

        System.out.println("");
        printProductsJSON(products);
        System.out.println("---------------------------------------------------------------------------------------------");
        printProductsXML(products);
        System.out.println("---------------------------------------------------------------------------------------------");
        printProductsCSV(products);
    }



    private static Date parseDate(String dateStr) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
        } catch (Exception e) {
            throw new RuntimeException("Error parsing date: " + e.getMessage());
        }
    }


    private static void printProductsJSON(Product[] products) {
        System.out.println("Products in JSON format:");
        System.out.println("[");
        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            System.out.println("  {");
            System.out.println("    \"Product Id\": " + product.getProductId() + ",");
            System.out.println("    \"Name\": \"" + product.getName() + "\",");
            System.out.println("    \"Date Supplied\": \"" + product.formattedDate() + "\",");
            System.out.println("    \"Quantity In Stock\": " + product.getQuantityInStock() + ",");
            System.out.println("    \"Unit Price\": " + product.getUnitPrice());
            if (i < products.length - 1) {
                System.out.println("  },");
            } else {
                System.out.println("  }");
            }
        }
        System.out.println("]");
    }

    private static void printProductsXML(Product[] products) {
        System.out.println("Products in XML format:");
        System.out.println("<Products>");
        for (Product product : products) {
            System.out.println("  <Product>");
            System.out.println("    <Product_Id>" + product.getProductId() + "</Product_Id>");
            System.out.println("    <Name>" + product.getName() + "</Name>");
            System.out.println("    <Date_Supplied>" + product.formattedDate() + "</Date_Supplied>");
            System.out.println("    <Quantity_In_Stock>" + product.getQuantityInStock() + "</Quantity_In_Stock>");
            System.out.println("    <Unit_Price>" + product.getUnitPrice() + "</Unit_Price>");
            System.out.println("  </Product>");
        }
        System.out.println("</Products>");
    }

    private static void printProductsCSV(Product[] products) {
        System.out.println("Products in CSV format:");
        System.out.println("Product Id,Name,Date Supplied,Quantity In Stock,Unit Price");
        for (Product product : products) {
            System.out.println(
                    product.getProductId() + "," +
                            "\"" + product.getName() + "\"," +
                            "\"" + product.formattedDate() + "\"," +
                            product.getQuantityInStock() + "," +
                            product.getUnitPrice()
            );
        }
    }


}
