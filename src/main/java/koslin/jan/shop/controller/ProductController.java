package koslin.jan.shop.controller;

import koslin.jan.shop.dto.CategoryDto;
import koslin.jan.shop.dto.ProductDto;
import koslin.jan.shop.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    @GetMapping(params = "search")
    public ResponseEntity<List<ProductDto>> searchProducts(@RequestParam String search) {
        List<ProductDto> searchedProducts = productService.searchProducts(search);
        return new ResponseEntity<>(searchedProducts, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<ProductDto>> getProducts() {
        List<ProductDto> allProducts = productService.getProducts();
        return new ResponseEntity<>(allProducts, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto dto){
        ProductDto saved = productService.createProduct(dto);
        return new ResponseEntity<>(saved, HttpStatus.OK);
    }

    @GetMapping(params = "category")
    public ResponseEntity<List<ProductDto>> getProductsByCategory(@RequestParam String category) {
        List<ProductDto> productsByCategory = productService.getProductsByUrlName(category);
        return new ResponseEntity<>(productsByCategory, HttpStatus.OK);
    }
}
