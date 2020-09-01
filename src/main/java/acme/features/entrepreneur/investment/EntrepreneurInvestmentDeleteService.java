
package acme.features.entrepreneur.investment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.investment.Investment;
import acme.entities.roles.Entrepreneur;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractDeleteService;

@Service
public class EntrepreneurInvestmentDeleteService implements AbstractDeleteService<Entrepreneur, Investment> {

	@Autowired
	EntrepreneurInvestmentRepository repository;


	@Override
	public boolean authorise(final Request<Investment> request) {
		assert request != null;

		int principalId = request.getPrincipal().getActiveRoleId();

		int invId = request.getModel().getInteger("id");
		Investment i = this.repository.findOneById(invId);

		boolean result;
		result = i.getEntrepreneur().getId() == principalId && !i.hasApp();

		return result;
	}

	@Override
	public void bind(final Request<Investment> request, final Investment entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<Investment> request, final Investment entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "ticket", "creationdate", "kind", "title", "description", "amount", "link", "programme");
	}

	@Override
	public Investment findOne(final Request<Investment> request) {
		assert request != null;

		Investment result = null;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);

		return result;
	}

	@Override
	public void validate(final Request<Investment> request, final Investment entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
	}

	@Override
	public void delete(final Request<Investment> request, final Investment entity) {
		assert request != null;
		assert entity != null;

		this.repository.deleteActivity(entity.getId());
		this.repository.delete(entity);
	}

}
