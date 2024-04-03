package koslin.jan.shop.controller;

import koslin.jan.shop.dto.AddressDto;
import koslin.jan.shop.dto.OpinionDto;
import koslin.jan.shop.service.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/addresses")
public class AddressController {

    private AddressService addressService;

    @GetMapping(params = "username")
    public ResponseEntity<List<AddressDto>> getUserAddresses(@RequestParam String username) {
        List<AddressDto> allAddresses = addressService.getUserAddresses(username);
        return new ResponseEntity<>(allAddresses, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AddressDto> createAddress(
            @RequestParam("fullName") String fullName,
            @RequestParam("street") String street,
            @RequestParam("zipCode") String zipCode,
            @RequestParam("city") String city,
            @RequestParam("phone") String phone,
            @RequestParam("email") String email,
            @RequestParam("username") String username
    ) {
        AddressDto saved = addressService.createAddress(fullName, street, zipCode, city, phone, email, username);

        return new ResponseEntity<>(saved, HttpStatus.OK);
    }

}
