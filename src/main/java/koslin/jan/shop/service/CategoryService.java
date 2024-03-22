package koslin.jan.shop.service;

import koslin.jan.shop.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    CategoryDto createCategory(CategoryDto categoryDto);

    List<CategoryDto> getCategories();

    List<CategoryDto> getCategoriesByUrlGeneralCategory(String generalCategory);

    CategoryDto getCategoryByUrlName(String name);
}
