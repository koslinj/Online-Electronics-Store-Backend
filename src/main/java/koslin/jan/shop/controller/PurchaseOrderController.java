package koslin.jan.shop.controller;

import koslin.jan.shop.dto.CategoryDto;
import koslin.jan.shop.dto.OpinionDto;
import koslin.jan.shop.dto.PurchaseOrderDto;
import koslin.jan.shop.service.PurchaseOrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/orders")
public class PurchaseOrderController {

    private PurchaseOrderService purchaseOrderService;

    @GetMapping
    public ResponseEntity<List<PurchaseOrderDto>> getAll() {
        List<PurchaseOrderDto> allOrders = purchaseOrderService.getAll();
        return new ResponseEntity<>(allOrders, HttpStatus.OK);
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
