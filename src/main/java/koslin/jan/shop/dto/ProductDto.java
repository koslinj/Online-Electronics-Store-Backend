package koslin.jan.shop.dto;

import koslin.jan.shop.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private double price;
    private String imageUrl;
    private String categoryName;
    private String categoryUrl;
    private List<String> filterNames;
    private List<String> filterValues;
}
