package koslin.jan.shop.mapper;

import koslin.jan.shop.dto.AddressDto;
import koslin.jan.shop.dto.CategoryDto;
import koslin.jan.shop.entity.Address;
import koslin.jan.shop.entity.Category;
import koslin.jan.shop.entity.User;

public class AddressMapper {
    public static AddressDto toDto(Address address){
        return new AddressDto(
                address.getId(),
                address.getFullName(),
                address.getStreet(),
                address.getZipCode(),
                address.getCity(),
                address.getPhone(),
                address.getEmail(),
                address.getUser().getUsername()
        );
    }

    public static Address toEntity(AddressDto addressDto, User user){
        return new Address(
                addressDto.getId(),
                addressDto.getFullName(),
                addressDto.getStreet(),
                addressDto.getZipCode(),
                addressDto.getCity(),
                addressDto.getPhone(),
                addressDto.getEmail(),
                user
        );
    }
}
