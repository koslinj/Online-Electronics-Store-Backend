package koslin.jan.shop.service.impl;

import koslin.jan.shop.dto.ProductDto;
import koslin.jan.shop.entity.Category;
import koslin.jan.shop.entity.Product;
import koslin.jan.shop.mapper.CategoryMapper;
import koslin.jan.shop.mapper.ProductMapper;
import koslin.jan.shop.repository.CategoryRepository;
import koslin.jan.shop.repository.ProductRepository;
import koslin.jan.shop.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    @Override
    public List<ProductDto> getProducts() {
        return productRepository.findAll().stream()
                .map(ProductMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        // Retrieve the Category entity based on the unique category name
        Category category = categoryRepository.findByName(productDto.getCategoryName());

        // Check if the category exists
        if (category == null) {
            throw new IllegalArgumentException("Category does not exist");
        }

        Product product = ProductMapper.toEntity(productDto, category);
        Product savedProduct = productRepository.save(product);

        return ProductMapper.toDto(savedProduct);
    }

    @Override
    public List<ProductDto> getProductsByUrlName(String urlName) {
        return productRepository.findByCategoryUrlName(urlName).stream()
                .map(ProductMapper::toDto)
                .collect(Collectors.toList());
    }
}
