package mk.fict.bookshelf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import mk.fict.bookshelf.domain.Publisher;
@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Integer> {

	
	@Query("SELECT p FROM Publisher p WHERE p.name = ?1")
	public Publisher findPublisherByName(String name);
}
