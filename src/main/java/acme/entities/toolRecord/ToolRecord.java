
package acme.entities.toolRecord;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.URL;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class ToolRecord extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	//Atributes

	@NotBlank
	private String				title;

	@NotBlank
	private String				sector;

	@NotBlank
	private String				inventor;

	@NotBlank
	private String				description;

	@NotBlank
	@URL
	private String				web;

	@NotBlank
	@Email
	private String				email;

	@NotBlank
	@Pattern(regexp = "OPEN|CLOSED")
	private String				source;

	@Range(min = -5, max = 5)
	private Integer				stars;

}
