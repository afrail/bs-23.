package com.test.bs_23.response;


import lombok.Data;

/**
 * @Project   candle
 * @Author    Md. Afrail Hossain
 * @Since     jan 21, 2024
 * @version   1.0.0
 */

@Data
public class LoginResponse {

	public String token;
	public Integer id;
	
	public LoginResponse(String token, 
			Integer id) {
		super();
		this.token = token;
		this.id = id;
	}
	
	
	
}
