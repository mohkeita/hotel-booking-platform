package io.mohkeita.hotel_booking_platform.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomFacilityId implements Serializable {
    private UUID room;
    private String facilityName;
}
