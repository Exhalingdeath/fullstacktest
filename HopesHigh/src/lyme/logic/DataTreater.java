package lyme.logic;

import java.util.ArrayList;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.List;

import lyme.domain.Movie;
import lyme.domain.MovieMaker;

public class DataTreater implements Middleman {
	public String fetchMovies(String sortby){
		List<Movie> movies = MovieMaker.getMovie(sortby);
		ObjectMapper mapper = new ObjectMapper();
		String temp = "[";
		try {
			for(int i = 0; i < movies.size()-1;i++) {
				temp+= mapper.writeValueAsString(movies.get(i)) +",";
			}
			temp+= mapper.writeValueAsString(movies.get(movies.size()-1)) + "]";
		} catch (JsonProcessingException e) {
            e.printStackTrace();
        }
		return temp;
	}
}
