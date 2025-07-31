package io.mohkeita.hotel_booking_platform.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "Cancellations")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cancellation {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "cancellation_id")
    private UUID cancellationId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "booking_id")
    private Booking booking;

    @Column(name = "reason", columnDefinition = "TEXT")
    private String reason;

    @Column(name = "cancellation_date")
    private LocalDateTime cancellationDate;
}
