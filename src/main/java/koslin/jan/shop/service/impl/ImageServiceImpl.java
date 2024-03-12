package koslin.jan.shop.service.impl;

import koslin.jan.shop.service.ImageService;
import lombok.AllArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImpl implements ImageService {
    @Override
    public Resource getImage(String imageName) {
        Resource resource = new ClassPathResource("static/images/" + imageName);
        return resource;
    }
}
