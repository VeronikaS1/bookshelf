package mk.fict.bookshelf.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
@Table(name = "digitalsources")
public class DigitalSource {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private Integer id;
	@NonNull
	@Column(name = "url", unique = true)
	private String url;
	@NonNull
	@Column(name = "format", nullable = false)
	private String format;
	@NonNull
	@Column(name = "pages", nullable = false)
	private Integer pages;
	@NonNull
	@ManyToOne
	@JoinColumn(name = "book_id", nullable = false)
	private Book book;
}
