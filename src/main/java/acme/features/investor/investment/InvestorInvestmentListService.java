
package acme.features.investor.investment;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.investment.Investment;
import acme.entities.roles.Investor;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractListService;

@Service
public class InvestorInvestmentListService implements AbstractListService<Investor, Investment> {

	@Autowired
	InvestorInvestmentRepository repository;


	@Override
	public boolean authorise(final Request<Investment> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final Request<Investment> request, final Investment entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "creationdate", "kind", "amount");

	}

	@Override
	public Collection<Investment> findMany(final Request<Investment> request) {
		assert request != null;
		Collection<Investment> investmentlist;
		investmentlist = this.repository.findFinal();

		return investmentlist;
	}

}
