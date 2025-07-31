package io.mohkeita.hotel_booking_platform.controller;

import io.mohkeita.hotel_booking_platform.entities.User;
import io.mohkeita.hotel_booking_platform.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profile")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @GetMapping("/me")
    public ResponseEntity<User> getCurrentUser(Authentication authentication) {
        User user = userService.getCurrentUser(authentication);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/me")
    public ResponseEntity<User> updateCurrentUser(
            @RequestBody User updatedUser,
            Authentication authentication) {
        User currentUser = userService.getCurrentUser(authentication);
        User updated = userService.updateUser(currentUser.getUserId(), updatedUser);
        return ResponseEntity.ok(updated);
    }

    @PostMapping("/sync")
    public ResponseEntity<User> syncUser(Authentication authentication) {
        User user = userService.syncUserFromKeycloak(authentication);
        return ResponseEntity.ok(user);
    }
}
