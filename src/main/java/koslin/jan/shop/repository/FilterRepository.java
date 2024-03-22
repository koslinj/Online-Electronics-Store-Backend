package koslin.jan.shop.repository;

import koslin.jan.shop.entity.Filter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilterRepository extends JpaRepository<Filter, Long> {
    Filter findByName(String name);
    List<Filter> getAllByName(String name);
}