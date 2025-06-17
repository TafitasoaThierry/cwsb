package test.th.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Hello")
@Getter
@Setter
public class Hello {
	@Id
	private Long a;
	private int x;
	private int y;
	private String b;
}
