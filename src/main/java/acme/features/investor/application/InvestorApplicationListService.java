
package acme.features.investor.application;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.application.Application;
import acme.entities.roles.Investor;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractListService;

@Service
public class InvestorApplicationListService implements AbstractListService<Investor, Application> {

	@Autowired
	InvestorApplicationRepository repository;


	@Override
	public boolean authorise(final Request<Application> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final Request<Application> request, final Application entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "offer", "creationdate");

		model.setAttribute("investment-title", entity.getInvestment().getTitle());

	}

	@Override
	public Collection<Application> findMany(final Request<Application> request) {
		assert request != null;
		Collection<Application> applist;
		int id = request.getPrincipal().getActiveRoleId();
		applist = this.repository.findMyAll(id);

		return applist;
	}

}
