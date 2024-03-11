package koslin.jan.shop.controller;

import koslin.jan.shop.dto.CategoryDto;
import koslin.jan.shop.dto.ProductDto;
import koslin.jan.shop.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDto>> getProducts(@RequestParam(required = false) String category) {
        if (category != null) {
            // Filter products based on the category ID
            List<ProductDto> productsByCategory = productService.getProductsByUrlName(category);
            return new ResponseEntity<>(productsByCategory, HttpStatus.OK);
        } else {
            // If no category ID is provided, return all products
            List<ProductDto> allProducts = productService.getProducts();
            return new ResponseEntity<>(allProducts, HttpStatus.OK);
        }
    }
}
