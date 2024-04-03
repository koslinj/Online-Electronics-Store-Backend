package koslin.jan.shop.repository;

import koslin.jan.shop.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {
    List<Address> getAllByUserEmail(String username);
}
