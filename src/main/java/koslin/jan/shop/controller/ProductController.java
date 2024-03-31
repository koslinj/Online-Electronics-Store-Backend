package koslin.jan.shop.controller;

import koslin.jan.shop.config.ApplicationConfig;
import koslin.jan.shop.dto.ProductDto;
import koslin.jan.shop.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;
    private ResourceLoader resourceLoader;

    @GetMapping(params = "search")
    public ResponseEntity<List<ProductDto>> searchProducts(@RequestParam String search) {
        List<ProductDto> searchedProducts = productService.searchProducts(search);
        return new ResponseEntity<>(searchedProducts, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getProducts() {
        List<ProductDto> allProducts = productService.getProducts();
        return new ResponseEntity<>(allProducts, HttpStatus.OK);
    }

    @GetMapping(params = "name")
    public ResponseEntity<ProductDto> getProduct(@RequestParam String name) {
        ProductDto product = productService.getProduct(name);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductDto> createProduct(
            @RequestParam("image") MultipartFile image,
            @RequestParam("name") String name,
            @RequestParam("description") String description,
            @RequestParam("price") Double price,
            @RequestParam("categoryName") String categoryName,
            @RequestParam("filterNames") List<String> filterNames,
            @RequestParam("filterValues") List<String> filterValues
    ) {
        try {
            String filename = saveFile(image, name);

            ProductDto dto = new ProductDto();
            dto.setName(name);
            dto.setDescription(description);
            dto.setPrice(price);
            dto.setImageUrl("http://localhost:8080/api/images/" + filename);
            dto.setCategoryName(categoryName);
            dto.setFilterNames(filterNames);
            dto.setFilterValues(
                    filterValues.stream()
                            .map(value -> URLDecoder.decode(value, StandardCharsets.UTF_8))
                            .toList()
            );
            ProductDto saved = productService.createProduct(dto);
            return new ResponseEntity<>(saved, HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>(new ProductDto(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private static String saveFile(MultipartFile image, String name) throws IOException {
        String filename = image.getOriginalFilename();
        String extension = filename.substring(filename.lastIndexOf("."));
        name = name.toLowerCase().replaceAll("[ /]", "-") + extension;

        File uploadedFile = new File(ApplicationConfig.IMAGE_DIR + name);
        Files.write(uploadedFile.toPath(), image.getBytes());
        return name;
    }

    @GetMapping(params = "category")
    public ResponseEntity<List<ProductDto>> getProductsByCategory(@RequestParam String category) {
        List<ProductDto> productsByCategory = productService.getProductsByUrlName(category);
        return new ResponseEntity<>(productsByCategory, HttpStatus.OK);
    }
}
