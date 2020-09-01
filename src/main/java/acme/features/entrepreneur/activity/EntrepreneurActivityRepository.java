
package acme.features.entrepreneur.activity;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.activity.Activity;
import acme.entities.investment.Investment;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface EntrepreneurActivityRepository extends AbstractRepository {

	@Query("select n from Activity n where n.id = ?1")
	Activity findOneById(int id);

	@Query("select n from Activity n where n.investment.id = ?1")
	Collection<Activity> findManyAll(int id);

	@Query("select n from Investment n where n.id = ?1")
	Investment findInvestmentById(int id);

}
