
package acme.features.entrepreneur.investment;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.investment.Investment;
import acme.entities.roles.Entrepreneur;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractCreateService;

@Service
public class EntrepreneurInvestmentCreateService implements AbstractCreateService<Entrepreneur, Investment> {

	@Autowired
	EntrepreneurInvestmentRepository repository;


	@Override
	public boolean authorise(final Request<Investment> request) {
		assert request != null;

		return true;
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

		request.unbind(entity, model, "ticket", "kind", "title", "description", "amount", "link", "programme");
	}

	@Override
	public Investment instantiate(final Request<Investment> request) {
		Investment result;
		Entrepreneur ent = this.repository.findEntrepreneurById(request.getPrincipal().getActiveRoleId());

		result = new Investment();
		result.setCreationdate(new Date(System.currentTimeMillis() - 1));
		result.setEntrepreneur(ent);
		result.setMode("PRIVATE");

		return result;
	}

	@Override
	public void validate(final Request<Investment> request, final Investment entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		if (entity.getAmount() != null) {
			errors.state(request, entity.getAmount().getCurrency().contains("€"), "amount", "acme.validation.money");
		}

		Long size = entity.getTicket().chars().asDoubleStream().count();

		if (entity.getTicket() != null) {
			errors.state(request, size > 12, "ticket", "acme.validation.ticketsize");
		}

		int entid = request.getPrincipal().getActiveRoleId();
		Entrepreneur ent = this.repository.findEntrepreneurById(entid);
		Long sectorsize = ent.getSector().chars().asDoubleStream().count();

		if (size > 12) {

			if (sectorsize == 1) {
				String a0 = String.valueOf(entity.getTicket().charAt(0));
				String a1 = String.valueOf(entity.getTicket().charAt(1));
				String a2 = String.valueOf(entity.getTicket().charAt(2));
				String b0 = String.valueOf(ent.getSector().charAt(0)).toUpperCase();

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
				String b0 = String.valueOf(ent.getSector().charAt(0)).toUpperCase();
				String b1 = String.valueOf(ent.getSector().charAt(1)).toUpperCase();

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
				String b0 = String.valueOf(ent.getSector().charAt(0)).toUpperCase();
				String b1 = String.valueOf(ent.getSector().charAt(1)).toUpperCase();
				String b2 = String.valueOf(ent.getSector().charAt(2)).toUpperCase();

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
	public void create(final Request<Investment> request, final Investment entity) {
		this.repository.save(entity);
	}

}
