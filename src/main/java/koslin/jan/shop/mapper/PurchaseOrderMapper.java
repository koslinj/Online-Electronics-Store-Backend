package koslin.jan.shop.mapper;

import koslin.jan.shop.dto.PurchaseOrderDto;
import koslin.jan.shop.dto.PurchaseOrderItemDto;
import koslin.jan.shop.entity.Product;
import koslin.jan.shop.entity.PurchaseOrder;
import koslin.jan.shop.entity.PurchaseOrderItem;
import koslin.jan.shop.entity.User;

import java.util.List;

public class PurchaseOrderMapper {
    public static PurchaseOrderDto toDto(PurchaseOrder order) {
        return new PurchaseOrderDto(
                order.getId(),
                order.getCreatedAt(),
                order.getUser().getEmail(),
                order.getState(),
                order.getSum(),
                order.getPurchaseOrderItems().stream()
                        .map(item -> {
                            PurchaseOrderItemDto dto = new PurchaseOrderItemDto();
                            dto.setId(item.getId());
                            dto.setPurchaseOrderId(order.getId());
                            dto.setProductId(item.getProduct().getId());
                            dto.setQuantity(item.getQuantity());
                            return dto;
                        })
                        .toList()
        );
    }

    public static PurchaseOrder toEntity(PurchaseOrderDto dto, User user, List<PurchaseOrderItem> items) {
        return new PurchaseOrder(
                dto.getId(),
                dto.getCreatedAt(),
                dto.getState(),
                dto.getSum(),
                items,
                user
        );
    }
}
