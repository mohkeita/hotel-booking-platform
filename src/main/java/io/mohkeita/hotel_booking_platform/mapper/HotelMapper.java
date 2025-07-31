package io.mohkeita.hotel_booking_platform.mapper;

import io.mohkeita.hotel_booking_platform.dto.HotelDTO;
import io.mohkeita.hotel_booking_platform.entities.Hotel;
import io.mohkeita.hotel_booking_platform.entities.HotelFacility;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring",
        uses = {RoomMapper.class, ServiceMapper.class},
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface HotelMapper {

    @Mapping(source = "facilities", target = "facilities")
    HotelDTO toDTO(Hotel hotel);

    @Mapping(target = "employees", ignore = true)
    @Mapping(target = "reviews", ignore = true)
    @Mapping(target = "facilities", ignore = true)
    @Mapping(target = "policies", ignore = true)
    Hotel toEntity(HotelDTO hotelDTO);

    List<HotelDTO> toDTOList(List<Hotel> hotels);

    default List<String> mapFacilitiesToStrings(List<HotelFacility> facilities) {
        if (facilities == null) return null;
        return facilities.stream()
                .map(HotelFacility::getFacilityName)
                .collect(Collectors.toList());
    }
}
