
package acme.features.authenticated.inquiry;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.inquiry.Inquiry;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedInquiryRepository extends AbstractRepository {

	@Query("select n from Inquiry n where n.id = ?1")
	Inquiry findOneById(int id);

	@Query("select n from Inquiry n where now()<=n.deadline")
	Collection<Inquiry> findManyAll();

}
