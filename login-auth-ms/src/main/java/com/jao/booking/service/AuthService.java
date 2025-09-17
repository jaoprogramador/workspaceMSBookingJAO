package com.jao.booking.service;

import com.jao.booking.model.LoginRequestDto;
import com.jao.booking.model.LoginResponseDto;

public interface AuthService {
    LoginResponseDto login(LoginRequestDto loginRequest);
}

