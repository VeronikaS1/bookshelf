package mk.fict.bookshelf.infrastructure;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Endpoints {
	
	public static final String BASE = "/api/";
	public static final String BOOKS = BASE + "books/";
	public static final String AUTHORS = BASE + "authors/";
	public static final String DIGITALSOURCE = BASE + "digitalsources/";
	public static final String GENRE = BASE + "genres/";
	public static final String PUBLISHER = BASE + "publishers/";
	
}
