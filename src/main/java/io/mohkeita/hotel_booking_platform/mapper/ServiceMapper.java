package io.mohkeita.hotel_booking_platform.mapper;

import io.mohkeita.hotel_booking_platform.dto.ServiceDTO;
import io.mohkeita.hotel_booking_platform.entities.Service;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ServiceMapper {
    @Mapping(source = "hotel.hotelId", target = "hotelId")
    ServiceDTO toDTO(Service service);

    @Mapping(source = "hotelId", target = "hotel.hotelId")
    @Mapping(target = "serviceOrders", ignore = true)
    Service toEntity(ServiceDTO serviceDTO);

    List<ServiceDTO> toDTOList(List<Service> services);
}
