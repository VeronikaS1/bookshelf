package mk.fict.bookshelf.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "books")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private Integer id;
	@NonNull
	@Column(name = "title", nullable = false)
	private String title;
	@NonNull
	@Column(name = "rating", nullable = false)
	private Integer rating;
	@NonNull
	@Column(name = "isbn", nullable = false , unique = true)
	private String isbn;
	@NonNull
	@Column(name = "published_date", nullable = false)
	private Date publishedDate;
	@NonNull
	@ManyToMany
	@JoinTable(name = "books_genres", joinColumns = @JoinColumn(name = "bookid"), inverseJoinColumns = @JoinColumn(name = "genreid"))
	private List<Genre> genres;
	@NonNull
	@ManyToOne
	@JoinColumn(name = "publisher_id")
	private Publisher publishers;
	@NonNull
	@ManyToMany
	@JsonIgnoreProperties("books")
	@JoinTable(name = "books_authors", joinColumns = @JoinColumn(name = "bookid"), inverseJoinColumns = @JoinColumn(name = "authorid"))
	private List<Author> authors;
	
}
