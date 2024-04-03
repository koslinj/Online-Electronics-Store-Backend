package koslin.jan.shop.service.impl;

import jakarta.transaction.Transactional;
import koslin.jan.shop.dto.ProductDto;
import koslin.jan.shop.entity.Category;
import koslin.jan.shop.entity.Filter;
import koslin.jan.shop.entity.Product;
import koslin.jan.shop.entity.ProductFilter;
import koslin.jan.shop.mapper.ProductMapper;
import koslin.jan.shop.repository.CategoryRepository;
import koslin.jan.shop.repository.FilterRepository;
import koslin.jan.shop.repository.ProductFilterRepository;
import koslin.jan.shop.repository.ProductRepository;
import koslin.jan.shop.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private ProductFilterRepository productFilterRepository;
    private CategoryRepository categoryRepository;
    private FilterRepository filterRepository;

    @Override
    public List<ProductDto> searchProducts(String search) {
        return productRepository.findAll().stream()
                .map(ProductMapper::toDto)
                .filter(product ->
                        product.getName().toLowerCase().contains(search.toLowerCase())
                )
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> getProducts() {
        return productRepository.findAll().stream()
                .map(ProductMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Page<ProductDto> getProducts(Pageable pageable) {
        return productRepository.findAll(pageable)
                .map(ProductMapper::toDto);
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Category category = categoryRepository.findByName(productDto.getCategoryName());

        // Check if the category exists
        if (category == null) {
            throw new IllegalArgumentException("Category does not exist");
        }

        Product product = ProductMapper.toEntity(productDto, category);
        Product savedProduct = productRepository.save(product);

        Set<ProductFilter> productFilters = saveProductFilters(productDto, savedProduct);

        savedProduct.setProductFilters(productFilters);

        return ProductMapper.toDto(savedProduct);
    }

    private Set<ProductFilter> saveProductFilters(ProductDto productDto, Product savedProduct) {
        Set<ProductFilter> productFilters = new HashSet<>();
        for (int i = 0; i < productDto.getFilterNames().size(); i++) {
            String filterName = productDto.getFilterNames().get(i);
            String filterValue = productDto.getFilterValues().get(i); // Get corresponding filter value
            Filter filter = filterRepository.findByName(filterName);
            if (filter != null) {
                ProductFilter productFilter = new ProductFilter();
                productFilter.setFilter(filter);
                productFilter.setFilterValue(filterValue);
                productFilter.setProduct(savedProduct);
                productFilterRepository.save(productFilter);
                productFilters.add(productFilter);
            } else {
                // Handle error or log a message if filter is not found
            }
        }
        return productFilters;
    }

    @Override
    public List<ProductDto> getProductsByUrlName(String urlName) {
        return productRepository.findByCategoryUrlName(urlName).stream()
                .map(ProductMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto getProduct(String name) {
        Product product = productRepository.findByName(name);
        return ProductMapper.toDto(product);
    }

    @Override
    @Transactional
    public void deleteProduct(Long id) {
        productFilterRepository.deleteAllByProductId(id);
        productRepository.deleteById(id);
    }

    @Override
    public ProductDto getProductById(Long id) {
        Product product = productRepository.findById(id).orElseThrow();
        return ProductMapper.toDto(product);
    }
}
