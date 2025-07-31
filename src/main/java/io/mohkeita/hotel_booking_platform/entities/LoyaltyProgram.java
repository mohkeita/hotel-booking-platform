package io.mohkeita.hotel_booking_platform.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "LoyaltyPrograms")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoyaltyProgram {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "program_id")
    private UUID programId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "points")
    private Integer points;
}
