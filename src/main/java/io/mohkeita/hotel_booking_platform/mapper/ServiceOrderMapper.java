package io.mohkeita.hotel_booking_platform.mapper;

import io.mohkeita.hotel_booking_platform.dto.ServiceOrderDTO;
import io.mohkeita.hotel_booking_platform.entities.ServiceOrder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = {ServiceMapper.class},
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ServiceOrderMapper {
    @Mapping(source = "booking.bookingId", target = "bookingId")
    @Mapping(source = "service.serviceId", target = "serviceId")
    ServiceOrderDTO toDTO(ServiceOrder serviceOrder);

    @Mapping(source = "bookingId", target = "booking.bookingId")
    @Mapping(source = "serviceId", target = "service.serviceId")
    ServiceOrder toEntity(ServiceOrderDTO serviceOrderDTO);

    List<ServiceOrderDTO> toDTOList(List<ServiceOrder> serviceOrders);
}
