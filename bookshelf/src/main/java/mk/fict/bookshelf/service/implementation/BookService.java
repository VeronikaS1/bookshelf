package mk.fict.bookshelf.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import mk.fict.bookshelf.domain.Book;
import mk.fict.bookshelf.exception.ResourceNotFoundException;
import mk.fict.bookshelf.repository.BookRepository;
import mk.fict.bookshelf.service.Service;

@org.springframework.stereotype.Service
public class BookService implements Service<Book, Integer> {

	@Autowired
	private BookRepository brepo;

	@Override
	public List<Book> findAll() {
		if (brepo.findAll().isEmpty()) {
			throw new ResourceNotFoundException("Entity Book is empty");
		}
		return brepo.findAll();
	}

	@Override
	public Book findById(Integer id) {
		Optional<Book> book = brepo.findById(id);
		if (brepo.findById(id).isPresent()) {
			return book.get();
		}
		throw new ResourceNotFoundException("Book with id: " + id + " is not present");
	}

	@Override
	public Book create(Book entity) {

		return brepo.save(entity);
	}

	@Override
	public Book update(Integer id, Book entity) {
		if (brepo.findById(id).isPresent()) {
			entity.setId(id);
			return brepo.save(entity);
		}

		throw new ResourceNotFoundException("Book with id: " + id + " is not present");

	}

	@Override
	public void deleteById(Integer id) {
		if (brepo.findById(id).isEmpty()) {
			throw new ResourceNotFoundException("Book with id: " + id + " is not present");
		}
		brepo.deleteById(id);

	}

	public Book findByIsbn(String isbn) {

		return brepo.findByIsbn(isbn);
	}

}
