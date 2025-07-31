package io.mohkeita.hotel_booking_platform.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomDTO {

    private UUID roomId;

    @NotNull(message = "Hotel ID is required")
    private UUID hotelId;

    @Size(max = 100, message = "Room type must not exceed 100 characters")
    private String roomType;

    @NotNull(message = "Price per night is required")
    @Positive(message = "Price per night must be positive")
    private BigDecimal pricePerNight;

    private Boolean availability;

    @Positive(message = "Max occupancy must be positive")
    private Integer maxOccupancy;

    // Relations
    private HotelDTO hotel;
    private List<String> imageUrls;
    private List<String> facilities;
}
