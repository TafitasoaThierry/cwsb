package com.x.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "X")
@Getter
@Setter
public class X {
	@Id
	private float x;
	private float y;
	private String shape;
}
