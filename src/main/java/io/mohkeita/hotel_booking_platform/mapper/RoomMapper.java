package io.mohkeita.hotel_booking_platform.mapper;

import io.mohkeita.hotel_booking_platform.dto.RoomDTO;
import io.mohkeita.hotel_booking_platform.entities.Room;
import io.mohkeita.hotel_booking_platform.entities.RoomFacility;
import io.mohkeita.hotel_booking_platform.entities.RoomImage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring",
        uses = {HotelMapper.class},
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoomMapper {

    @Mapping(source = "hotel.hotelId", target = "hotelId")
    @Mapping(source = "images", target = "imageUrls")
    @Mapping(source = "facilities", target = "facilities")
    RoomDTO toDTO(Room room);

    @Mapping(source = "hotelId", target = "hotel.hotelId")
    @Mapping(target = "images", ignore = true)
    @Mapping(target = "facilities", ignore = true)
    @Mapping(target = "bookings", ignore = true)
    @Mapping(target = "maintenances", ignore = true)
    Room toEntity(RoomDTO roomDTO);

    List<RoomDTO> toDTOList(List<Room> rooms);

    default List<String> mapImagesToUrls(List<RoomImage> images) {
        if (images == null) return null;
        return images.stream()
                .map(RoomImage::getImageUrl)
                .collect(Collectors.toList());
    }

    default List<String> mapFacilitiesToStrings(List<RoomFacility> facilities) {
        if (facilities == null) return null;
        return facilities.stream()
                .map(RoomFacility::getFacilityName)
                .collect(Collectors.toList());
    }
}
