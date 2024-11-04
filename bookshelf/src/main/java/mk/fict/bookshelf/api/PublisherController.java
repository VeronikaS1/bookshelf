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

import mk.fict.bookshelf.domain.Publisher;
import mk.fict.bookshelf.infrastructure.Endpoints;
import mk.fict.bookshelf.service.implementation.PublisherService;

@CrossOrigin
@RestController
@RequestMapping(Endpoints.PUBLISHER)
public class PublisherController {

	@Autowired
	private PublisherService ps;

	@GetMapping
	public List<Publisher> findAll() {
		return ps.findAll();
	}

	@GetMapping("/{id}")
	public Publisher findById(@PathVariable(value = "id") Integer id) {
		return ps.findById(id);
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public Publisher create(@RequestBody Publisher entity) {

		return ps.create(entity);

	}

	@PutMapping("/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public Publisher update(@PathVariable(value = "id", required = true) Integer id, @RequestBody Publisher entity) {
		return ps.update(id, entity);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable(value = "id", required = true) Integer id) {
		ps.deleteById(id);
	}

	@GetMapping("/name/{name}")
	public Publisher findByFirstName(@PathVariable(value = "name") String name) {
		return ps.findPublisherByName(name);
	}
}
