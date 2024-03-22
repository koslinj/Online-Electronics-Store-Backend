package koslin.jan.shop.controller;

import koslin.jan.shop.dto.CategoryDto;
import koslin.jan.shop.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/categories")
public class CategoryController {

    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto){
        CategoryDto savedCategory = categoryService.createCategory(categoryDto);
        return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CategoryDto>> getCategories() {
        List<CategoryDto> categories = categoryService.getCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping(params = "generalCategory")
    public ResponseEntity<List<CategoryDto>> getCategoriesByUrlGeneralCategory(@RequestParam String generalCategory) {
        List<CategoryDto> categories = categoryService.getCategoriesByUrlGeneralCategory(generalCategory);
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping(params = "name")
    public ResponseEntity<CategoryDto> getCategoryByUrlName(@RequestParam String name) {
        CategoryDto category = categoryService.getCategoryByUrlName(name);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }
}
