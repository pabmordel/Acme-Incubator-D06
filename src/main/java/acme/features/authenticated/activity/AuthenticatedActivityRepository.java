
package acme.features.authenticated.activity;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.activity.Activity;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedActivityRepository extends AbstractRepository {

	@Query("select n from Activity n where n.id = ?1")
	Activity findOneById(int id);

	@Query("select n from Activity n where n.investment.id = ?1")
	Collection<Activity> findManyAll(int id);

}
