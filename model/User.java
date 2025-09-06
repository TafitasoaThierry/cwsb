package com.usermanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "User")
@Getter
@Setter
public class User {
	@Id
	private Long userId;
	private String name;
	private String surname;
	private String adress;
	private int age;
}
