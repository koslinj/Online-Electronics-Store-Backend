package koslin.jan.shop.service;

import koslin.jan.shop.dto.AddressDto;
import koslin.jan.shop.dto.FilterDto;

import java.util.List;

public interface AddressService {
    List<AddressDto> getUserAddresses(String username);

    AddressDto createAddress(
            String fullName,
            String street,
            String zipCode,
            String city,
            String phone,
            String email,
            String username
    );
}
