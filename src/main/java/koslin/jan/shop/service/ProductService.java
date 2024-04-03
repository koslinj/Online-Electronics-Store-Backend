package koslin.jan.shop.service;

import koslin.jan.shop.dto.ProductDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

    List<ProductDto> searchProducts(String search);
    List<ProductDto> getProducts();
    Page<ProductDto> getProducts(Pageable pageable);
    ProductDto createProduct(ProductDto productDto);
    List<ProductDto> getProductsByUrlName(String urlName);

    ProductDto getProduct(String name);

    void deleteProduct(Long id);

    ProductDto getProductById(Long id);
}
