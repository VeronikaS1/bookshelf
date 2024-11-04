package mk.fict.bookshelf.service.implementation;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import mk.fict.bookshelf.domain.DigitalSource;
import mk.fict.bookshelf.exception.ResourceNotFoundException;
import mk.fict.bookshelf.repository.DigitalSourceRepository;
import mk.fict.bookshelf.service.Service;

@org.springframework.stereotype.Service
@Transactional
public class DigitalSourceService implements Service<DigitalSource, Integer> {

	@Autowired
	DigitalSourceRepository dsrepo;

	@Override
	public List<DigitalSource> findAll() {
		if (dsrepo.findAll().isEmpty()) {
			throw new ResourceNotFoundException("Entity DigitalSource is empty");
		}
		return dsrepo.findAll();
	}

	@Override
	public DigitalSource findById(Integer id) {
		Optional<DigitalSource> digitalSource = dsrepo.findById(id);
		if (digitalSource.isPresent()) {
			return digitalSource.get();
		}
		throw new ResourceNotFoundException("DigitalSource with id: " + id + " is not present");
	}

	@Override
	public DigitalSource create(DigitalSource entity) {
		return dsrepo.save(entity);
	}

	@Override
	public DigitalSource update(Integer id, DigitalSource entity) {
		if (dsrepo.findById(id).isPresent()) {
			entity.setId(id);
			return dsrepo.save(entity);
		}

		throw new ResourceNotFoundException("DigitalSource with id: " + id + " is not present");

	}

	@Override
	public void deleteById(Integer id) {
		Optional<DigitalSource> digitalSource = dsrepo.findById(id);
		if (digitalSource.isEmpty()) {
			throw new ResourceNotFoundException("DigitalSource with id: " + id + " is not present");
		}
		dsrepo.deleteById(id);
	}

}
