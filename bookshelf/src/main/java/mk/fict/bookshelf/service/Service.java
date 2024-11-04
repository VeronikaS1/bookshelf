package mk.fict.bookshelf.service;

import java.util.List;

@org.springframework.stereotype.Service
public interface Service<E, K> {
	
	public List<E> findAll();
	
	public E findById(K id);

	public E create(E entity);

	public E update(K id, E entity);

	public void deleteById(K id);
}
