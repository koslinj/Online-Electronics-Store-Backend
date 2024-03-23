package koslin.jan.shop.repository;

import koslin.jan.shop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Collection<Product> findByCategoryUrlName(String urlName);
    Product findByName(String name);
}
