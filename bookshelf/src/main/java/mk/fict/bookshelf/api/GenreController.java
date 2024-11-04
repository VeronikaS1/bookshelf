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

import mk.fict.bookshelf.domain.Genre;
import mk.fict.bookshelf.infrastructure.Endpoints;
import mk.fict.bookshelf.service.implementation.GenreService;

@CrossOrigin
@RestController
@RequestMapping(Endpoints.GENRE)
public class GenreController {
	@Autowired
	private GenreService gs;

	@GetMapping
	public List<Genre> findAll() {
		return gs.findAll();
	}

	@GetMapping("/{id}")
	public Genre findById(@PathVariable(value = "id") Integer id) {
		return gs.findById(id);
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public Genre create(@RequestBody Genre entity) {

		return gs.create(entity);

	}

	@PutMapping("/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public Genre update(@PathVariable(value = "id", required = true) Integer id, @RequestBody Genre entity) {
		return gs.update(id, entity);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable(value = "id", required = true) Integer id) {
		gs.deleteById(id);
	}
}
