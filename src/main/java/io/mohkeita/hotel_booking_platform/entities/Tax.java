package io.mohkeita.hotel_booking_platform.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Taxes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tax {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "tax_id")
    private UUID taxId;

    @Column(name = "tax_name", length = 255)
    private String taxName;

    @Column(name = "tax_percentage", precision = 5, scale = 2)
    private BigDecimal taxPercentage;

    @ManyToMany(mappedBy = "taxes")
    private List<Booking> bookings;
}
