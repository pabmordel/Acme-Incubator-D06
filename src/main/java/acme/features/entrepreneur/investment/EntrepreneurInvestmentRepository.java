
package acme.features.entrepreneur.investment;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.activity.Activity;
import acme.entities.investment.Investment;
import acme.entities.roles.Entrepreneur;
import acme.entities.spamlist.Spamlist;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface EntrepreneurInvestmentRepository extends AbstractRepository {

	@Query("select n from Investment n where n.id = ?1")
	Investment findOneById(int id);

	@Query("select n from Investment n")
	Collection<Investment> findManyAll();

	@Query("select n from Investment n where n.entrepreneur.id = ?1")
	Collection<Investment> findMyAll(int id);

	@Query("select n from Entrepreneur n where n.id = ?1")
	Entrepreneur findEntrepreneurById(int id);

	@Transactional
	@Modifying
	@Query("delete from Activity a where a.investment.id = ?1")
	void deleteActivity(int id);

	@Query("select n from Spamlist n where n.idiom = ?1")
	Spamlist findSpamList(String idiom);

	@Query("select n from Activity n where n.investment.id = ?1")
	Collection<Activity> findInvestmentActivities(int id);
}
