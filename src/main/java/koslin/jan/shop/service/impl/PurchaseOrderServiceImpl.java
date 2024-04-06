package koslin.jan.shop.service.impl;

import koslin.jan.shop.dto.PurchaseOrderDto;
import koslin.jan.shop.dto.PurchaseOrderItemDto;
import koslin.jan.shop.entity.*;
import koslin.jan.shop.mapper.PurchaseOrderMapper;
import koslin.jan.shop.repository.ProductRepository;
import koslin.jan.shop.repository.PurchaseOrderItemRepository;
import koslin.jan.shop.repository.PurchaseOrderRepository;
import koslin.jan.shop.repository.UserRepository;
import koslin.jan.shop.service.PurchaseOrderService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
@AllArgsConstructor
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    private PurchaseOrderRepository purchaseOrderRepository;
    private PurchaseOrderItemRepository purchaseOrderItemRepository;
    private UserRepository userRepository;
    private ProductRepository productRepository;

    @Override
    public PurchaseOrderDto createPurchaseOrder(String username, double sum, List<PurchaseOrderItemDto> items) {
        PurchaseOrderDto dto = new PurchaseOrderDto();
        dto.setSum(sum);
        dto.setState("Oczekuje na zatwierdzenie");
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
    public PurchaseOrderDto updateOrder(Long id, String state) {
        PurchaseOrder order = purchaseOrderRepository.findById(id).orElseThrow();
        order.setState(state);

        PurchaseOrder saved = purchaseOrderRepository.save(order);
        return PurchaseOrderMapper.toDto(saved);
    }

    @Override
    public Page<PurchaseOrderDto> getPurchaseOrders(Pageable pageable) {
        pageable = PageRequest.of(
                pageable.getPageNumber(),
                pageable.getPageSize(),
                Sort.by(Sort.Direction.DESC, "createdAt")
        );

        return purchaseOrderRepository.findAll(pageable)
                .map(PurchaseOrderMapper::toDto);
    }

    @Override
    public List<PurchaseOrderDto> getOrdersByUsername(String username) {
        return purchaseOrderRepository.getAllByUserEmail(username)
                .stream()
                .map(PurchaseOrderMapper::toDto)
                .sorted(Comparator.comparing(PurchaseOrderDto::getCreatedAt).reversed())
                .toList();
    }

    @Override
    public List<PurchaseOrderDto> getAll() {
        return purchaseOrderRepository.findAll()
                .stream()
                .map(PurchaseOrderMapper::toDto)
                .toList();
    }
}
