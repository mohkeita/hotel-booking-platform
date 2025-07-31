package io.mohkeita.hotel_booking_platform.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Discounts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "discount_id")
    private UUID discountId;

    @Column(name = "discount_code", length = 50, unique = true)
    private String discountCode;

    @Column(name = "discount_percentage", precision = 5, scale = 2)
    private BigDecimal discountPercentage;

    @Column(name = "expiry_date")
    private LocalDate expiryDate;

    @ManyToMany(mappedBy = "appliedDiscounts")
    private List<Booking> bookings;
}
