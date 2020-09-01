
package acme.features.entrepreneur.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.application.Application;
import acme.entities.roles.Entrepreneur;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractUpdateService;

@Service
public class EntrepreneurApplicationUpdateService implements AbstractUpdateService<Entrepreneur, Application> {

	@Autowired
	EntrepreneurApplicationRepository repository;


	@Override
	public boolean authorise(final Request<Application> request) {
		assert request != null;
		int principalId = request.getPrincipal().getActiveRoleId();

		int appId = request.getModel().getInteger("id");
		Application a = this.repository.findOneById(appId);

		boolean result;
		result = a.getInvestment().getEntrepreneur().getId() == principalId;
		return result;
	}

	@Override
	public void bind(final Request<Application> request, final Application entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<Application> request, final Application entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "ticket", "creationdate", "statement", "offer", "status", "justification");

		model.setAttribute("investment-title", entity.getInvestment().getTitle());
		model.setAttribute("investor-firm", entity.getInvestor().getFirm());
	}

	@Override
	public Application findOne(final Request<Application> request) {
		assert request != null;

		Application result;
		int id;
		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);
		return result;
	}

	@Override
	public void validate(final Request<Application> request, final Application entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		if (entity.getStatus() != null) {
			errors.state(request, entity.getStatus().equals("PENDING") || entity.getStatus().equals("ACCEPTED") || entity.getStatus().equals("REJECTED") && !entity.getJustification().isEmpty(), "justification", "acme.validation.just");
		}
	}

	@Override
	public void update(final Request<Application> request, final Application entity) {
		assert request != null;
		assert entity != null;
		this.repository.save(entity);
	}

}
