import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.*;

class Product {
    private String name;
    private double price;
    private String category;

    public Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }
}

public class ListToJsonArrayConverter {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws Exception {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Laptop", 1200.99, "Electronics"));
        products.add(new Product("Chair", 150.49, "Furniture"));
        products.add(new Product("Book", 19.99, "Education"));

        String jsonArray = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(products);
        System.out.println(jsonArray);
    }
}
