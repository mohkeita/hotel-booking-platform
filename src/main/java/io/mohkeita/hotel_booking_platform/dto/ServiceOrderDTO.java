package io.mohkeita.hotel_booking_platform.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceOrderDTO {

    private UUID orderId;

    @NotNull(message = "Booking ID is required")
    private UUID bookingId;

    @NotNull(message = "Service ID is required")
    private UUID serviceId;

    @NotNull(message = "Quantity is required")
    @Positive(message = "Quantity must be positive")
    private Integer quantity;

    @NotNull(message = "Total price is required")
    @Positive(message = "Total price must be positive")
    private BigDecimal totalPrice;

    private LocalDateTime createdAt;

    // Relations
    private ServiceDTO service;
}
