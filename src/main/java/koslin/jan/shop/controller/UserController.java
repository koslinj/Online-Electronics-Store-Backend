package koslin.jan.shop.controller;


import koslin.jan.shop.dto.UserDto;
import koslin.jan.shop.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.GrantedAuthority;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping
    public ResponseEntity<UserDto> getUserInfo(@AuthenticationPrincipal UserDetails userDetails) {
        // Extract user information from UserDetails (Spring Security)
        String username = userDetails.getUsername();
        String role = userDetails.getAuthorities().stream()
                .findFirst()
                .map(GrantedAuthority::getAuthority)
                .orElse(null);
        String firstName = "";

        if(userDetails instanceof User) {
            firstName = ((User) userDetails).getFirstName();
        }

        // Create a DTO with user information
        UserDto userDto = new UserDto(username, role, firstName);

        return ResponseEntity.ok(userDto);
    }
}
