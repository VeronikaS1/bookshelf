package mk.fict.bookshelf.service.implementation;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import mk.fict.bookshelf.domain.Publisher;
import mk.fict.bookshelf.exception.ResourceNotFoundException;
import mk.fict.bookshelf.repository.PublisherRepository;
import mk.fict.bookshelf.service.Service;

@org.springframework.stereotype.Service
@Transactional
public class PublisherService implements Service<Publisher, Integer> {

	@Autowired
	private PublisherRepository prepo;

	@Override
	public List<Publisher> findAll() {
		if (prepo.findAll().isEmpty()) {
			throw new ResourceNotFoundException("Entity Publisher is empty");
		}
		return prepo.findAll();
	}

	@Override
	public Publisher findById(Integer id) {
		Optional<Publisher> publisher = prepo.findById(id);
		if (publisher.isPresent()) {
			return publisher.get();
		}
		throw new ResourceNotFoundException("Publisher with id: " + id + " is not present");
	}

	@Override
	public Publisher create(Publisher entity) {
		return prepo.save(entity);
	}

	@Override
	public Publisher update(Integer id, Publisher entity) {

		if (prepo.findById(id).isPresent()) {
			entity.setId(id);
			return prepo.save(entity);

		}
		throw new ResourceNotFoundException("Publisher with id: " + id + " is present");

	}

	@Override
	public void deleteById(Integer id) {
		if (prepo.findById(id).isEmpty()) {
			throw new ResourceNotFoundException("Publisher with id: " + id + " is not present");
		}
		prepo.deleteById(id);

	}

	public Publisher findPublisherByName(String name) {
		Optional<Publisher> publisher = Optional.ofNullable(prepo.findPublisherByName(name));
		if(publisher.isPresent()) {
			return publisher.get();
		}
		throw new ResourceNotFoundException("Publisher with name: " + name + " is not present");
	}

}
