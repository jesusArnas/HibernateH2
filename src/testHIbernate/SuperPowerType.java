package testHIbernate;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity

public class SuperPowerType extends AbstractEntity {


//	@NotEmpty

	@Column(unique = true)

	public String name;

//	@NotNull

//	@Length(min = 30)

	public String description;

}
