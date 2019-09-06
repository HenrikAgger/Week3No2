package moviefacade;

import entities.Movie;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class MovieFacade {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");

    public MovieFacade() {
    }

    public Movie findByID(long id) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Movie> query
                    = em.createQuery("Select m from Movie m where m.id =:id", Movie.class);
            query.setParameter("id", id);
            return query.getSingleResult();
        } finally {
            em.close();
        }
    }

    public List<Movie> findByTitle(String title) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Movie> query
                    = em.createQuery("Select m from Movie m where m.title = :title", Movie.class);
            query.setParameter("title", title);
            return query.getResultList();
        } finally {
            em.close();

        }
    }

    public List<Movie> findByPrice(String price) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Movie> query
                    = em.createQuery("Select m from Movie m where m.price = :price", Movie.class);
            query.setParameter("price", price);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

//    public int getNumberOfMovies() {
//        List<Movies> mv;
//        mv = allMovies();
//        return mv.size();
//    }

    public Movie addMovie(Movie movie) {
        try {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(movie);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return movie;
    }

    public void placeMovie(){
        addMovie(new Movie("Avengers", 99));
        addMovie(new Movie("Jurrasic World", 49));
        addMovie(new Movie("Equalizer 2", 69));
    }

}
