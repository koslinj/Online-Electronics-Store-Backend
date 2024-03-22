package koslin.jan.shop.mapper;

import koslin.jan.shop.dto.CategoryDto;
import koslin.jan.shop.entity.Category;

public class CategoryMapper {

    public static CategoryDto toDto(Category category){
        return new CategoryDto(
                category.getId(),
                category.getGeneralCategory(),
                category.getUrlGeneralCategory(),
                category.getName(),
                category.getUrlName()
        );
    }

    public static Category toEntity(CategoryDto categoryDto){
        return new Category(
                categoryDto.getId(),
                categoryDto.getGeneralCategory(),
                categoryDto.getUrlGeneralCategory(),
                categoryDto.getName(),
                categoryDto.getUrlName()
        );
    }
}
