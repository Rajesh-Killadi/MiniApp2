package com.appbindings;

import lombok.Data;

@Data
public class UpdatePasswordBinding {

	private Integer userId;
	private String password;
	private String confirmPassword;
}
