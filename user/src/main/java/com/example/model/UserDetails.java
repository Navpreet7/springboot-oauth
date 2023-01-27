package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class UserDetails {
	@Id
	private String userId;
	private String address;
	private String emailId;
	private String phone;
	private String gender;
	private String firstname;
	private String lastname;

	public UserDetails(String userid, String address, String emailId, String phone, String gender, String firstname,
			String lastname) {
		this.userId = userid;
		this.address = address;
		this.emailId = emailId;
		this.phone = phone;
		this.gender = gender;
		this.firstname = firstname;
		this.lastname = lastname;
	}

}
