
package acme.features.entrepreneur.application;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.application.Application;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface EntrepreneurApplicationRepository extends AbstractRepository {

	@Query("select n from Application n where n.id = ?1")
	Application findOneById(int id);

	@Query("select n from Application n")
	Collection<Application> findManyAll();

	@Query("select n from Application n where n.investment.entrepreneur.id = ?1")
	Collection<Application> findMyAll(int id);

	@Query("select n from Application n where n.investment.entrepreneur.id = ?1 order by n.ticket asc")
	Collection<Application> findMyAllByTicket(int id);

	@Query("select n from Application n where n.investment.entrepreneur.id = ?1 order by n.creationdate desc")
	Collection<Application> findMyAllByDate(int id);

}
