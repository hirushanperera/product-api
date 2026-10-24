package uk.ac.westminster.products_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")


public class ProductController {

    // Spring creates the ProductService and hands it over.
    @Autowired
    private ProductService productService;
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();

    }

    // Delete a product by its ID
    @DeleteMapping("/products/{id}")
    public boolean deleteProduct(@PathVariable Long id) {
        return productService.deleteProduct(id);
    }

    @GetMapping("/products/search")
    public List<Product> search(@RequestParam String name) {
        return productService.findByName(name);
    }


}