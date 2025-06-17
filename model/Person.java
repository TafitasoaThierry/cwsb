package com.ht.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Person")
@Getter
@Setter
public class Person {
	@Id
	private Long id;
	private String name;
	private String surname;
	private int age;
	private String adress;
}
