package com.jao.booking.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class LoginResponseDto {
	private UserDto user;   
    private String token;
    private String refreshToken;
}
