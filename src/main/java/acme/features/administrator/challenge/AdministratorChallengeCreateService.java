
package acme.features.administrator.challenge;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.challenge.Challenge;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractCreateService;

@Service
public class AdministratorChallengeCreateService implements AbstractCreateService<Administrator, Challenge> {

	@Autowired
	AdministratorChallengeRepository repository;


	@Override
	public boolean authorise(final Request<Challenge> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<Challenge> request, final Challenge entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<Challenge> request, final Challenge entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "deadline", "description", "rookie", "average", "expert", "rookiereward", "averagereward", "expertreward");
	}

	@Override
	public Challenge instantiate(final Request<Challenge> request) {
		Challenge result;

		result = new Challenge();

		return result;
	}

	@Override
	public void validate(final Request<Challenge> request, final Challenge entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		if (!errors.hasErrors("deadline")) {
			LocalDate now = LocalDate.now();
			Calendar calendarmin = new GregorianCalendar();

			if (now.getMonthValue() != 12) {
				calendarmin.set(now.getYear(), now.getMonthValue(), now.getDayOfMonth() - 1);
			} else {
				calendarmin.set(now.getYear() + 1, 1, now.getDayOfMonth() - 1);
			}

			Date mindeadline = calendarmin.getTime();

			if (entity.getDeadline() == null) {
				errors.state(request, true, "deadline", "javax.validation.constraints.NotBlank.message");
			} else if (entity.getDeadline() != null) {
				errors.state(request, entity.getDeadline().after(mindeadline), "deadline", "acme.validation.deadline.challenge");
			}
		}

		if (entity.getAveragereward() != null) {
			errors.state(request, entity.getAveragereward().getCurrency().contains("€"), "averagereward", "acme.validation.money");
		}

		if (entity.getExpertreward() != null) {
			errors.state(request, entity.getExpertreward().getCurrency().contains("€"), "expertreward", "acme.validation.money");
		}

		if (entity.getRookiereward() != null) {
			errors.state(request, entity.getRookiereward().getCurrency().contains("€"), "rookiereward", "acme.validation.money");
		}

	}

	@Override
	public void create(final Request<Challenge> request, final Challenge entity) {
		this.repository.save(entity);
	}

}
