package io.mohkeita.hotel_booking_platform.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HotelDTO {

    private UUID hotelId;

    @NotBlank(message = "Hotel name is required")
    @Size(max = 255, message = "Hotel name must not exceed 255 characters")
    private String hotelName;

    @Size(max = 255, message = "Location must not exceed 255 characters")
    private String location;

    private String description;

    @DecimalMin(value = "0.0", message = "Star rating must be at least 0")
    @DecimalMax(value = "5.0", message = "Star rating must not exceed 5")
    private BigDecimal starRating;

    @Email(message = "Contact email must be valid")
    private String contactEmail;

    @Size(max = 20, message = "Contact phone must not exceed 20 characters")
    private String contactPhone;

    // Relations
    private List<RoomDTO> rooms;
    private List<String> facilities;
    private List<ServiceDTO> services;
}
