
package uk.ac.westminster.products_api;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private List<Product> products = new ArrayList<>();
    private Long nextId = 3L;

    // Constructor: Add sample digital and physical products
    public ProductService() {
        products.add(new DigitalProduct(
                1L,
                "Java Programming E-Book",
                1500.00,
                "https://example.com/java-book",
                25.5
        ));

        products.add(new PhysicalProduct(
                2L,
                "Mechanical Keyboard",
                8500.00,
                1.2,
                "44 x 13 x 3 cm"
        ));
    }

    // Get all products
    public List<Product> getAllProducts() {
        return products;
    }

    // Add a new product
    public Product addProduct(Product product) {
        product.setId(nextId++);
        products.add(product);
        return product;
    }

    // Get a product by its ID
    public Optional<Product> getProductById(Long id) {
        return products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst();
    }

    // Delete a product by its ID
    public boolean deleteProduct(Long id) {
        return products.removeIf(product -> product.getId().equals(id));
    }

    // Search products by name
    public List<Product> findByName(String name) {
        return products.stream()
                .filter(product -> product.getName().contains(name))
                .toList();
    }
}
