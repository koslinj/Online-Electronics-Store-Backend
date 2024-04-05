package koslin.jan.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseOrderItemDto {
    private Long id;
    private int quantity;
    private Long productId;
    private Long purchaseOrderId;
}
