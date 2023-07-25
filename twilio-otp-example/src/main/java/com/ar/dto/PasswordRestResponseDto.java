package com.ar.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PasswordRestResponseDto {
	
	private OtpStatus status;
	private String message;

}
