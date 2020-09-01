
package acme.entities.application;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import acme.entities.investment.Investment;
import acme.entities.roles.Investor;
import acme.framework.datatypes.Money;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Application extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	//Attributes

	@NotBlank
	@Pattern(regexp = "[A-Z\\d]{3}-[0-9]{2}\\-[0-9]{6}")
	private String				ticket;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date				creationdate;

	@NotBlank
	private String				statement;

	@NotNull
	@Valid
	private Money				offer;

	@NotBlank
	@Pattern(regexp = "ACCEPTED|REJECTED|PENDING")
	private String				status;

	private String				justification;

	//Relationships

	@ManyToOne(optional = false)
	private Investor			investor;

	@ManyToOne(optional = false)
	private Investment			investment;

}
