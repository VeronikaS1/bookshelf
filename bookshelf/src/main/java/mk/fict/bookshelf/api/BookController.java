package mk.fict.bookshelf.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import mk.fict.bookshelf.domain.Book;
import mk.fict.bookshelf.infrastructure.Endpoints;
import mk.fict.bookshelf.service.implementation.BookService;

@CrossOrigin
@RestController
@RequestMapping(Endpoints.BOOKS)
public class BookController {

	@Autowired
	private BookService bs;

	@GetMapping
	public List<Book> findAll() {
		return bs.findAll();
	}

	@GetMapping("/{id}")
	public Book findById(@PathVariable(value = "id") Integer id) {
		return bs.findById(id);
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public Book create(@RequestBody Book entity) {
		return bs.create(entity);

	}

	@PutMapping("/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public Book update(@PathVariable(value = "id", required = true) Integer id, @RequestBody Book entity) {
		return bs.update(id, entity);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable(value = "id", required = true) Integer id) {
		bs.deleteById(id);
	}

	@GetMapping("/isbn/{isbn}")
	public Book findByIsbn(@PathVariable(value = "isbn") String isbn) {
		return bs.findByIsbn(isbn);
	}

}
