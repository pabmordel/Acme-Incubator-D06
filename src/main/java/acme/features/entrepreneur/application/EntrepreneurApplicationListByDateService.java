
package acme.features.entrepreneur.application;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.application.Application;
import acme.entities.roles.Entrepreneur;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractListService;

@Service
public class EntrepreneurApplicationListByDateService implements AbstractListService<Entrepreneur, Application> {

	@Autowired
	EntrepreneurApplicationRepository repository;


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

		request.unbind(entity, model, "offer", "creationdate", "ticket");

		model.setAttribute("investment-title", entity.getInvestment().getTitle());

	}

	@Override
	public Collection<Application> findMany(final Request<Application> request) {
		assert request != null;
		Collection<Application> applist;
		int id = request.getPrincipal().getActiveRoleId();
		applist = this.repository.findMyAllByDate(id);

		return applist;
	}

}
