package koslin.jan.shop.service;

import koslin.jan.shop.dto.PurchaseOrderDto;
import koslin.jan.shop.dto.PurchaseOrderItemDto;

import java.util.List;

public interface PurchaseOrderService {
    PurchaseOrderDto createPurchaseOrder(String username, List<PurchaseOrderItemDto> items);

    List<PurchaseOrderDto> getAll();
}
