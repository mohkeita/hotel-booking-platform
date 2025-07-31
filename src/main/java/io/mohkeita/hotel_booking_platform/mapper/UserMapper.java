package io.mohkeita.hotel_booking_platform.mapper;

import io.mohkeita.hotel_booking_platform.dto.UserDTO;
import io.mohkeita.hotel_booking_platform.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    @Mapping(target = "keycloakId", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "bookings", ignore = true)
    @Mapping(target = "reviews", ignore = true)
    @Mapping(target = "notifications", ignore = true)
    @Mapping(target = "supportRequests", ignore = true)
    @Mapping(target = "feedbacks", ignore = true)
    @Mapping(target = "loyaltyProgram", ignore = true)
    UserDTO toDTO(User user);

    @Mapping(target = "keycloakId", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "bookings", ignore = true)
    @Mapping(target = "reviews", ignore = true)
    @Mapping(target = "notifications", ignore = true)
    @Mapping(target = "supportRequests", ignore = true)
    @Mapping(target = "feedbacks", ignore = true)
    @Mapping(target = "loyaltyProgram", ignore = true)
    User toEntity(UserDTO userDTO);

    List<UserDTO> toDTOList(List<User> users);

    @Mapping(target = "userId", ignore = true)
    @Mapping(target = "keycloakId", ignore = true)
    @Mapping(target = "username", ignore = true)
    @Mapping(target = "email", ignore = true)
    @Mapping(target = "firstName", ignore = true)
    @Mapping(target = "lastName", ignore = true)
    @Mapping(target = "isActive", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "lastLogin", ignore = true)
    @Mapping(target = "bookings", ignore = true)
    @Mapping(target = "reviews", ignore = true)
    @Mapping(target = "notifications", ignore = true)
    @Mapping(target = "supportRequests", ignore = true)
    @Mapping(target = "feedbacks", ignore = true)
    @Mapping(target = "loyaltyProgram", ignore = true)
    void updateUserFromDTO(UserDTO userDTO, @MappingTarget User user);
}
