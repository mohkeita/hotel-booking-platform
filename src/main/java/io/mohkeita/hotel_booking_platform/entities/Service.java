package io.mohkeita.hotel_booking_platform.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Services")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "service_id")
    private UUID serviceId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @Column(name = "service_name", length = 255)
    private String serviceName;

    @Column(name = "price", precision = 10, scale = 2)
    private BigDecimal price;

    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL)
    private List<ServiceOrder> serviceOrders;
}
