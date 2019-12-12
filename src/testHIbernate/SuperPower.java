package testHIbernate;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;


@Entity

public class SuperPower extends AbstractEntity implements Serializable {


//	@NotEmpty

	@Column(unique = true)

	public String name;

//	@NotEmpty

	public String description;

//	@NotNull

	@ManyToOne

	public SuperPowerType type;

}
