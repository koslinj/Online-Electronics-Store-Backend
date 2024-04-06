package koslin.jan.shop.repository;

import koslin.jan.shop.entity.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, Long> {
    List<PurchaseOrder> getAllByUserEmail(String username);
}
