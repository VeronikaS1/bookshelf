package mk.fict.bookshelf.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import mk.fict.bookshelf.domain.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

	public List<Author> findByFirstName(String firstName);
}
