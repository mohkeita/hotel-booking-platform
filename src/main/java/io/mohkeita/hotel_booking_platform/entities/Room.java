package io.mohkeita.hotel_booking_platform.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Rooms")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "room_id")
    private UUID roomId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @Column(name = "room_type", length = 100)
    private String roomType;

    @Column(name = "price_per_night", precision = 10, scale = 2)
    private BigDecimal pricePerNight;

    @Column(name = "availability")
    private Boolean availability;

    @Column(name = "max_occupancy")
    private Integer maxOccupancy;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<Booking> bookings;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<RoomImage> images;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<RoomFacility> facilities;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<RoomMaintenance> maintenances;
}
