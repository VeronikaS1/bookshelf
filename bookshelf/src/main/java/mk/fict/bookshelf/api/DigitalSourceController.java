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

import mk.fict.bookshelf.domain.DigitalSource;
import mk.fict.bookshelf.infrastructure.Endpoints;
import mk.fict.bookshelf.service.implementation.DigitalSourceService;

@CrossOrigin
@RestController
@RequestMapping(Endpoints.DIGITALSOURCE)
public class DigitalSourceController {

	@Autowired
	DigitalSourceService dss;
	
	@GetMapping
	public List<DigitalSource> findAll() {
		return dss.findAll();
	}

	@GetMapping("/{id}")
	public DigitalSource findById(@PathVariable(value = "id") Integer id) {
		return dss.findById(id);
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public DigitalSource create(@RequestBody DigitalSource entity) {

		return dss.create(entity);

	}

	@PutMapping("/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public DigitalSource update(@PathVariable(value = "id", required = true) Integer id, @RequestBody DigitalSource entity) {
		return dss.update(id, entity);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable(value = "id", required = true) Integer id) {
		dss.deleteById(id);
	}
}
