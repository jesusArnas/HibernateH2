package testHIbernate;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

@MappedSuperclass

public class AbstractEntity {


	@SuppressWarnings("unused")

	@Id

	@GeneratedValue

	public Long id;

	@SuppressWarnings("unused")

	@Version

	private Long version;

}