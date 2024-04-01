package koslin.jan.shop.repository;

import koslin.jan.shop.entity.Opinion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OpinionRepository extends JpaRepository<Opinion, Long> {
    List<Opinion> getAllByProductId(Long id);
}
