package koslin.jan.shop.service.impl;

import koslin.jan.shop.dto.AddressDto;
import koslin.jan.shop.entity.Address;
import koslin.jan.shop.entity.User;
import koslin.jan.shop.mapper.AddressMapper;
import koslin.jan.shop.repository.AddressRepository;
import koslin.jan.shop.repository.UserRepository;
import koslin.jan.shop.service.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AddressServiceImpl implements AddressService {

    private AddressRepository addressRepository;
    private UserRepository userRepository;
    @Override
    public List<AddressDto> getUserAddresses(String username) {
        return addressRepository.getAllByUserEmail(username)
                .stream()
                .map(AddressMapper::toDto)
                .toList();
    }

    @Override
    public AddressDto createAddress(String fullName, String street, String zipCode, String city, String phone, String email, String username) {
        AddressDto dto = new AddressDto();
        dto.setFullName(fullName);
        dto.setStreet(street);
        dto.setZipCode(zipCode);
        dto.setCity(city);
        dto.setPhone(phone);
        dto.setEmail(email);

        User user = userRepository.findByEmail(username).orElseThrow();
        Address address = AddressMapper.toEntity(dto, user);
        Address saved = addressRepository.save(address);
        return AddressMapper.toDto(saved);
    }

    @Override
    public AddressDto updateAddress(Long id, String fullName, String street, String zipCode, String city, String phone, String email, String username) {
        // Retrieve the address from the repository using its ID
        Address address = addressRepository.findById(id).orElseThrow();

        // Update the fields with the new values
        address.setFullName(fullName);
        address.setStreet(street);
        address.setZipCode(zipCode);
        address.setCity(city);
        address.setPhone(phone);
        address.setEmail(email);

        // Find the user associated with the address
        User user = userRepository.findByEmail(username).orElseThrow();

        // Update the user associated with the address
        address.setUser(user);

        // Save the updated address back to the repository
        Address saved = addressRepository.save(address);

        // Map the updated address to DTO and return
        return AddressMapper.toDto(saved);
    }

}
