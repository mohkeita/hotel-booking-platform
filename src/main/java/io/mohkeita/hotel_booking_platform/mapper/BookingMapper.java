package io.mohkeita.hotel_booking_platform.mapper;

import io.mohkeita.hotel_booking_platform.dto.BookingDTO;
import io.mohkeita.hotel_booking_platform.entities.Booking;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = {UserMapper.class, RoomMapper.class, PaymentMapper.class, ServiceOrderMapper.class},
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BookingMapper {

    @Mapping(source = "user.userId", target = "userId")
    @Mapping(source = "room.roomId", target = "roomId")
    BookingDTO toDTO(Booking booking);

    @Mapping(source = "userId", target = "user.userId")
    @Mapping(source = "roomId", target = "room.roomId")
    @Mapping(target = "cancellations", ignore = true)
    @Mapping(target = "taxes", ignore = true)
    @Mapping(target = "appliedDiscounts", ignore = true)
    Booking toEntity(BookingDTO bookingDTO);

    List<BookingDTO> toDTOList(List<Booking> bookings);
}
