package com.myloginapp.login_backend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// @RestController combines @Controller and @ResponseBody.
// It marks this class as a Spring MVC controller that handles REST requests.
@RestController
// @CrossOrigin enables Cross-Origin Resource Sharing (CORS).
// This is crucial for allowing your frontend (running on a different port/origin)
// to make requests to this backend API. Without it, your browser will block the requests.
@CrossOrigin(origins = "http://127.0.0.1:5500") // Adjust this to your frontend's URL if different
public class LoginController {

    private final LoginService loginService;

    // Spring will automatically inject the LoginService here because of @Autowired
    // or implicitly via constructor injection if only one constructor exists.
    @Autowired // This annotation is often used for field injection, though constructor injection is preferred.
               // For simplicity, we'll use @Autowired here.
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    // @PostMapping maps HTTP POST requests to the /api/login URL to this method.
    @PostMapping("/api/login")
    // @RequestBody tells Spring to convert the JSON body of the incoming request
    // into a LoginRequest object.
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        // Call the authenticate method from our LoginService
        boolean isAuthenticated = loginService.authenticate(loginRequest.getUsername(), loginRequest.getPassword());

        if (isAuthenticated) {
            // Return HTTP 200 OK with a success message
            return new ResponseEntity<>("Login successful!", HttpStatus.OK);
        } else {
            // Return HTTP 401 Unauthorized with an error message
            return new ResponseEntity<>("Invalid credentials", HttpStatus.UNAUTHORIZED);
        }
    }
}

