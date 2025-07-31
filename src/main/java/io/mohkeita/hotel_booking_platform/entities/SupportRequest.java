package io.mohkeita.hotel_booking_platform.entities;

import io.mohkeita.hotel_booking_platform.enums.SupportRequestStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "SupportRequests")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupportRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "request_id")
    private UUID requestId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "issue", columnDefinition = "TEXT")
    private String issue;

    @Enumerated(EnumType.STRING)
    private SupportRequestStatus status;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
