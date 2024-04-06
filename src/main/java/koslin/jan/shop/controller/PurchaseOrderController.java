package koslin.jan.shop.controller;

import koslin.jan.shop.dto.OpinionDto;
import koslin.jan.shop.dto.PurchaseOrderDto;
import koslin.jan.shop.service.PurchaseOrderService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/orders")
public class PurchaseOrderController {

    private PurchaseOrderService purchaseOrderService;

    @GetMapping("/all")
    public ResponseEntity<List<PurchaseOrderDto>> getAll() {
        List<PurchaseOrderDto> allOrders = purchaseOrderService.getAll();
        return new ResponseEntity<>(allOrders, HttpStatus.OK);
    }

    @GetMapping(params = "username")
    public ResponseEntity<List<PurchaseOrderDto>> getOrdersByUsername(@RequestParam String username) {
        List<PurchaseOrderDto> orders = purchaseOrderService.getOrdersByUsername(username);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<PurchaseOrderDto>> getPurchaseOrders(Pageable pageable) {
        Page<PurchaseOrderDto> orders = purchaseOrderService.getPurchaseOrders(pageable);
        return ResponseEntity.ok(orders);
    }

    @PostMapping
    public ResponseEntity<PurchaseOrderDto> createOpinion(@RequestBody PurchaseOrderDto req) {
        PurchaseOrderDto saved = purchaseOrderService.createPurchaseOrder(
                req.getUser(),
                req.getItems()
        );

        return new ResponseEntity<>(saved, HttpStatus.OK);
    }
}
