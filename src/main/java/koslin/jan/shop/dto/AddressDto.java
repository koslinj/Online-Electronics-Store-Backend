package koslin.jan.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {
    private Long id;
    private String fullName;
    private String street;
    private String zipCode;
    private String city;
    private String phone;
    private String email;
    private String username;
}
