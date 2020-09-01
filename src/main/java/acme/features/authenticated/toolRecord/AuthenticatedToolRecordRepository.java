
package acme.features.authenticated.toolRecord;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.toolRecord.ToolRecord;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedToolRecordRepository extends AbstractRepository {

	@Query("select n from ToolRecord n where n.id = ?1")
	ToolRecord findOneById(int id);

	@Query("select n from ToolRecord n")
	Collection<ToolRecord> findManyAll();

	@Query("select n from ToolRecord n order by n.stars desc")
	Collection<ToolRecord> findManyByStars();

	@Query("select n from ToolRecord n order by n.sector asc")
	Collection<ToolRecord> findManyBySector();

}
