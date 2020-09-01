
package acme.features.administrator.inquiry;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.inquiry.Inquiry;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractCreateService;

@Service
public class AdministratorInquiryCreateService implements AbstractCreateService<Administrator, Inquiry> {

	@Autowired
	AdministratorInquiryRepository repository;


	@Override
	public boolean authorise(final Request<Inquiry> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<Inquiry> request, final Inquiry entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<Inquiry> request, final Inquiry entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "deadline", "description", "intervalmin", "intervalmax", "email");
	}

	@Override
	public Inquiry instantiate(final Request<Inquiry> request) {
		Inquiry result;

		result = new Inquiry();

		result.setCreationdate(new Date(System.currentTimeMillis() - 1));

		return result;
	}

	@Override
	public void validate(final Request<Inquiry> request, final Inquiry entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		if (!errors.hasErrors("deadline")) {
			Date now = new Date(System.currentTimeMillis());
			if (entity.getDeadline() == null) {
				errors.state(request, true, "deadline", "javax.validation.constraints.NotBlank.message");
			} else if (entity.getDeadline() != null) {
				errors.state(request, entity.getDeadline().after(now), "deadline", "acme.validation.deadline");
			}
		}

		if (entity.getIntervalmin() != null) {
			errors.state(request, entity.getIntervalmin().getCurrency().contains("€"), "intervalmin", "acme.validation.money");
		}

		if (entity.getIntervalmax() != null) {
			errors.state(request, entity.getIntervalmax().getCurrency().contains("€"), "intervalmax", "acme.validation.money");
		}

	}

	@Override
	public void create(final Request<Inquiry> request, final Inquiry entity) {
		this.repository.save(entity);
	}

}
