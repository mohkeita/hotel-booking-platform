package io.mohkeita.hotel_booking_platform.listener;

import io.mohkeita.hotel_booking_platform.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class KeycloakUserEventListener {

    private final UserService userService;

    @EventListener
    public void handleAuthenticationSuccess(AuthenticationSuccessEvent event) {
        if (event.getAuthentication().getPrincipal() instanceof Jwt jwt) {
            try {
                String keycloakId = jwt.getSubject();
                log.info("User authenticated: {}", keycloakId);

                // Synchroniser l'utilisateur depuis Keycloak
                userService.syncUserFromKeycloak(event.getAuthentication());

                // Mettre à jour la dernière connexion
                userService.updateLastLogin(keycloakId);

            } catch (Exception e) {
                log.error("Error processing authentication event", e);
            }
        }
    }
}
