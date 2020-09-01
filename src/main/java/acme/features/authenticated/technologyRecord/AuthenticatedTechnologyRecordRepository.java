
package acme.features.authenticated.technologyRecord;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.technologyRecord.TechnologyRecord;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedTechnologyRecordRepository extends AbstractRepository {

	@Query("select n from TechnologyRecord n where n.id = ?1")
	TechnologyRecord findOneById(int id);

	@Query("select n from TechnologyRecord n")
	Collection<TechnologyRecord> findManyAll();

	@Query("select n from TechnologyRecord n order by n.stars desc")
	Collection<TechnologyRecord> findManyByStars();

	@Query("select n from TechnologyRecord n order by n.sector asc")
	Collection<TechnologyRecord> findManyBySector();
}
