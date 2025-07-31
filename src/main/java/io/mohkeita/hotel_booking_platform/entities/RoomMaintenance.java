package io.mohkeita.hotel_booking_platform.entities;

import io.mohkeita.hotel_booking_platform.enums.MaintenanceStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "RoomMaintenance")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomMaintenance {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "maintenance_id")
    private UUID maintenanceId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Room room;

    @Column(name = "issue_description", columnDefinition = "TEXT")
    private String issueDescription;

    @Enumerated(EnumType.STRING)
    @Column(name = "maintenance_status")
    private MaintenanceStatus maintenanceStatus;
}
