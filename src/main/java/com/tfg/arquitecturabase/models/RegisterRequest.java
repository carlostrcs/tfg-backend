package com.tfg.arquitecturabase.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
	private String name;
	private String surname;
    private String email;
    private String password;
    private String phoneNumber;
    private Role role;
    private boolean confirmed = false;
}
