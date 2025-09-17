package com.jao.booking.service;

import com.jao.booking.model.PasswordChangeRequestDto;
import com.jao.booking.model.UserDto;
import java.util.List;
import java.util.UUID;

public interface UserService {
    UserDto createUser(UserDto userDto, String rawPassword);
    UserDto getUserById(UUID id);
    List<UserDto> getAllUsers();
    void changePassword(UUID userId, PasswordChangeRequestDto request);
}

