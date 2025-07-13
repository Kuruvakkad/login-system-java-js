package com.myloginapp.login_backend;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class LoginService {

    // Inject the UserRepository into this service.
    // Spring's dependency injection will automatically provide an instance of UserRepository.
    private final UserRepository userRepository;
    // Constructor for dependency injection.
    // Spring will automatically call this constructor and provide the UserRepository.
    public LoginService (UserRepository userRepository){
    
        this.userRepository = userRepository;
    }

    /**
     * Authenticates a user based on provided username and password.
     *
     * @param username The username to authenticate.
     * @param password The password to authenticate.
     * @return true if authentication is successful, false otherwise.
     */

    public boolean authenticate(String username, String password){
        // 1. Find the user by username using the UserRepository.
        // The findByUsername method returns an Optional<User>.
        Optional<User> userOptional = userRepository.findByUsername(username);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return user.getPassword().equals(password);

    }
    return false;
    }
}
