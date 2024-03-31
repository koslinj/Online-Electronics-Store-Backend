package koslin.jan.shop.service;

import koslin.jan.shop.dto.ProductDto;

import java.util.List;

public interface ProductService {

    List<ProductDto> searchProducts(String search);
    List<ProductDto> getProducts();
    ProductDto createProduct(ProductDto productDto);
    List<ProductDto> getProductsByUrlName(String urlName);

    ProductDto getProduct(String name);

    void deleteProduct(Long id);
}
