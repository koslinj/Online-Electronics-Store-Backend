package koslin.jan.shop.service.impl;

import koslin.jan.shop.config.ApplicationConfig;
import koslin.jan.shop.service.ImageService;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;

import org.springframework.stereotype.Service;

@Service
public class ImageServiceImpl implements ImageService {
    @Override
    public Resource getImage(String imageName) {
        Resource resource = new PathResource(ApplicationConfig.IMAGE_DIR + imageName);
        return resource;
    }
}
