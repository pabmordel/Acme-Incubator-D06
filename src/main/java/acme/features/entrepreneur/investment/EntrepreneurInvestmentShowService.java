
package acme.features.entrepreneur.investment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.investment.Investment;
import acme.entities.roles.Entrepreneur;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;

@Service
public class EntrepreneurInvestmentShowService implements AbstractShowService<Entrepreneur, Investment> {

	@Autowired
	private EntrepreneurInvestmentRepository repository;


	@Override
	public boolean authorise(final Request<Investment> request) {
		assert request != null;
		boolean result;

		int invId = request.getModel().getInteger("id");
		Investment inv = this.repository.findOneById(invId);
		Entrepreneur ent = inv.getEntrepreneur();
		Principal principal = request.getPrincipal();
		result = ent.getUserAccount().getId() == principal.getAccountId();

		return result;
	}

	@Override
	public void unbind(final Request<Investment> request, final Investment entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "ticket", "creationdate", "kind", "title", "description", "amount", "link", "programme", "mode");

		model.setAttribute("finalMode", entity.finalMode());
		model.setAttribute("hasApp", entity.hasApp());
	}

	@Override
	public Investment findOne(final Request<Investment> request) {
		assert request != null;
		Investment result;
		int id;
		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);
		return result;
	}

}
