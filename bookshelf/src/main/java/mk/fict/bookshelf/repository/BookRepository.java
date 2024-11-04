package mk.fict.bookshelf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import mk.fict.bookshelf.domain.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

	public Book findByIsbn(String isbn);

}
