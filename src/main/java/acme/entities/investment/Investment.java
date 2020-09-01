
package acme.entities.investment;

import java.beans.Transient;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.validator.constraints.URL;

import acme.entities.activity.Activity;
import acme.entities.application.Application;
import acme.entities.roles.Entrepreneur;
import acme.framework.datatypes.Money;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Investment extends DomainEntity {

	private static final long		serialVersionUID	= 1L;

	//Attributes

	@NotBlank			//falta el patron
	@Pattern(regexp = "[A-Z\\d]{3}-[0-9]{2}\\-[0-9]{6}")
	private String					ticket;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date					creationdate;

	@NotBlank
	@Pattern(regexp = "SEED|ANGEL|SERIES-A|SERIES-B|SERIES-C|BRIDGE")
	private String					kind;

	@NotBlank
	private String					title;

	@NotBlank
	private String					description;

	@NotNull
	@Valid
	private Money					amount;

	@URL
	private String					link;

	@NotBlank
	@Pattern(regexp = "PRIVATE|FINAL")
	private String					mode;

	//Relationships

	@OneToMany(mappedBy = "investment", fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	private Collection<Activity>	programme;

	@ManyToOne(optional = false)
	private Entrepreneur			entrepreneur;

	@OneToMany(mappedBy = "investment")
	@LazyCollection(LazyCollectionOption.FALSE)
	private Collection<Application>	applications;


	@Transient
	public boolean finalMode() {
		boolean res = true;
		Double amo = 0.;
		for (Activity a : this.programme) {
			Double n = a.getBudget().getAmount();
			amo = amo + n;
		}

		res = amo.intValue() == this.amount.getAmount().intValue() && this.mode.equals("FINAL");
		return res;
	}

	@Transient
	public boolean hasApp() {
		boolean res = true;
		Integer apps = this.applications.size();
		res = apps > 0;
		return res;
	}

}
