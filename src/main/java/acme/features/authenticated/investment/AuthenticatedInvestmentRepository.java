
package acme.features.authenticated.investment;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.investment.Investment;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedInvestmentRepository extends AbstractRepository {

	@Query("select n from Investment n where n.id = ?1")
	Investment findOneById(int id);

	@Query("select n from Investment n")
	Collection<Investment> findManyAll();

	@Query("select n from Investment n where n.mode = 'FINAL'")
	Collection<Investment> findFinal();

}
