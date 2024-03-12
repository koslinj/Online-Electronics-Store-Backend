package koslin.jan.shop.service;

import koslin.jan.shop.dto.CategoryDto;
import org.springframework.core.io.Resource;

import java.util.List;

public interface ImageService {
    Resource getImage(String imageName);
}
