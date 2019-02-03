package lyme.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Movie{
	
	@Id
	private int movieId;
	private String movieName;
	@Temporal (TemporalType.DATE)
	private Date movieDate;
	
	@ManyToMany (cascade = CascadeType.ALL)
	@JoinTable(name = "ActorsInMovies", joinColumns = { @JoinColumn(name = "movieId") }, inverseJoinColumns = { @JoinColumn(name = "actorId") })
	private Set<Actor> movieActors = new HashSet<>(0);
	
	@ManyToMany (cascade = CascadeType.ALL)
	@JoinTable(name = "GenresInMovies", joinColumns = { @JoinColumn(name = "movieId") }, inverseJoinColumns = { @JoinColumn(name = "genreId") })
	private Set<Genre> movieGenres = new HashSet<>(0);
	
	@OneToMany
	private Collection<Score> score = new ArrayList<>();
	
	public Set<Genre> getMovieGenres() {
		return movieGenres;
	}
	public void setMovieGenres(Set<Genre> movieGenres) {
		this.movieGenres = movieGenres;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public Date getMovieDate() {
		return movieDate;
	}
	public void setMovieDate(Date movieDate) {
		this.movieDate = movieDate;
	}

	public Set<Actor> getMovieActors() {
		return movieActors;
	}
	public void setMovieActors(Set<Actor> movieActors) {
		this.movieActors = movieActors;
	}
		
	
	
}