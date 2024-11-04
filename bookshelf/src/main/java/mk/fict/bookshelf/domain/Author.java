package mk.fict.bookshelf.domain;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "authors")
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private Integer id;
	@NonNull
	@Column(name = "first_name", nullable = false)
	private String firstName;
	@NonNull
	@Column(name = "last_name", nullable = false)
	private String lastName;
	@NonNull
	@Column(name = "birth_year", nullable = false)
	private LocalDate birthYear;
	@Transient
	@JsonIgnore
	private Integer age;
	@ManyToMany(mappedBy = "authors")
	@JsonIgnoreProperties("authors")
	private List<Book> books;

	public Integer getAge() {
		return Period.between(this.birthYear, LocalDate.now()).getYears();
	}

}
