package koslin.jan.shop.repository;

import koslin.jan.shop.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String name);

    Collection<Category> findByUrlGeneralCategory(String urlGeneralCategory);

    Category findByUrlName(String urlName);
}
