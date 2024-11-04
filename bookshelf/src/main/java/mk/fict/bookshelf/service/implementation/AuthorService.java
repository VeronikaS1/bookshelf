package mk.fict.bookshelf.service.implementation;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import mk.fict.bookshelf.domain.Author;
import mk.fict.bookshelf.exception.ResourceNotFoundException;
import mk.fict.bookshelf.repository.AuthorRepository;
import mk.fict.bookshelf.service.Service;

@org.springframework.stereotype.Service
@Transactional
public class AuthorService implements Service<Author, Integer> {

	@Autowired
	private AuthorRepository arepo;

	@Override
	public List<Author> findAll() {
		if (arepo.findAll().isEmpty()) {
			throw new ResourceNotFoundException("Entity Author is empty");
		}
		return arepo.findAll();
	}

	@Override
	public Author findById(Integer id) {
		Optional<Author> author = arepo.findById(id);
		if (author.isPresent()) {
			return author.get();
		}
		throw new ResourceNotFoundException("Author with id: " + id + " is not present");
	}

	@Override
	public Author create(Author entity) {
		return arepo.save(entity);

	}

	@Override
	public Author update(Integer id, Author entity) {
		if (arepo.findById(id).isPresent()) {
			entity.setId(id);
			return arepo.save(entity);
		}
		throw new ResourceNotFoundException("Author with id: " + id + " is not present");
	}

	@Override
	public void deleteById(Integer id) {
		if (arepo.findById(id).isEmpty()) {
			throw new ResourceNotFoundException("Author with id: " + id + " is not present");
		}
		arepo.deleteById(id);

	}

	public List<Author> findByFirstName(String firstName) {
		List<Author> authorList = arepo.findByFirstName(firstName);
		if (authorList.isEmpty()) {
			throw new ResourceNotFoundException("Author with first name : " + firstName + " is not present");
		}
		
		return arepo.findByFirstName(firstName);
	}

}
