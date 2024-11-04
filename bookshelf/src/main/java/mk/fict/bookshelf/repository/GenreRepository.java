package mk.fict.bookshelf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mk.fict.bookshelf.domain.Genre;
@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer>{

}
