package koslin.jan.shop.service;

import koslin.jan.shop.dto.AuthenticationResponse;
import koslin.jan.shop.dto.LoginRequest;
import koslin.jan.shop.dto.RegisterRequest;
import org.springframework.http.ResponseEntity;

public interface AuthenticationService {
    ResponseEntity<AuthenticationResponse> register(RegisterRequest request);

    AuthenticationResponse login(LoginRequest request);
}
