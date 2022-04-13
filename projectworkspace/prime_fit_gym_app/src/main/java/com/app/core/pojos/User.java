package com.app.core.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User extends BaseEntity {

	@NotEmpty(message = "First Name can't be blank")
	@Length(min = 3, max = 20, message = "Invalid First Name length!!!!")
	@Column(length = 20, nullable = false)
	private String firstName;

	@Column(length = 20, nullable = false)
	@NotEmpty(message = "Last Name can't be blank")
	@Length(min = 3, max = 20, message = "Invalid Last Name length!!!!")
	private String lastName;

	@NotEmpty(message = "email must be supplied")
	@Column(length = 30, nullable = false, unique = true)
	private String email;

	@Column(length = 20, nullable = false)
	@NotEmpty(message = "password must be supplied")
	private String password;

	@Transient
	@JsonIgnore
	private String confirmPassword;

	@Column(length = 20)
	private String locality;

	@Column(length = 20)
	private String city;

	@Column(length = 20)
	private String state;

	@Column(length = 10)
	private int zipCode;

	@Column(length = 20)
	private int phone; 
	
	
	@OneToOne
	@JoinColumn(unique = true)
	private GymBranch branch;

	@JoinTable(name = "user_roles") 
	@Enumerated(EnumType.STRING)
	private UserRole role;

	public User(
			@NotEmpty(message = "First Name can't be blank") @Length(min = 3, max = 20, message = "Invalid First Name length!!!!") String firstName,
			@NotEmpty(message = "Last Name can't be blank") @Length(min = 3, max = 20, message = "Invalid Last Name length!!!!") String lastName,
			@NotEmpty(message = "email must be supplied") String email,
			@NotEmpty(message = "password must be supplied") String password, String confirmPassword, String locality,
			String city, String state, int zipCode, int phone, UserRole role) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.locality = locality;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.phone = phone;
		this.role = role;
	} 
	

}
