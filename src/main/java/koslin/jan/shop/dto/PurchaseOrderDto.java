package koslin.jan.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseOrderDto {
    private Long id;
    private Instant createdAt;
    private String user;
    private List<PurchaseOrderItemDto> items;
}
