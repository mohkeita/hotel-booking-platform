package io.mohkeita.hotel_booking_platform.service;

import io.mohkeita.hotel_booking_platform.entities.User;
import io.mohkeita.hotel_booking_platform.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class UserService {

    private final UserRepository userRepository;

    /**
     * Synchronise l'utilisateur depuis Keycloak vers la base de données locale
     */
    public User syncUserFromKeycloak(Authentication authentication) {
        if (authentication.getPrincipal() instanceof Jwt jwt) {
            String keycloakId = jwt.getSubject();
            String username = jwt.getClaimAsString("preferred_username");
            String email = jwt.getClaimAsString("email");
            String firstName = jwt.getClaimAsString("given_name");
            String lastName = jwt.getClaimAsString("family_name");

            log.info("from Keycloak: {}", jwt.getClaimAsString("preferred_username"));

            return userRepository.findByKeycloakId(keycloakId)
                    .map(user -> updateUserFromKeycloak(user, jwt))
                    .orElseGet(() -> createUserFromKeycloak(jwt));
        }
        throw new IllegalArgumentException("Invalid authentication principal");
    }

    /**
     * Récupère l'utilisateur actuel depuis le contexte de sécurité
     */
    public User getCurrentUser(Authentication authentication) {
        return syncUserFromKeycloak(authentication);
    }

    /**
     * Récupère un utilisateur par son ID Keycloak
     */
    public Optional<User> findByKeycloakId(String keycloakId) {
        return userRepository.findByKeycloakId(keycloakId);
    }

    /**
     * Met à jour les informations de l'utilisateur
     */
    public User updateUser(UUID userId, User updatedUser) {
        return userRepository.findById(userId)
                .map(user -> {
                    user.setPhone(updatedUser.getPhone());
                    user.setPreferredLanguage(updatedUser.getPreferredLanguage());
                    user.setMarketingConsent(updatedUser.getMarketingConsent());
                    return userRepository.save(user);
                })
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    /**
     * Met à jour la dernière connexion
     */
    public void updateLastLogin(String keycloakId) {
        userRepository.findByKeycloakId(keycloakId)
                .ifPresent(user -> {
                    user.setLastLogin(LocalDateTime.now());
                    userRepository.save(user);
                });
    }

    /**
     * Désactive un utilisateur
     */
    public void deactivateUser(UUID userId) {
        userRepository.findById(userId)
                .ifPresent(user -> {
                    user.setIsActive(false);
                    userRepository.save(user);
                });
    }

    private User createUserFromKeycloak(Jwt jwt) {
        log.info("Creating new user from Keycloak: {}", jwt.getSubject());

        User user = new User();
        user.setUserId(UUID.randomUUID());
        user.setKeycloakId(jwt.getSubject());
        user.setUsername(jwt.getClaimAsString("preferred_username"));
        user.setEmail(jwt.getClaimAsString("email"));
        user.setFirstName(jwt.getClaimAsString("given_name"));
        user.setLastName(jwt.getClaimAsString("family_name"));
        user.setIsActive(true);
        user.setCreatedAt(LocalDateTime.now());
        user.setLastLogin(LocalDateTime.now());

        return userRepository.save(user);
    }

    private User updateUserFromKeycloak(User user, Jwt jwt) {
        boolean updated = false;

        String email = jwt.getClaimAsString("email");
        if (email != null && !email.equals(user.getEmail())) {
            user.setEmail(email);
            updated = true;
        }

        String firstName = jwt.getClaimAsString("given_name");
        if (firstName != null && !firstName.equals(user.getFirstName())) {
            user.setFirstName(firstName);
            updated = true;
        }

        String lastName = jwt.getClaimAsString("family_name");
        if (lastName != null && !lastName.equals(user.getLastName())) {
            user.setLastName(lastName);
            updated = true;
        }

        user.setLastLogin(LocalDateTime.now());

        if (updated) {
            log.info("Updating user information from Keycloak: {}", user.getKeycloakId());
            return userRepository.save(user);
        }

        return user;
    }
}
