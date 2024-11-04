package mk.fict.bookshelf.service.implementation;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import mk.fict.bookshelf.domain.Genre;
import mk.fict.bookshelf.exception.ResourceNotFoundException;
import mk.fict.bookshelf.repository.GenreRepository;
import mk.fict.bookshelf.service.Service;

@org.springframework.stereotype.Service
@Transactional
public class GenreService implements Service<Genre, Integer> {

	@Autowired
	private GenreRepository grepo;

	@Override
	public List<Genre> findAll() {
		if (grepo.findAll().isEmpty()) {
			throw new ResourceNotFoundException("Entity Genre is empty");
		}
		return grepo.findAll();
	}

	@Override
	public Genre findById(Integer id) {
		Optional<Genre> genre = grepo.findById(id);
		if (genre.isPresent()) {
			return genre.get();
		}
		throw new ResourceNotFoundException("Genre with id: " + id + " is not present");
	}

	@Override
	public Genre create(Genre entity) {

		return grepo.save(entity);

	}

	@Override
	public Genre update(Integer id, Genre entity) {
		if (grepo.findById(id).isPresent()) {
			entity.setId(id);
			return grepo.save(entity);
		}
		throw new ResourceNotFoundException("Genre with id: " + id + " is not present");
	}

	@Override
	public void deleteById(Integer id) {
		Optional<Genre> genre = grepo.findById(id);
		if (genre.isEmpty()) {
			throw new ResourceNotFoundException("Genre with id: " + id + " is not present");

		}
		grepo.deleteById(id);
	}

}
