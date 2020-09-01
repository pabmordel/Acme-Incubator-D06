
package acme.features.entrepreneur.activity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.activity.Activity;
import acme.entities.investment.Investment;
import acme.entities.roles.Entrepreneur;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractCreateService;

@Service
public class EntrepreneurActivityCreateService implements AbstractCreateService<Entrepreneur, Activity> {

	@Autowired
	EntrepreneurActivityRepository repository;


	@Override
	public boolean authorise(final Request<Activity> request) {
		assert request != null;

		int principalId = request.getPrincipal().getActiveRoleId();

		int invId = request.getModel().getInteger("id");
		Investment i = this.repository.findInvestmentById(invId);

		boolean result;
		result = i.getEntrepreneur().getId() == principalId && i.getMode().equals("PRIVATE");

		return result;
	}

	@Override
	public void bind(final Request<Activity> request, final Activity entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<Activity> request, final Activity entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "startdate", "enddate", "budget");

		model.setAttribute("id", request.getServletRequest().getParameter("id"));
	}

	@Override
	public Activity instantiate(final Request<Activity> request) {
		Activity result;

		result = new Activity();

		String investmentid = request.getServletRequest().getParameter("id");

		Investment inv = this.repository.findInvestmentById(Integer.parseInt(investmentid));

		result.setInvestment(inv);

		return result;
	}

	@Override
	public void validate(final Request<Activity> request, final Activity entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		if (entity.getBudget() != null) {
			errors.state(request, entity.getBudget().getCurrency().contains("€"), "budget", "acme.validation.money");
		}

	}

	@Override
	public void create(final Request<Activity> request, final Activity entity) {

		String investmentid = request.getServletRequest().getParameter("id");

		Investment inv = this.repository.findInvestmentById(Integer.parseInt(investmentid));

		entity.setInvestment(inv);
		this.repository.save(entity);
	}

}
