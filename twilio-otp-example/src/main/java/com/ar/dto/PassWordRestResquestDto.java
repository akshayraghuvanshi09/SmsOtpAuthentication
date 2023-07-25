package com.ar.dto;

import lombok.Data;

@Data
public class PassWordRestResquestDto {
	private String PhoneNumber;//destination
	private String UserName;
	private String OneTimePassword;
}
