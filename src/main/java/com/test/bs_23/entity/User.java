package com.test.bs_23.entity;


import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Project   candle
 * @Author    Md. Afrail Hossain
 * @Since     jan 21, 2024
 * @version   1.0.0
 */


@Data
@Entity
@Table(name = "USER_INFO")
public class User implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer id;

	@Column(name = "ACTIVE", columnDefinition = "boolean default true")
	private Boolean active = true;

	@SuppressWarnings("unused")
	private static final Logger LOG = LoggerFactory.getLogger(User.class);
	
	@Column(name = "USERNAME", length=50, nullable = false, unique = true)
	private String username;
	
	@Column(name = "PASSWORD", nullable = false)
	private String password;
	
	@Column(name = "EMAIL", length=100)
	private String email;
	
	@Column(name = "MOBILE", length=20)
	private String mobile;

	@Column(name = "EMPLOYEE_CODE", length=50)
	private String employeeCode;

	@Column(name = "NAME", length=100)
	private String name;

	@Column(name = "BANGLA_NAME", length=100)
	private String banglaName;

	@Column(name = "DESIGNATION", length=100)
	private String designation;

	@Column(name = "IS_ACCOUNT_EXPIRED", columnDefinition = "boolean default false")
	private Boolean accountExpired = false;

	@Column(name = "IS_CREDENTIALS_EXPIRED", columnDefinition = "boolean default false")
	private Boolean credentialsExpired = false;

	@Column(name = "IS_ACCOUNT_LOCKED", columnDefinition = "boolean default false")
	private Boolean accountLocked = false;
	
	
}
