package io.mohkeita.hotel_booking_platform.mapper;

import io.mohkeita.hotel_booking_platform.dto.PaymentDTO;
import io.mohkeita.hotel_booking_platform.entities.Payment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PaymentMapper {

    @Mapping(source = "booking.bookingId", target = "bookingId")
    PaymentDTO toDTO(Payment payment);

    @Mapping(source = "bookingId", target = "booking.bookingId")
    Payment toEntity(PaymentDTO paymentDTO);

    List<PaymentDTO> toDTOList(List<Payment> payments);
}
