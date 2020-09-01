
package acme.entities.overture;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import acme.framework.datatypes.Money;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class Overture extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	//Atributes

	@NotBlank
	private String				title;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date				creationdate;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date				deadline;

	@NotBlank
	@Length(min = 20)
	private String				description;

	@NotNull
	@Valid
	private Money				intervalmin;

	@NotNull
	@Valid
	private Money				intervalmax;

	@NotBlank
	@Email
	private String				email;

}
