package nn.tets.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Kaka")
@Getter
@Setter
public class Kaka {
	@Id
	private Long a;
	private int b;
	private String c;
}
