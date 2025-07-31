package io.mohkeita.hotel_booking_platform.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "HotelFacilities")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HotelFacility {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "facility_id")
    private UUID facilityId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @Column(name = "facility_name", length = 255)
    private String facilityName;
}
