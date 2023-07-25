package com.ar.service;

import java.text.DecimalFormat;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ar.config.TwilioConfig;
import com.ar.dto.PassWordRestResquestDto;
import com.ar.dto.PasswordRestResponseDto;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class TwilioOtpService {
	@Autowired
	private TwilioConfig twilioConfig;
	
	public ResponseEntity<PasswordRestResponseDto> sendOTPForPasswordReset(PassWordRestResquestDto dtPassWordRestResquestDto) {
		
		PhoneNumber to = new PhoneNumber(dtPassWordRestResquestDto.getPhoneNumber());
		PhoneNumber from = new PhoneNumber(twilioConfig.getTrialNumber());
		String otp = genrateOTP();
		String otpMessage ="Dear Customer , your OTP is ## "+ otp +"##. Use this passcode to complete your transaction. Thank you"; 
		
		
				
		 Message message = Message.creator(
	               to,from,
	               otpMessage)
	            .create();

	        System.out.println(message.getSid());
	        return null;
	}
	
	//6 digit otp
	private String genrateOTP() {
		return new DecimalFormat("000000").format(new Random().nextInt(999999));
	}
}
