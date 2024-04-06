package koslin.jan.shop.service;

import koslin.jan.shop.dto.AddressDto;
import koslin.jan.shop.dto.PurchaseOrderDto;
import koslin.jan.shop.dto.PurchaseOrderItemDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PurchaseOrderService {
    PurchaseOrderDto createPurchaseOrder(String username, double sum, List<PurchaseOrderItemDto> items);

    PurchaseOrderDto updateOrder(Long id, String state);

    Page<PurchaseOrderDto> getPurchaseOrders(Pageable pageable);

    List<PurchaseOrderDto> getOrdersByUsername(String username);

    List<PurchaseOrderDto> getAll();
}
