
package acme.features.anonymous.technologyRecord;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.technologyRecord.TechnologyRecord;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractListService;

@Service
public class AnonymousTechnologyRecordListBySectorService implements AbstractListService<Anonymous, TechnologyRecord> {

	@Autowired
	AnonymousTechnologyRecordRepository repository;


	@Override
	public boolean authorise(final Request<TechnologyRecord> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final Request<TechnologyRecord> request, final TechnologyRecord entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "sector", "source", "stars");

	}

	@Override
	public Collection<TechnologyRecord> findMany(final Request<TechnologyRecord> request) {
		assert request != null;
		Collection<TechnologyRecord> techlist;
		techlist = this.repository.findManyBySector();

		return techlist;
	}

}
