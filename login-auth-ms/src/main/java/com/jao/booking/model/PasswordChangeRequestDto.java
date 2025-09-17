package com.jao.booking.model;

import lombok.Data;

@Data
public class PasswordChangeRequestDto {
    private String oldPassword;
    private String newPassword;
}