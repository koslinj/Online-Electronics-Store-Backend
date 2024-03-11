package koslin.jan.shop.mapper;

import koslin.jan.shop.dto.ProductDto;
import koslin.jan.shop.entity.Category;
import koslin.jan.shop.entity.Product;

public class ProductMapper {
    public static ProductDto toDto(Product product) {
        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getImageUrl(),
                product.getCategory().getName()
        );
    }

    public static Product toEntity(ProductDto productDto, Category category) {
        return new Product(
                productDto.getId(),
                productDto.getName(),
                productDto.getDescription(),
                productDto.getPrice(),
                productDto.getImageUrl(),
                category
        );
    }
}
