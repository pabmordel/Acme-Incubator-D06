
package acme.features.entrepreneur.investment;

import java.util.Calendar;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.activity.Activity;
import acme.entities.investment.Investment;
import acme.entities.roles.Entrepreneur;
import acme.entities.spamlist.Spamlist;
import acme.entities.spamword.Spamword;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractUpdateService;

@Service
public class EntrepreneurInvestmentUpdateService implements AbstractUpdateService<Entrepreneur, Investment> {

	@Autowired
	EntrepreneurInvestmentRepository repository;


	@Override
	public boolean authorise(final Request<Investment> request) {
		assert request != null;
		int principalId = request.getPrincipal().getActiveRoleId();

		int invId = request.getModel().getInteger("id");
		Investment i = this.repository.findOneById(invId);

		boolean result;
		result = i.getEntrepreneur().getId() == principalId;
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

		request.unbind(entity, model, "ticket", "kind", "title", "description", "amount", "link", "programme", "mode");
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

	@Override
	public void validate(final Request<Investment> request, final Investment entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		if (entity.getAmount() != null) {
			errors.state(request, entity.getAmount().getCurrency().contains("€"), "amount", "acme.validation.money");
		}

		if (entity.getMode() != null) {
			errors.state(request, entity.getMode().equals("PRIVATE") || entity.getMode().equals("FINAL") && entity.finalMode() == true, "mode", "acme.validation.mode");
		}

		Boolean ENSPAM, ESSPAM;
		String text = request.getModel().getString("title") + " " + request.getModel().getString("description");
		Spamlist ENList = this.repository.findSpamList("EN");
		Spamlist ESList = this.repository.findSpamList("ES");

		ENSPAM = this.isSpam(text, ENList, entity);
		ESSPAM = this.isSpam(text, ESList, entity);

		if (entity.getMode() != null) {
			errors.state(request, entity.getMode().equals("PRIVATE") || entity.getMode().equals("FINAL") && !ENSPAM || entity.getMode().equals("FINAL") && !ESSPAM, "reference", "acme.validation.spamm");
			//errors.state(request, entity.getMode().equals("PRIVATE"), "reference", "acme.validation.spamm");
		}

		int id = request.getModel().getInteger("id");
		Collection<Activity> col = this.repository.findInvestmentActivities(id);
		int size = col.size();

		if (entity.getMode() != null) {
			errors.state(request, entity.getMode().equals("PRIVATE") || entity.getMode().equals("FINAL") && size > 0, "mode", "acme.validation.noact");
		}

		Long size2 = entity.getTicket().chars().asDoubleStream().count();

		if (entity.getTicket() != null) {
			errors.state(request, size2 > 12, "ticket", "acme.validation.ticketsize");
		}

		int entid = request.getPrincipal().getActiveRoleId();
		Entrepreneur ent = this.repository.findEntrepreneurById(entid);
		Long sectorsize = ent.getSector().chars().asDoubleStream().count();

		if (size2 > 12) {

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
	public void update(final Request<Investment> request, final Investment entity) {
		assert request != null;
		assert entity != null;
		this.repository.save(entity);
	}

	private Boolean isSpam(final String text, final Spamlist list, final Investment entity) {

		Collection<Spamword> spamwords = list.getSpamwordslist();

		Double numSpamWords = 0.;

		for (Spamword s : spamwords) {
			String spamword = s.getSpamword();
			numSpamWords = numSpamWords + this.numDeSpamwords(text.toLowerCase(), spamword, 0.);
		}

		return numSpamWords / 100 > list.getThreshold();
	}

	private Double numDeSpamwords(final String text, final String spamword, final Double thres) {
		if (!text.contains(spamword)) {
			return thres;
		} else {
			Integer count = text.indexOf(spamword);
			return this.numDeSpamwords(text.substring(count + 1), spamword, thres + 1);
		}
	}

}
