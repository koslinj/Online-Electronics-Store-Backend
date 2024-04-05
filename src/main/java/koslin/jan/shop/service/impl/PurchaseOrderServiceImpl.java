package koslin.jan.shop.service.impl;

import koslin.jan.shop.dto.OpinionDto;
import koslin.jan.shop.dto.PurchaseOrderDto;
import koslin.jan.shop.dto.PurchaseOrderItemDto;
import koslin.jan.shop.entity.*;
import koslin.jan.shop.mapper.OpinionMapper;
import koslin.jan.shop.mapper.PurchaseOrderMapper;
import koslin.jan.shop.repository.ProductRepository;
import koslin.jan.shop.repository.PurchaseOrderItemRepository;
import koslin.jan.shop.repository.PurchaseOrderRepository;
import koslin.jan.shop.repository.UserRepository;
import koslin.jan.shop.service.PurchaseOrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    private PurchaseOrderRepository purchaseOrderRepository;
    private PurchaseOrderItemRepository purchaseOrderItemRepository;
    private UserRepository userRepository;
    private ProductRepository productRepository;

    @Override
    public PurchaseOrderDto createPurchaseOrder(String username, List<PurchaseOrderItemDto> items) {
        PurchaseOrderDto dto = new PurchaseOrderDto();
        User user = userRepository.findByEmail(username).orElseThrow();

        List<PurchaseOrderItem> purchaseOrderItems = new ArrayList<>();
        for (PurchaseOrderItemDto item : items) {
            PurchaseOrderItem purchaseOrderItem = new PurchaseOrderItem();
            purchaseOrderItem.setQuantity(item.getQuantity());
            Product product = productRepository.findById(item.getProductId()).orElseThrow();
            purchaseOrderItem.setProduct(product);

            purchaseOrderItems.add(purchaseOrderItem);
        }

        PurchaseOrder purchaseOrder = PurchaseOrderMapper.toEntity(dto, user, purchaseOrderItems);
        PurchaseOrder saved = purchaseOrderRepository.save(purchaseOrder);

        purchaseOrderItems.forEach(item -> item.setPurchaseOrder(saved));

        purchaseOrderItemRepository.saveAll(purchaseOrderItems);

        return PurchaseOrderMapper.toDto(saved);
    }

    @Override
    public List<PurchaseOrderDto> getAll() {
        return purchaseOrderRepository.findAll()
                .stream()
                .map(PurchaseOrderMapper::toDto)
                .toList();
    }
}
