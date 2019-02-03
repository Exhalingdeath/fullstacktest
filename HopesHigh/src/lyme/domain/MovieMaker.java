package lyme.domain;

import java.util.List;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class MovieMaker {
	public static int makeMovie() {
		Movie temp = new Movie();
		temp.setMovieId(7);
		temp.setMovieName("Matlib");
		
		
		temp.setMovieDate(Date.from(LocalDate.of(2017,12,5).atStartOfDay(ZoneId.systemDefault()).toInstant()));
		
		SessionFactory sessionFactory = SessionFac.getFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		try {
		session.saveOrUpdate(temp);
		session.getTransaction().commit();
		}
		finally {
			session.close(); 
		}
		
		
		return 0;
	}
	@SuppressWarnings("unchecked")
	public static List<Movie> getMovie(String sortby) {
		SessionFactory sessionFactory = SessionFac.getFactory();
		Session session = sessionFactory.openSession();
		
		String statement = "SELECT m from Movie m order by "+sortby;
		Query query = session.createQuery(statement);
		List<Movie> movies = query.list();
		
		return movies;
	}

}
