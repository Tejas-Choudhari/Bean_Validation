package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="User Information")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private int id;
	
	@NotNull
	@Size(min=2,max=15,message="Name Should be more then two character")
	private String name;
	
	@NotNull
	@Email(message ="Invalid Email format")
	private String email;
	
	@NotNull
	@Size(min=8,max=15,message="password should be more then 8 character")
//	@Pattern(regexp="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])")
	private String password;
	
	@NotNull(message = "Mobile Number Shoudl not be null")
//	@Size(min=10,max=10, message ="Enter valid mobile number ")
	@Pattern(regexp = "^[0-9]{10}$",message ="Enter valid mobile number " )
	private String mobileNum;
	
	
	public User() {
		
	}

	public User(@NotNull int id, @NotBlank String name, @NotNull String email, @NotBlank String password,
			@NotEmpty String mobileNum) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.mobileNum = mobileNum;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNum() {
		return mobileNum;
	}

	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", mobileNum="
				+ mobileNum + "]";
	}
	
	
}
