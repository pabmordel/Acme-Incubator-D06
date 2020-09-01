
package acme.features.investor.application;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.application.Application;
import acme.entities.investment.Investment;
import acme.entities.roles.Investor;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractCreateService;

@Service
public class InvestorApplicationCreateService implements AbstractCreateService<Investor, Application> {

	@Autowired
	InvestorApplicationRepository repository;


	@Override
	public boolean authorise(final Request<Application> request) {
		assert request != null;

		boolean result;

		int invId = request.getModel().getInteger("id");
		Investment inv = this.repository.findInvestmentById(invId);
		result = inv.getMode().equals("FINAL");

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

		request.unbind(entity, model, "ticket", "statement", "offer");

		model.setAttribute("id", request.getServletRequest().getParameter("id"));

	}

	@Override
	public Application instantiate(final Request<Application> request) {
		Application result = new Application();

		result.setCreationdate(new Date(System.currentTimeMillis() - 1));
		result.setStatus("PENDING");
		result.setJustification("");

		Investor inv = this.repository.findInvestorById(request.getPrincipal().getActiveRoleId());
		result.setInvestor(inv);

		String investmentid = request.getServletRequest().getParameter("id");
		Investment invest = this.repository.findInvestmentById(Integer.parseInt(investmentid));
		result.setInvestment(invest);

		return result;
	}

	@Override
	public void validate(final Request<Application> request, final Application entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		if (entity.getOffer() != null) {
			errors.state(request, entity.getOffer().getCurrency().contains("€"), "amount", "acme.validation.money");
		}

		Long size = entity.getTicket().chars().asDoubleStream().count();

		if (entity.getTicket() != null) {
			errors.state(request, size > 12, "ticket", "acme.validation.ticketsize");
		}

		int invid = request.getPrincipal().getActiveRoleId();
		Investor inv = this.repository.findInvestorById(invid);
		Long sectorsize = inv.getSector().chars().asDoubleStream().count();

		if (size > 12) {

			if (sectorsize == 1) {
				String a0 = String.valueOf(entity.getTicket().charAt(0));
				String a1 = String.valueOf(entity.getTicket().charAt(1));
				String a2 = String.valueOf(entity.getTicket().charAt(2));
				String b0 = String.valueOf(inv.getSector().charAt(0)).toUpperCase();

				int yea = Calendar.getInstance().get(Calendar.YEAR);
				String year = String.valueOf(yea);

				String y0 = String.valueOf(entity.getTicket().charAt(4));
				String y1 = String.valueOf(entity.getTicket().charAt(5));
				String z0 = String.valueOf(year.charAt(2));
				String z1 = String.valueOf(year.charAt(3));

				if (entity.getTicket() != null) {
					errors.state(request, a0.equals(b0) && a1.equals("X") && a2.equals("X") && y0.equals(z0) && y1.equals(z1), "ticket", "acme.validation.ticket1");
				}
			}

			if (sectorsize == 2) {
				String a0 = String.valueOf(entity.getTicket().charAt(0));
				String a1 = String.valueOf(entity.getTicket().charAt(1));
				String a2 = String.valueOf(entity.getTicket().charAt(2));
				String b0 = String.valueOf(inv.getSector().charAt(0)).toUpperCase();
				String b1 = String.valueOf(inv.getSector().charAt(1)).toUpperCase();

				int yea = Calendar.getInstance().get(Calendar.YEAR);
				String year = String.valueOf(yea);

				String y0 = String.valueOf(entity.getTicket().charAt(4));
				String y1 = String.valueOf(entity.getTicket().charAt(5));
				String z0 = String.valueOf(year.charAt(2));
				String z1 = String.valueOf(year.charAt(3));

				if (entity.getTicket() != null) {
					errors.state(request, a0.equals(b0) && a1.equals(b1) && a2.equals("X") && y0.equals(z0) && y1.equals(z1), "ticket", "acme.validation.ticket2");
				}
			}

			if (sectorsize > 2) {

				String a0 = String.valueOf(entity.getTicket().charAt(0));
				String a1 = String.valueOf(entity.getTicket().charAt(1));
				String a2 = String.valueOf(entity.getTicket().charAt(2));
				String b0 = String.valueOf(inv.getSector().charAt(0)).toUpperCase();
				String b1 = String.valueOf(inv.getSector().charAt(1)).toUpperCase();
				String b2 = String.valueOf(inv.getSector().charAt(2)).toUpperCase();

				int yea = Calendar.getInstance().get(Calendar.YEAR);
				String year = String.valueOf(yea);

				String y0 = String.valueOf(entity.getTicket().charAt(4));
				String y1 = String.valueOf(entity.getTicket().charAt(5));
				String z0 = String.valueOf(year.charAt(2));
				String z1 = String.valueOf(year.charAt(3));

				if (entity.getTicket() != null) {
					errors.state(request, a0.equals(b0) && a1.equals(b1) && a2.equals(b2) && y0.equals(z0) && y1.equals(z1), "ticket", "acme.validation.ticket");
				}
			}
		}

	}

	@Override
	public void create(final Request<Application> request, final Application entity) {
		this.repository.save(entity);
	}

}
