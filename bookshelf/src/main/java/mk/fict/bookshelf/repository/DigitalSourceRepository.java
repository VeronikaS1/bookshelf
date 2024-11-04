package mk.fict.bookshelf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mk.fict.bookshelf.domain.DigitalSource;
@Repository
public interface DigitalSourceRepository extends JpaRepository<DigitalSource, Integer> {

}
