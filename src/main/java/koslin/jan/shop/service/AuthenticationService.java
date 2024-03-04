package koslin.jan.shop.service;

import koslin.jan.shop.dto.AuthenticationResponse;
import koslin.jan.shop.dto.LoginRequest;
import koslin.jan.shop.dto.RegisterRequest;

public interface AuthenticationService {
    AuthenticationResponse register(RegisterRequest request);

    AuthenticationResponse login(LoginRequest request);
}
