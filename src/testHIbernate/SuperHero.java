package testHIbernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity

public class SuperHero extends AbstractEntity {


//	@NotEmpty

	@Column(unique = true)

	public String name;

	@ManyToOne

//	@NotNull

	public SuperPower power;

//	@NotEmpty

	public String weakness;

//	@NotEmpty

	public String secretIdentity;

}
