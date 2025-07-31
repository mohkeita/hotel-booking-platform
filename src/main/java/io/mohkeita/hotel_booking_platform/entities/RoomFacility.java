package io.mohkeita.hotel_booking_platform.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "RoomFacilities")
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(RoomFacilityId.class)
public class RoomFacility {
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Room room;

    @Id
    @Column(name = "facility_name", length = 255)
    private String facilityName;
}
