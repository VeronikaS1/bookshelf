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

import mk.fict.bookshelf.domain.Author;
import mk.fict.bookshelf.infrastructure.Endpoints;
import mk.fict.bookshelf.service.implementation.AuthorService;

@CrossOrigin
@RestController
@RequestMapping(Endpoints.AUTHORS)
public class AuthorController {

	@Autowired
	AuthorService as;

	@GetMapping
	public List<Author> findAll() {
		return as.findAll();
	}

	@GetMapping("/{id}")
	public Author findById(@PathVariable(value = "id") Integer id) {
		return as.findById(id);
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public Author create(@RequestBody Author entity) {

		return as.create(entity);

	}

	@PutMapping("/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public Author update(@PathVariable(value = "id", required = true) Integer id, @RequestBody Author entity) {
		return as.update(id, entity);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable(value = "id", required = true) Integer id) {
		as.deleteById(id);
	}
	
	@GetMapping("/firstname/{firstName}")
	public List<Author> findByFirstName(@PathVariable(value = "firstName") String firstName) {
		return as.findByFirstName(firstName);
	}
}
